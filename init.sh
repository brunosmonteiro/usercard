#!/bin/bash

mvn clean install
docker build -t usercard:beta .
docker-compose up