package com.nat.facebook.qa;

import com.nat.facebook.qa.element.MenuElement;
import com.nat.facebook.qa.element.ExpandFormElement;
import com.nat.facebook.qa.element.PageElementFactory;
import com.nat.facebook.qa.element.SectionMenuElement;
import com.nat.facebook.qa.element.TabElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Navigation {
    @Autowired
    private PageElementFactory factory;
    @Autowired
    private WebDriver driver;
    @Value("${applicationURL}")
    private String applicationURL;

    public void clickMenuItem(String item) {
        ((MenuElement) factory.getElement(MenuElement.class, null)).clickMenuItem(item);
    }

    public void clickTabItem(String item) {
        ((TabElement) factory.getElement(TabElement.class, null)).clickTabItem(item);
    }

    public void clickSectionLinkItem(String item)
    {
        ((SectionMenuElement) factory.getElement(SectionMenuElement.class, null)).clickSectionItem(item);
    }

    public void clickExpandFormItem(int index) {
        ((ExpandFormElement) factory.getElement(ExpandFormElement.class, null)).clickExpandFormItem(index);
    }

    public void clickOkButton() {
        driver.findElement(By.id("ok-button")).click();
    }

    public void clickSaveButton() {
        driver.findElement(By.cssSelector("button[name='__submit__']")).click();
    }

    public void clickFirstEmployerItem() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".uiContextualLayerPositioner .uiContextualLayer [role='listbox'] [role='option']:first-child .lfloat > div")).click();
    }

    public void clickFirstSectionItem() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".uiContextualLayerPositioner .uiContextualLayer [role='listbox'] [role='option']:first-child")).click();
    }

    public WebElement findProfileExperience() {
        return driver.findElement(By.cssSelector("li.fbEditProfileViewExperience"));
    }

    public void openHomePage() {
        driver.get(applicationURL);
    }

    public void login(String username, String password) {
        driver.findElement(By.cssSelector("input[data-testid='royal_email']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[data-testid='royal_pass']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
    }

    public void SpecifyMandatoryFields(String fieldName, String fieldValue) {
        driver.findElement(By.cssSelector("input[type='text'][aria-autocomplete='list']")).sendKeys(fieldName);
        driver.findElement(By.cssSelector("input[type='text'][role='combobox'")).sendKeys(fieldValue);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }
}

