package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CredentialsBuilder.Credentials;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameField = By.xpath("//input[@id='user-name']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(Credentials credentials) {
        driver.findElement(usernameField).sendKeys(credentials.getUsername());
        driver.findElement(passwordField).sendKeys(credentials.getPassword());
        driver.findElement(loginButton).click();
    }

    public void clearFields() {
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
