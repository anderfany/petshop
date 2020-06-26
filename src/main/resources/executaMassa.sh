#!/bin/bash

#Animais
while read line; do json=$(echo $line | cut -d';' -f1); cliente=$(echo $line | cut -d';' -f2); curl -v --location --request POST 'http://localhost:8080/clientes/${cliente}/animais' --header 'Content-Type: application/json' --data-raw '${json}'; echo ""; done < animais_massa

#Atendimentos
while read line; do curl -v --location --request POST 'http://localhost:8080/atendimentos' --header 'Content-Type: application/json' --data-raw '${line}'; echo ""; done < atendimentos_massa
