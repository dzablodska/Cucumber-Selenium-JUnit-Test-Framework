package com.nat.facebook.qa.page;

import com.google.common.base.Function;
import com.nat.facebook.qa.Navigation;
import com.nat.facebook.qa.PropertiesManager;
import com.nat.facebook.qa.element.PageElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected PageElementFactory factory;
    @Autowired
    protected Navigation navigation;
    @Autowired
    protected PropertiesManager propertiesManager;

    public static final int BY_CLASS_NAME = 0;
    public static final int BY_CSS_SELECTOR = 1;
    public static final int BY_ID = 2;
    public static final int BY_LINK_TEXT = 3;
    public static final int BY_NAME = 4;
    public static final int BY_PARTIAL_LINK_TEXT = 5;
    public static final int BY_TAG_NAME = 6;
    public static final int BY_XPATH = 7;

    public Navigation getNavigation() {
        return navigation;
    }

    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return  foo;
    };

    protected By getBy(int type, String locator) {
        By result;
        String name = propertiesManager.get(locator);
        switch (type) {
            case BY_CLASS_NAME:
                result = By.className(name);
                break;
            case BY_CSS_SELECTOR:
                result = By.cssSelector(name);
                break;
            case BY_ID:
                result = By.id(name);
                break;
            case BY_LINK_TEXT:
                result = By.linkText(name);
                break;
            case BY_NAME:
                result = By.name(name);
                break;
            case BY_PARTIAL_LINK_TEXT:
                result = By.partialLinkText(name);
                break;
            case BY_TAG_NAME:
                result = By.tagName(name);
                break;
            case BY_XPATH:
                result = By.xpath(name);
                break;
            default:
                throw new IllegalArgumentException("By type " + type + " is not found.");
        }
        return result;
    }
}
