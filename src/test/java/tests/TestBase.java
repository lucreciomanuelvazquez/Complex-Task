package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverSingleton;
import utils.LoggerDecorator;

public class TestBase {
    protected WebDriver driver;
    protected LoggerDecorator logger;
    //test base class is an abstract foundation for all test classes

    @Before
    public void setUp() {
        //String browser = System.getProperty("browser", "chrome");
        String browser = System.getProperty("browser", "edge");
        //reads the browser type from a system property, defaulting to "edge" if not specified
        driver = DriverSingleton.getDriver(browser);
        logger = new LoggerDecorator(driver);
        logger.navigateTo("https://www.saucedemo.com/");
        //runs before each test method
        //initializes WebDriver ensures ONLY ONE WEB DRIVER INSTANCE IS CREATED (SINGLETON PATTERN)
        //initializes LoggerDecorator to add logging capabilities to WebDriver actions
        //wraps the WebDriver with LoggerDecorator for logging navigation and actions
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(5000); // espera 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverSingleton.quitDriver();
        //quits the WebDriver instance, closing the browser and cleaning up resources
    }
}

//mvn clean test
//mvn clean test -Dbrowser=chrome