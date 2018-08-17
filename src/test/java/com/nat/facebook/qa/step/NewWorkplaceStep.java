package com.nat.facebook.qa.step;

import com.nat.facebook.qa.page.ProfilePage;
import com.nat.facebook.qa.page.HomePage;
import com.nat.facebook.qa.utils.DataStore;
import com.nat.facebook.qa.utils.DataTableExt;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class NewWorkplaceStep extends AbstractStep {

    @Autowired
    private ProfilePage profilePage;
    @Autowired
    private HomePage homePage;
    @Autowired
    private DataStore dataStore;
    @Autowired
    private DataTableExt dataTable;

    @And("^I open the Profile page$")
    public void openTheProfilePage() throws Throwable {
        homePage.getNavigation().clickMenuItem("profile_icon");
    }

    @When("^I click on About menu item$")
    public void clickOnAboutTab() throws Throwable {
        profilePage.getNavigation().clickTabItem("about");

    }

    @Then("^I click on Work and Education section link item$")
    public void clickOnWorkAndEducationLink() throws Throwable {
        profilePage.getNavigation().clickSectionLinkItem("nav_edu_work");
    }

    @And("^I click on Add a workplace button$")
    public void clickOnAddAWorkplaceButton() throws Throwable {
        profilePage.getNavigation().clickExpandFormItem(0);
    }


    @Given("^I login with with the following values:$")
    public void iLoginWithFollowingValues(DataTable table) throws Throwable {
        dataTable.setTable(table);
        homePage.getNavigation().openHomePage();
        String username = dataTable.getValue("Username");
        String password = dataTable.getValue("Password");
        dataStore.put("Username", username);
        dataStore.put("Password", password);
        homePage.getNavigation().login(username, password);
    }

    @And("^I specify mandatory fields with the following values:$")
    public void iSpecifyMandatoryFieldsWithTheFollowingValues(DataTable table) throws Throwable {
        dataTable.setTable(table);
        String fieldName = dataTable.getValue("Mandatory Field Name");
        String fieldValue = dataTable.getValue("Mandatory Field Value");
        dataStore.put("Mandatory Field Name", fieldName);
        dataStore.put("Mandatory Field Value", fieldValue);
        profilePage.getSectionItemTextFieldName(fieldName).enterText(fieldValue);
        profilePage.getNavigation().clickFirstEmployerItem();

    }

    @And("^I specify optional fields with the following values:$")
    public void iSpecifyOptionalFieldsWithTheFollowingValues(DataTable table) throws Throwable {
        dataTable.setTable(table);
        String fieldName = dataTable.getValue("Optional Field Name");
        String fieldValue = dataTable.getValue("Optional Field Value");
        dataStore.put("Optional Field Name", fieldName);
        dataStore.put("Optional Field Value", fieldValue);
        profilePage.getSectionItemTextFieldName(fieldName).enterText(fieldValue);
        profilePage.getNavigation().clickFirstSectionItem();
    }

    @And("^I click on save changes button$")
    public void saveChangesButton() throws Throwable {
        profilePage.getNavigation().clickSaveButton();
    }

    @Then("^I should see the following created New Workplace:$")
    public void verifyCreatedNewWorkpace (DataTable table) throws Throwable {
        dataTable.setTable(table);
        String mandatoryFieldExpectedValue = dataTable.getValue("Mandatory Field Value");
        String mandatoryFieldLocator = dataTable.getValue( "Mandatory Field Locator");
        profilePage.fluentWait(By.className("fbEditProfileViewExperience"));
        Assert.assertTrue("Employer name: expected to start with:" + mandatoryFieldExpectedValue +
                ", actual: " + profilePage.getNavigation().findProfileExperience().getText(),
                profilePage.getNavigation().findProfileExperience().getText().startsWith(mandatoryFieldExpectedValue));

    }
}
