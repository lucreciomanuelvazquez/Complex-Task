package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverSingleton;
import utils.LoggerDecorator;

public class TestBase {
    protected WebDriver driver;
    protected LoggerDecorator logger;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // default chrome
        driver = DriverSingleton.getDriver(browser);
        logger = new LoggerDecorator(driver);
        logger.navigateTo("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(5000); // espera 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverSingleton.quitDriver();
    }

}

//mvn clean test
//mvn clean test -Dbrowser=edge
