# Image Uploader Microservice

This project is a Java Spring Boot microservice that allows you to easily upload images to Google Cloud Storage (GCS). The microservice is built using Kotlin and follows best practices for Spring Boot applications. It provides a RESTful API endpoint for uploading images to a specified GCS bucket.

## Table of Contents

- [Image Uploader Microservice](#image-uploader-microservice)
	- [Table of Contents](#table-of-contents)
	- [Features](#features)
	- [Getting Started](#getting-started)
		- [Prerequisites](#prerequisites)
		- [Configuration](#configuration)
		- [Building and Running](#building-and-running)
			- [The microservice will be accessible at `localhost:8080`.](#the-microservice-will-be-accessible-at-localhost8080)
	- [API DOCUMENTATION](#api-documentation)
	- [TESTING](#testing)
	- [DOCKERIZATION](#dockerization)
	- [CONTRIBUTING](#contributing)
	- [LICENSE](#license)

## Features

- Upload images to a Google Cloud Storage bucket.
- Easy-to-use RESTful API for image uploads.
- Unit tests for main functionality.
- Dockerized for easy deployment.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following:

- Java Development Kit (JDK) 11 or higher installed
- Google Cloud Storage account and project set up
- Docker (optional, for Dockerization)

### Configuration

1. Clone this repository to your local machine.
2. Update the GCS bucket name in `ImageController.kt` to your desired GCS bucket.

### Building and Running

1. Open a terminal and navigate to the project directory.
2. Build the project using Gradle:

   ```sh
   ./gradlew build
	 ```
3. Run the microservice

    ```sh
    ./gradlew bootRun
          ```

#### The microservice will be accessible at `localhost:8080`.


## API DOCUMENTATION
The API allows you to upload images to a specified GCS bucket. The API endpoint is `/upload` and accepts a `POST` request with a `file` parameter containing the image to be uploaded. The API will return a JSON response with the URL of the uploaded image.

Example cURL request:

```sh
curl -X POST -F 'file=@/path/to/image.jpg' http://localhost:8080/upload
```

## TESTING
The project includes unit tests for the main functionality. To run the tests, use the following command:

```sh
./gradlew test
```

## DOCKERIZATION
The project includes a Dockerfile for easy deployment. To build the Docker image, use the following command:

```sh
docker build -t image-uploader .
```

To run the Docker image, use the following command:

```sh
docker run -p 8080:8080 image-uploader
```

## CONTRIBUTING
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## LICENSE
[MIT](https://choosealicense.com/licenses/mit/)

```vbnet
Feel free to use this Microservice in your projects.
```
