package com.nat.facebook.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SectionMenuElement extends PageElement {
    private By section = By.cssSelector("[data-testid='info_section_left_nav']");
    private WebElement wrapper;

    public SectionMenuElement(WebDriver driver) {
        super(driver);
        wrapper = driver.findElement(section);
    }

    /**
     * Click the specified section item.
     *
     * @param itemName - text of the item
     */
    public void clickSectionItem(String itemName) {
        wrapper.findElement(By.cssSelector("[data-testid='" + itemName + "']")).click();
    }
}
