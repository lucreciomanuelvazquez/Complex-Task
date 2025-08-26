package tests;


import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import utils.CredentialsBuilder;

public class LoginTests extends tests.TestBase {

    @Test
    public void testUC1_EmptyCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearFields();
        loginPage.login(new CredentialsBuilder()
                .setUsername("")
                .setPassword("")
                .build());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test
    public void testUC2_MissingPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new CredentialsBuilder()
                .setUsername("anyuser")
                .setPassword("")
                .build());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
    }

    @Test
    public void testUC3_ValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new CredentialsBuilder()
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .build());
        Assert.assertEquals("Swag Labs", logger.getTitle());
    }
}

