#!/bin/bash

path="$(dirname "$(realpath "$0")")"
jar="$(find ${path}/*.jar)"
java -jar ${jar}
