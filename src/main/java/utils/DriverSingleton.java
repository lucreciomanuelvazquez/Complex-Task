package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//this keeps a separate WebDriver instance for each thread
//so tests running in parallel do not interfere with each other
public class DriverSingleton {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //this keeps a separate WebDriver instance for each thread

    private DriverSingleton() {}
    //private constructor to prevent instantiation (creating objects of this class)

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            //if theres no driver for this thread, create one
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    //System.setProperty("webdriver.edge.driver", "C:\\Users\\LucrecioVazquez\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                    //this line is only needed if not using WebDriverManager
                    driver.set(new EdgeDriver());
                    break;
                default:
                    //if unsupported browser, throw exception
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
        }
        return driver.get(); //returns the same webdriver instance for the current thread
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit(); //quit the browser
            driver.remove(); //cleans up the ThreadLocal variable
        }
    }
    //DriverSingleton makes sure you only ever have one WebDriver instance per test thread.
    //It knows how to create, return, and close drivers for Chrome and Edge.
    //It implements the Singleton pattern with ThreadLocal for parallel safety.
}

