## Allane's 'leasing-contract-APIs'
This source code is an Spring-Boot based Application.
 
Tested with following
* Java 8 or Java 11
* Spring-Boot 2.7.3
* Gradle
* MySQL Database
* Swagger Open-API for Rest APIs design, documentation and testing.
* Junit Tests
* In order to test this application at the target system, need to update the configurations in the application.properties file of this project.

## How to build and run this project?
```bash
// 1.a To clean project, run below gradle command.
$ gradle clean 

// 2. To build project and generate jar file, run below gradle command.
$ gradle build 

// 3. To run unit test-cases, run below gradle command.
$ gradle test 

// 4. To run this project as spring-boot stand-alone application, using below command.
$ gradle bootRun 

// 4. Hit the URL below in browser to access the application. This will open the swagger document, on this client you can test the end-point of the product.
$ http://localhost:8080
```

## POST Method /contract create leasing-contract REST-API tested samples:
API End point: http://localhost:8080/api/v1.0/contract/

```bash
curl -X 'POST' \
  'http://localhost:8080/api/v1.0/contract' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d ' {
    "customer": {
      "firstName": "Markus",
      "lastName": "ABC",
      "birthdate": "1998-09-28"
    },
    "contractNumber": 100,
    "monthlyRate": 550,
    "vehicle": {
      "brand": "BMW",
      "model": "Series 3",
      "modelYear": 2005,
      "vin": "XYZ 12345",
      "price": 20000
    }
  }'
```
## GET Method /contract fetch leasing-contract by Id REST-API tested samples:
API End point: http://localhost:8080/api/v1.0/contract/{identifier}

```bash
curl -X 'GET' \
  'http://localhost:8080/api/v1.0/contract/7' \
  -H 'accept: */*'
```

## GET Method /contract fetch all leasing-contracts REST-API tested samples:
API End point: http://localhost:8080/api/v1.0/contract/

```bash
curl -X 'GET' \
  'http://localhost:8080/api/v1.0/contract' \
  -H 'accept: */*'
```
## DELETE Method /contract delete leasing-contract by Id REST-API tested samples:
API End point: http://localhost:8080/api/v1.0/contract/{identifier}

```bash
curl -X 'DELETE' \
  'http://localhost:8080/api/v1.0/contract/7' \
  -H 'accept: */*'
```
## PUT Method /contract update leasing-contract REST-API tested samples:
API End point: http://localhost:8080/api/v1.0/contract/{identifier}

```bash
curl -X 'PUT' \
  'http://localhost:8080/api/v1.0/contract/10' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d ' {
    "customer": {
      "firstName": "Markus",
      "lastName": "ABC",
      "birthdate": "1998-09-28"
    },
    "contractNumber": 12345,
    "monthlyRate": 400,
    "vehicle": {
      "brand": "BMW",
      "model": "Series 4",
      "modelYear": 2010,
      "vin": "BMW 12345",
      "price": 25000
    }
  }'
```