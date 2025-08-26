# Complex-Task
# SauceDemo Login Automation

## Task Description
This project automates login functionality tests on [SauceDemo](https://www.saucedemo.com/) using **Java, Selenium WebDriver, JUnit, and Maven**.

### Test Cases
1. **UC-1** Login with empty credentials → Check error "Username is required".
2. **UC-2** Login with missing password → Check error "Password is required".
3. **UC-3** Login with valid credentials → Validate dashboard title "Swag Labs".

### Tools
- Selenium WebDriver
- Maven
- JUnit
- Browsers: Chrome & Edge
- XPath Locators

### Design Patterns
- **Singleton**: WebDriver instance (`DriverSingleton`)
- **Builder**: User credentials (`CredentialsBuilder`)
- **Decorator**: Logging actions (`LoggerDecorator`)

### Features
- Parallel execution
- Data-driven tests (JUnit parameterized)
- Logging with SLF4J
