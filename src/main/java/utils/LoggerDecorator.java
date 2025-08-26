package utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDecorator {
    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LoggerDecorator.class);

    public LoggerDecorator(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        logger.info("Navigating to: {}", url);
        driver.get(url);
    }

    public String getTitle() {
        String title = driver.getTitle();
        logger.info("Page title is: {}", title);
        return title;
    }
}
