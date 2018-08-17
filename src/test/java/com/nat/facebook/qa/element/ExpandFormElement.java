package com.nat.facebook.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExpandFormElement extends PageElement {
    private By form = By.id("pagelet_edit_eduwork");
    private WebElement wrapper;

    public ExpandFormElement(WebDriver driver) {
        super(driver);
        wrapper = driver.findElement(form);
    }

    /**
     * Click the specified menu item.
     *
     * @param index - index of the item
     */
    public void clickExpandFormItem(int index) {
        wrapper.findElements(By.cssSelector(".fbProfileEditExperiences [role='button']")).get(0).click();
    }
}

