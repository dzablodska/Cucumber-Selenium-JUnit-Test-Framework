package com.nat.facebook.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.ExecutionException;

public class TabElement extends PageElement {
    private By tab = By.id("fbProfileCover");
    private WebElement wrapper;

    public TabElement(WebDriver driver) {
        super(driver);
        wrapper = driver.findElement(tab);
    }
    /**
     * Click the specified tab item.
     *
     * @param itemName - text of the item
     */
    public void clickTabItem(String itemName) {
        wrapper.findElement(By.cssSelector("[data-tab-key='" + itemName + "']")).click();
    }

}
