#!/usr/bin/env bash

echo ----------------------------------
echo --------Install RebittMQ----------
echo ----------------------------------

wget -O - 'https://dl.bintray.com/rabbitmq/Keys/rabbitmq-release-signing-key.asc' | sudo apt-key add -
echo "deb https://dl.bintray.com/rabbitmq/debian bionic main" | sudo tee /etc/apt/sources.list.d/bintray.rabbitmq.list
sudo apt-get update
sudo apt-get install rabbitmq-server

echo ----------------------------------
echo ----Install RebittMQ Uplugins-----
echo ----------------------------------

rabbitmq-plugins enable rabbitmq_management

