# Maven Setup
In our project, we've implemented Maven to streamline our Java application development process.

## Adding Maven

To integrate Maven into our project, we first installed Maven on our development environment. We ensured that Maven was appropriately configured, including setting up environment variables if necessary.

## Project Restructuring

After installing Maven, we restructured our project to align with Maven's conventions. This involved organizing our source code, resources, and configuration files into the standard Maven directory structure (`src/main/java`, `src/test/java`, `src/main/resources`, etc.).

## Adding Maven Wrapper

To ensure consistency across development environments and to simplify setup for our team members, we incorporated Maven Wrapper into our project. Maven Wrapper allows us to maintain a specific version of Maven within our project repository, eliminating the need for developers to install Maven separately.

### Setup Commands

To set up Maven in your development environment and configure the Maven Wrapper for the project, follow these commands:

1. **Install Maven (if not already installed):**
   ```bash
   $ sudo apt-get install maven
(Replace apt-get with the appropriate package manager for your system.)

Restructure the project directory according to Maven conventions.

2. **Add Maven Wrapper to the project:**
```bash
    $ mvn -N io.takari:maven:wrapper
```
 
### Usage

Building the Project:
To build the project, run the following Maven command in the root directory of your project:

```bash
./mvnw clean install
```
This command compiles the source code, runs tests, and packages the application into a JAR file.

**Running Tests:**

To execute tests, use Maven's test phase:
```bash
Copy code
./mvnw test
```
Maven will run all tests in the project.

With Maven integrated and the project structured accordingly, we're now ready to efficiently manage dependencies, build, and package our Java application using Maven.