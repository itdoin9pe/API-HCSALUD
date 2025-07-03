#!/bin/bash
echo "Esperando que SonarQube esté listo..."
while ! curl -s http://sonarqube:9000/api/system/status | grep -q '"status":"UP"'; do
  echo "Aún no disponible... esperando 5 segundos"
  sleep 5
done
echo "✅ SonarQube está listo."
