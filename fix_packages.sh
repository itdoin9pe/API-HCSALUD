#!/bin/bash

# 1. Cambiar nombres de carpetas con mayúsculas a minúsculas
find . -depth -type d | while read DIR; do
  NEWDIR=$(echo "$DIR" | sed 's/\([A-Z]\)/\L\1/g')
  if [ "$DIR" != "$NEWDIR" ]; then
    echo "Renombrando directorio: $DIR → $NEWDIR"
    mv "$DIR" "$NEWDIR"
  fi
done

# 2. Reemplazar los nombres de paquetes e imports en los .java
find . -type f -name "*.java" | while read FILE; do
  echo "Corrigiendo paquete en: $FILE"
  sed -i 's/com\.saludSystem/com.saludsystem/g' "$FILE"
  sed -i 's/com\.saludSystem/com.saludsystem/g' "$FILE"
  sed -i 's/com\.saludSystem/com.saludsystem/g' "$FILE"
done
