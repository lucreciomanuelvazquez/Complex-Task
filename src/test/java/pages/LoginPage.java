package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CredentialsBuilder.Credentials;

public class LoginPage {
    //this class represents the login page and its interactions, it follows the Page Object Model pattern
    //each web page is represented by a class
    //the class contains locators and methods to interact with the page

    private final WebDriver driver;

    private final By usernameField = By.xpath("//input[@id='user-name']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    //locators: for the username field, password field, login button, and error message using xpath
    //these are used to find elements on the page

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Constructor: injects the WebDriver instance to interact with the web page
    //this allows the test to control the browser session while keeping page-specific logic encapsulated in this class


    public void login(Credentials credentials) {
        driver.findElement(usernameField).sendKeys(credentials.getUsername());
        driver.findElement(passwordField).sendKeys(credentials.getPassword());
        driver.findElement(loginButton).click();
        //method to perform login using provided credentials
        //it fills in the username and password fields and clicks the login button
    }


    public void clearFields() {
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();
    }
    //method to clear the username and password fields

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    //method to retrieve the error message text displayed on the page

    //POM: Page Object Model: encapsulates page structure and behavior in a single class (locators + methods)
    //improves maintainability: if the page changes, only this class needs to be updated
    //tests are more readable
}
