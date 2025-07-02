pipeline {
    agent any

    environment {
        SPRING_PROFILES_ACTIVE = "prod"
        DB_URL = "jdbc:mysql://mysql:3306/db_sysalud"
        DB_USERNAME = credentials('db-username')         // <- ID creado en Jenkins
        DB_PASSWORD = credentials('db-password')         // <- ID creado en Jenkins
        JWT_SECRET = credentials('jwt-secret')           // <- ID creado en Jenkins
        JWT_EXPIRATION = "3600"
        JWT_REFRESH_EXPIRATION = "86400"
        FILE_UPLOAD_DIR = "./uploads"
    }

    stages {

        stage('Verificar Docker') {
            steps {
                sh 'docker --version'
                sh 'docker ps'
            }
        }

        stage('Checkout') {
            steps {
                git url: 'https://github.com/itdoin9pe/API-HCSALUD.git',
                    branch: 'main',
                    credentialsId: 'github-token'
            }
        }

        stage('Build y Análisis SonarQube') {
            steps {
                script {
                    docker.image('maven:3.8.6-eclipse-temurin-17').inside('--network=jenkins_net') {
                        withSonarQubeEnv('SonarServer') {
                            sh '''
                                mvn clean verify sonar:sonar \
                                -Dsonar.projectKey=sysSalud \
                                -Dsonar.java.binaries=target \
                                -Dsonar.host.url=http://sonarqube:9000 \
                                -DskipTests
                            '''
                        }
                    }
                }
            }
        }

        stage('Esperar Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Build Docker image') {
            steps {
                sh 'docker build -t syssalud-app .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                    docker stop syssalud-app || true
                    docker rm syssalud-app || true
                    docker run -d --name syssalud-app \
                        --network=jenkins_net \
                        -e DB_URL=$DB_URL \
                        -e DB_USERNAME=$DB_USERNAME \
                        -e DB_PASSWORD=$DB_PASSWORD \
                        -e JWT_SECRET=$JWT_SECRET \
                        -e JWT_EXPIRATION=$JWT_EXPIRATION \
                        -e JWT_REFRESH_EXPIRATION=$JWT_REFRESH_EXPIRATION \
                        -e SPRING_PROFILES_ACTIVE=$SPRING_PROFILES_ACTIVE \
                        -e FILE_UPLOAD_DIR=$FILE_UPLOAD_DIR \
                        -p 8081:8081 syssalud-app
                '''
            }
        }
    }
}
