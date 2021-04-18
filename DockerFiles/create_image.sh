#!/bin/bash

mkdir webapp7
cd webapp7 || exit
git clone https://github.com/CodeURJC-DAW-2020-21/webapp7
cd webapp7/backend || exit
cd docker || exit
sudo docker-compose up -d
