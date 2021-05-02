#!/bin/bash

mkdir -p app
rm -rf app/*

mvn clean package
cp script/*.sh app/
cp target/*.jar app/
cp src/main/resources/*.properties app
cp src/main/resources/facebook.txt app/