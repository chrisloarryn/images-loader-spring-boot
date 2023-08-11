#
# STAGE 1: prepare
#
FROM golang:1.20-alpine AS prepare

WORKDIR /app

## COPY vendor .
## ensure has git available for go get
RUN apk update && apk add --no-cache git

# create a folder called gcs-folder
RUN mkdir gcs-folder

# change the working directory to gcs-folder
WORKDIR /app/gcs-folder

# clone repo containing the go code for gcs (https://github.com/fsouza/fake-gcs-server)
RUN git clone https://github.com/fsouza/fake-gcs-server .

## download dependencies and make vendor folder
RUN go mod download
RUN go mod vendor

#
# STAGE 2: build
#
FROM prepare AS build
WORKDIR /app/gcs-folder

COPY . .

RUN CGO_ENABLED=0 go build -ldflags '-s -w' -o build/bin/gcs-service main.go

#
# STAGE 3: run
#
FROM scratch AS run

WORKDIR /app/gcs-folder

COPY --from=build /app/gcs-folder/build/bin/gcs-service /app/gcs-folder/

EXPOSE 8080

ENTRYPOINT [ "/app/gcs-folder/gcs-service" ]
#ENTRYPOINT [ "/app/cl-sipos-bff" ][]