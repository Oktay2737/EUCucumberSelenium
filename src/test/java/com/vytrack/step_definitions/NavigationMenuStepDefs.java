package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class NavigationMenuStepDefs {
    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        System.out.println("The user navigates to Fleet_Vehicles");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("Expected and actual titles are mathcing");
    }

    @When("the user navigates to Marketing, Campaigns")
    public void the_user_navigates_to_Marketing_Campaigns() {
        System.out.println("The user navigates to Marketing_Campaigns");
    }

    @Then("title should be Campaigns")
    public void title_should_be_Campaigns() {
        System.out.println("Expected and actual titles are mathcing");
    }

    @When("the user navigates to Activities, Calender Events")
    public void the_user_navigates_to_Activities_Calender_Events() {
        System.out.println("The user navigates to Activities_Calender_Events");
    }

    @Then("title should be Calenders")
    public void title_should_be_Calenders() {
        System.out.println("Expected and actual titles are mathcing");
    }

    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {

        ContactsPage contactsPage = new ContactsPage();
        BrowserUtils.waitForVisibility(contactsPage.pageNumber,15);
        Integer actualNumber =Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNum,actualNumber);
        BrowserUtils.waitFor(3);
    }

    @When("the user navigates to {string} \"Callender Events")
    public void the_user_navigates_to_Callender_Events(String string) {
        System.out.println("navigated to :"+ string);
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        System.out.println("userType = " + userType);
        //goto login page
        Driver.get().get(ConfigurationReader.get("url"));
        String username= null;
        String password = null;
        switch (userType){
            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "store manager":
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;
            case "sales manager":
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break;
        }
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        new LoginPage().login(username, password);
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        System.out.println("menu option size :"+menuOptions.size());
        System.out.println("menuOptions = " + menuOptions);
        List<String> actualOptions =BrowserUtils.getElementsText( new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userinfo )  {
        System.out.println(userinfo);
        new LoginPage().login(userinfo.get("username"),userinfo.get("password"));

        String acctualName = new DashboardPage().getUserName();
        String expectedName = userinfo.get("firstname")+" "+userinfo.get("lastname");

        System.out.println("acctualName :"+acctualName+" "+ "expectedName :"+expectedName);
        Assert.assertEquals(expectedName, acctualName);
    }

}
