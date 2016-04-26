package com.cucumber;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.PageObject.LandingPage;
import com.cucumber.PageObject.MessagePage;
import com.cucumber.PageObject.PlanCreationPage;
import com.cucumber.PageObject.PlansPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatePlanStepDefinition {
	
	WebDriver driver;
	LandingPage landPage;
	PlansPage planPage;
	PlanCreationPage planCreationPage;
	MessagePage messagePage;
		
	@Given("^I am on trp site$")
	public void i_am_on_trp_site() throws Throwable {
		landPage = new LandingPage(driver);
		landPage.navigateToTRP();
	}

	@And("^Log on with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void log_on_with_user_and_password(String Usr, String Pwd) throws Throwable {
		landPage.logOnWithUser(Usr, Pwd);
	}

	@When("^I click PLANS work center$")
	public void i_click_PLANS_work_center() throws Throwable {
	    planPage = landPage.navigateToPlansWoC();
	}

	@And("^I click Create Plan button$")
	public void i_click_Create_Plan_button() throws Throwable {
		planPage.createNewPlan();
	}

	@And("^I select \"([^\"]*)\"$")
	public void i_select(String PlanType) throws Throwable {
		planCreationPage = planPage.selectPlanType(PlanType);
	}

	@And("^I enter \"([^\"]*)\" in Name field$")
	public void i_enter_in_Name_field(String Name) throws Throwable {
		planCreationPage.setName(Name);
	}

	@And("^I select \"([^\"]*)\" in Location Filter$")
	public void i_select_in_Location_Filter(String LocationFilter) throws Throwable {
		planCreationPage.setLocationFilter(LocationFilter);
	}

	@And("^I select \"([^\"]*)\" in Resource Filter$")
	public void i_select_in_Resource_Filter(String ResourceFilter) throws Throwable {
		planCreationPage.setResourceFilter(ResourceFilter);
		
	}

	@And("^I click Add button$")
	public void i_click_Add_button() throws Throwable {
		 planCreationPage.clickAddButton();
	}

	@And("^I select scheduled KPI plan \"([^\"]*)\"$")
	public void i_select_scheduled_KPI_plan(String ScheduledPlanName) throws Throwable {
		 planCreationPage.selectOneScheduledPlan(ScheduledPlanName);
	}

	@And("^I click Save button$")
	public void i_click_Save_button() throws Throwable {
		messagePage = planCreationPage.saveAndFinishCreation();
	}

	@Then("^I can find plan in the list$")
	public void i_can_find_plan_in_the_list() throws Throwable {
		Assert.assertTrue(messagePage.getMessage().contains("has been created"));
	}


}
