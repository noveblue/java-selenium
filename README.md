
# Selenium Cucumber Java Testing Project

This project demonstrates automated web testing using Selenium WebDriver with Cucumber in Java. It covers various testing scenarios for a web application, including performance, automation, security, usability, and API testing, among others.

## Project Structure

- `TestRunner.java`: Initializes the Cucumber test runner.
- `Steps.java`: Contains step definitions for Cucumber feature files, matching steps to Java code.
- `Locators.java`: Stores XPath locators for UI elements to be interacted with during tests.
- `AccountData.java`: Holds static data used across tests, like user credentials and personal information.

## Prerequisites

- Java Development Kit (JDK) installed.
- Maven for dependency management.
- ChromeDriver (or any WebDriver compatible with your browser of choice).

## Setup

1. Ensure Java and Maven are installed and configured on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory and run `mvn clean install` to install dependencies.

## Running Tests

To run the test suite, execute the following command in the terminal from the project's root directory:

```
mvn test
```

This command will trigger the `TestRunner` class, which is set up to find and run all Cucumber feature files with the corresponding step definitions in the `Steps.java` file.

## Customization

- **Adding New Tests**: To add new tests, create a new `.feature` file in `src/test/resources/Features` and define your scenarios. Then, add or update step definitions in `Steps.java` as needed.
- **Modifying Test Data**: Update `AccountData.java` to change the static data used across tests.

## Note

Ensure the WebDriver executable (e.g., `chromedriver.exe` for Chrome) is located in the `src/test/resources/drivers` directory or is set in your system's PATH.
