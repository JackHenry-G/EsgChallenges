# Customer API

This documentation provides an overview of the approach taken to build a Java application(s) that reads data from a CSV file, sends the data to a REST API endpoint in JSON format to store it in a SQL database from which the user can use different endpoints to retrieve the stored data.

The purpose of this small project is to efficiently manage customer information from a CSV file by persisting data effectively in a managed database and allowing interaction via a RESTful webservice.

## Usage

To effectively use and test this application, follow these steps.

Ensure you have docker installed for step 1.

Firstly, start the customers API server by:

1. Navigate to the 'customers' project directory. It should include the pom.xml and docker-compose file.
2. Build the project:

```
mvn clean install
```

3. Start the postgreSQL and spring-boot API server containers:

```
docker-compose up --build
```

Now, you could test it via HTTP requests using POSTMAN or the command line.

Or you could use the 'csvreader' app which will parse a ready made example customers.csv file and send a POST request to the customers api running locally on the docker containers.

- You will need JDK 21 and Maven installed.

## Architecture/approach

![image](https://github.com/JackHenry-G/EsgChallenges/assets/78259929/94cbb340-fbb4-41ba-ae27-7da0360441ea)

The Client-Server RESTful API approach has been taken, along with a PostgreSQL relational database, with the usage of two seperate projects:

1. Client - A simple Java application used to parse an example Customers.CSV file, convert the information to JSON and then send a POST HTTP request to the server.
2. Server - A Spring Boot API server to handle incoming requests, communicating with a PostgreSQL database to save and retrieve the customer information.

The Spring Boot Rest server can be deployed using the docker containers provided, whilst the CSVReader will be run manually to simulate a client.

### Endpoints

#### GET /customers

Retrieves all customers from the database.

Status Codes:

- 200 OK: The request was successful, and a list of newly created customer records is returned.
- 204 No Content: If the request body is empty or no customer records were saved.
- 500 Internal Server Error: An unexpected server error occurred.

#### GET /customers/customerRef

Gets the one, unqiue, specified custoemr object by the reference number.

Status Codes:

- 200 OK: The request was successful, and customer information is returned.
- 404 Not Found: If the requested customer reference does not exist in the database.
- 500 Internal Server Error: An unexpected server error occurred.

#### POST /customers:

Allows clients to save a list of customer records into the database.

Status Codes:

- 200 OK: The request was successful, and customer information is returned.
- 404 Not Found: If the requested customer reference does not exist in the database.
- 500 Internal Server Error: An unexpected server error occurred.
