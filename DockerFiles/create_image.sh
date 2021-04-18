#!/bin/bash

mkdir webapp7

cd webapp7 || exit

git clone https://github.com/CodeURJC-DAW-2020-21/webapp7

cd webapp7/backend || exit
docker run --rm -e MYSQL_ROOT_PASSWORD=webapp7 -e MYSQL_DATABASE=kiddyshouse -p 3306:3306 -d mysql:8.0.22
docker build -t webappy/webapp7 .
docker push webapp7/webapp7:latest
docker pull webapp7/webapp7
docker run webapp7/webapp7
docker-compose up -d --build
