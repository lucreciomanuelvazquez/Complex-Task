package utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//adds a layer of logging to WebDriver actions

public class LoggerDecorator {
    private final WebDriver driver;
    //the actual WebDriver instance being wrapped
    private static final Logger logger = LoggerFactory.getLogger(LoggerDecorator.class);
    //SLF4J logger for logging messages


    public LoggerDecorator(WebDriver driver) {
        this.driver = driver;
    }
    //constructor takes a WebDriver instance to wrap

    public void navigateTo(String url) {
        logger.info("Navigating to: {}", url);
        driver.get(url);
    }
    //you can see exactly what URL you are navigating to in the logs

    public String getTitle() {
        String title = driver.getTitle();
        logger.info("Page title is: {}", title);
        return title;
    }
    //you can see the page title in the logs

    //this keeps logging logic separate from WebDriver logic
    //making it easier to maintain and extend and also debug


}
