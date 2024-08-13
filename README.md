Asobu HTTP Server
Asobu is a simple, lightweight HTTP server built from scratch using Java. It is designed to handle multiple client requests efficiently, making use of multithreading and sockets. The server can parse incoming requests, return appropriate status codes and headers, and supports various HTTP methods.

Features
Multi-threaded Request Handling: Asobu can manage multiple client connections simultaneously using Java's multithreading capabilities.
Socket-Based Communication: Utilizes Java sockets to listen for and respond to HTTP requests.
Request Parsing: Parses incoming HTTP requests to extract headers, body, and method.
HTTP Methods Supported: Asobu supports a variety of HTTP methods including GET, POST, PUT, DELETE, and more.
Status Codes and Headers: Returns appropriate HTTP status codes and headers in response to client requests.
Technologies Used
Java: The core programming language used for building the server.
Maven: Dependency management and project build tool.
Jackson Core & Databind: Used for parsing and generating JSON data.
Getting Started
Prerequisites
Java 8 or higher
Maven
Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/yourusername/asobu.git
cd asobu
Build the Project:

Run the following command to build the project using Maven:

bash
Copy code
mvn clean install
Run the Server:

Start the server by executing:

bash
Copy code
java -jar target/asobu-1.0-SNAPSHOT.jar
Usage
Once the server is running, you can send HTTP requests to it using tools like curl, Postman, or directly from your browser.

Example:

bash
Copy code
curl -X GET http://localhost:8080
Project Structure
src/main/java/com/httpserver/: Contains the core server logic, including request handling, multithreading, and response generation.
src/main/resources/: Configuration files and static resources.
Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue if you find any bugs or have suggestions for improvements.

License
This project is licensed under the MIT License - see the LICENSE file for details.
