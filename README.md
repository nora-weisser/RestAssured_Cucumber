# RestAssured_Cucumber

## Overview

This repository provides an example of how to automate API testing using **RestAssured** in combination with **Cucumber**. The framework leverages the power of BDD (Behavior Driven Development) to make the API tests more readable and understandable, even for non-technical stakeholders.

## Table of Contents

- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Writing Tests](#writing-tests)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [Logging](#logging)

## Project Structure
    .
    ├── src
        ├── main  
        │     └── java
                    └── pojoClasses
        └── test         
        │   └── java
                    ├── cucumber.Options   # Contains the Cucumber test runner class responsible for executing feature files.
                    ├── features        # Contains the feature files written in Gherkin syntax.
                    ├── resources       # Contains configuration files like `config.properties` to manage environment-specific variables and different kinds of utilities.
                    └── stepDefinitions # Contains the step definitions that map the Gherkin steps in the feature files to Java methods.
### Prerequisites

- **Java 8+**: Make sure Java is installed and properly set up in your environment.
- **Maven**: Ensure that Maven is installed and configured.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/nora-weisser/RestAssured_Cucumber.git
   cd RestAssured_Cucumber

2. Build the project and install dependencies:
   ```bash
   mvn clean install

### Dependencies

This framework uses several key dependencies which are specified in the pom.xml file:

* RestAssured: Popular Java library used to simplify the process of testing REST APIs. It allows you to make HTTP requests and validate responses easily.
* Cucumber: Provides the necessary classes to write step definitions in Java for Cucumber tests. It is the core library required to define and execute BDD-style tests.
* Cucumber JUnit: Allows Cucumber to run tests using the JUnit framework. This is essential for executing Cucumber scenarios and generating test reports.
* JUnit: Widely used testing framework for Java. It is used in this project as the underlying framework for running unit tests and integrating with Cucumber.
* Jackson Databind: Used to map JSON data to Java objects and vice versa. It is crucial for handling JSON payloads in API testing.
* Groovy: Powerful, optionally typed, and dynamic language that runs on the JVM. It is included in this project to enable scripting and dynamic aspects of API testing.

## Writing Tests
### Feature Files
Feature files are written using the Gherkin syntax and are stored in the features directory. Below is an example from the `placeValidations.feature` file:

```
Feature: Validating Place APIs
  @AddPlace
  Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place Id created maps to "<name>" using "getPlaceAPI"

    Examples:
    | name  | language | address           |
    |AAhouse| English  | World Cross Center|
    |BBhouse| Spanish  | Sea Cross Center  |
```
### Step Definitions
The step definitions are written in Java and located in the steps package. These methods are annotated with Cucumber's Given, When, Then annotations to link them to the corresponding Gherkin steps.

Example from `StepDefinition.java`file:

```
    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        res = given().spec(RequestSpecification())
                .body(data.addPlacePayload(name, language, address));
    }
```

## Running Tests
You can run the tests using Maven. The test runner is defined in TestRunner.java, which is configured to execute all feature files in the features directory.

To run the tests, use:
```
mvn test
```

## Reporting
After executing the tests, Cucumber automatically generates reports that provide detailed insights into the test execution. The reports are stored in the target directory:
* JSON Report: Located in target/jsonReports, this report contains detailed, machine-readable information about each test scenario, including step-by-step execution results and metadata. This format is particularly useful for integrating with CI/CD pipelines or for further processing.
* HTML Report: Located in target/cucumber-html-reports, this report presents the test results in a user-friendly, visual format. It includes a comprehensive summary of passed and failed scenarios, along with detailed logs for each step, making it easy to analyze the test outcomes in a web browser.

These reports provide valuable insights into the quality and behavior of the APIs under test, helping you quickly identify issues and share results with stakeholders.

## Logging

Detailed logs are captured and stored in the `logging.txt` file, providing insights for troubleshooting and debugging your test cases. These logs offer a detailed record of the API requests and responses, making it easier to identify and resolve issues efficiently.
