pipeline {
    agent any

    environment {
        SPRING_PROFILES_ACTIVE = "prod"
        DB_URL = "jdbc:mysql://mysql:3306/db_sysalud"
        DB_USERNAME = "root"
        DB_PASSWORD = "giangodisinyou2"
        JWT_SECRET = "fb3185950296da2445c1837ffc09f771feb47650d4ca97a8029c663bbab0dbcc"
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

        stage('Análisis con SonarQube') {
            steps {
                script {
                    docker.image('maven:3.8.6-eclipse-temurin-17').inside('--network=jenkins_net') {
                        withSonarQubeEnv('SonarServer') {
                            sh '''
                                mvn clean verify sonar:sonar \
                                -Dsonar.projectKey=sysSalud \
                                -Dsonar.java.binaries=target \
                                -DskipTests \
                                -Dsonar.host.url=http://sonarqube:9000
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

        stage('Build con Maven') {
            steps {
                script {
                    docker.image('maven:3.8.6-eclipse-temurin-17').inside {
                        sh 'mvn clean package -DskipTests'
                    }
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
