package com.nat.facebook.qa.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

public class DriverProvider {

    @Value("${chromepath}")
    private String chromePath;
    private static WebDriver driver;

    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", chromePath);
        if (null == driver) {
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        }
        return driver;
    }

    @PreDestroy
    public void close() {
        driver.quit();
    }
}
