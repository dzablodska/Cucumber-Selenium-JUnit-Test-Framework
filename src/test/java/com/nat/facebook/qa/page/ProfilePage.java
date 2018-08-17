package com.nat.facebook.qa.page;

import com.nat.facebook.qa.annotation.QAComponent;
import com.nat.facebook.qa.element.PageElement;
import com.nat.facebook.qa.element.RadioElement;
import com.nat.facebook.qa.element.SectionElement;
import com.nat.facebook.qa.element.TextElement;

@QAComponent
public class ProfilePage extends AbstractPage {

    public PageElement getAboutPageElement() {
        return factory.getElement(PageElement.class, getBy(BY_XPATH, "profilePage.aboutPageElement"));
    }

    public TextElement getSectionItemTextFieldName(String locatorName) {
        String locator = String.format("profilePage.%s",locatorName);
        return factory.getElement(TextElement.class, getBy(BY_CSS_SELECTOR, locator));
    }

    public SectionElement findSectionElement (String locatorName) {
        String locator = String.format("profilePage.%s",locatorName);
        return factory.getElement(SectionElement.class, getBy(BY_CSS_SELECTOR, locator));
    }
}

