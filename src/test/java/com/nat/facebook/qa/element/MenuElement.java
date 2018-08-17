package com.nat.facebook.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class MenuElement extends PageElement {
    private By menu = By.id("pagelet_bluebar");
    private WebElement wrapper;

    public MenuElement(WebDriver driver) {
        super(driver);
        wrapper = driver.findElement(menu);
    }

    /**
     * Click the specified menu item.
     *
     * @param itemName - text of the item
     */
    public void clickMenuItem(String itemName) {
        wrapper.findElement(By.cssSelector("*[data-click='" + itemName + "']")).click();
    }

}
