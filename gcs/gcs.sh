#!/bin/bash

docker run -d --name fake-gcs-server -p 4443:4443 fsouza/fake-gcs-server

