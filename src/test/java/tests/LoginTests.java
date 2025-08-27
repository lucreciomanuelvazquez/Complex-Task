package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import utils.CredentialsBuilder;

public class LoginTests extends tests.TestBase {
    //this class contains the actual test cases for login functionality
    //it extends TestBase to inherit setup and teardown logic

    @Test
    public void testUC1_givenEmptyCredentials_whenLogin_thenShowUsernameIsRequired() {
    //public void testUC1_EmptyCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        //clear any pre-filled data
        loginPage.clearFields();
        loginPage.login(new CredentialsBuilder()
                .setUsername("")
                .setPassword("")
                .build());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }


    @Test
    public void testUC2_givenUsernameWithoutPassword_whenLogin_thenShowPasswordIsRequired() {
        //public void testUC2_MissingPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new CredentialsBuilder()
                .setUsername("anyuser")
                .setPassword("")
                .build());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
        // handles missing passwords
    }

    @Test
    public void givenValidCredentials_whenLogin_thenUserIsRedirectedToSwagLabs() {
        //public void testUC3_ValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new CredentialsBuilder()
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .build());
        Assert.assertEquals("Swag Labs", logger.getTitle());
        //verifies that the page title after login is "Swag Labs", indicating a successful login



        //builder pattern: clean credentials creation
        //POM: encapsulates page interactions (loginPage.login)
        //logger: logs navigation and title retrieval
        //decorator pattern: logging page actions & results (logger.getTitle())
    }
}

