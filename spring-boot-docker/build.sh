#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true

docker build -t spring-boot-docker:latest .