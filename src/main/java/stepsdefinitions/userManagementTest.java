package stepsdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import orange.pages.dashboardPage;
import orange.pages.loginPage;
import orange.pages.pimMenuPage;
import orange.piyushmain.Keyword;
import util.app;

public class userManagementTest {
	
	@Given("application url is launched")
	public void launchAppUrl() {
		Keyword keyword = new Keyword();
		keyword.launchBrowser("Chrome");
		keyword.launchUrl(app.getAppUrl("qa"));
	}
	
	@And("User is logged into system")
	public void loginToSystem() throws InterruptedException {
		loginPage loginpage = new loginPage();
		//loginpage.waitForUsernameToBeVisibile();
		Thread.sleep(3000);
		loginpage.enterPassword("admin123");
		loginpage.enterUsername("admin");
		loginpage.clickOnLoginBtn();
	}
	
	@When("User clicks on PIM Menu")
	public void user_clicks_on_pim_menu() throws InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		Thread.sleep(3000);
		dashboard.waitForPimMenuToBeVisibile();
		dashboard.clickOnPimMenu();
	}

	@And("Clicks on Add button")
	public void clicks_on_add_button() throws InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		Thread.sleep(3000);
		dashboard.waitForPimMenuToBeVisibile();
		dashboard.clickOnAddBtn();
	}

	@And("Creates one user with valid details")
	public void creates_one_user_with_valid_details() throws InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		Thread.sleep(3000);
		dashboard.EnterNameBoxes("Raghupati", "Raghav", "RajaRam");	
		dashboard.clickOnSaveBtn();
	}

	@When("user clicks on admin menu")
	public void user_clicks_on_admin_menu() {
		dashboardPage dashboard = new dashboardPage();
		dashboard.clickOnAdminMenu();	   
	}

	@And("Clicks on Add button on user management page")
	public void clicks_on_add_button_on_user_management_page() throws InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		Thread.sleep(3000);
		dashboard.clickOnAddBtn2();
	}

	@When("user selects role as ESS")
	public void user_selects_role_as_ess() throws InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		Thread.sleep(3000);
		dashboard.clickOnRole();
	}

	@And("clicks types employee name")
	public void clicks_types_employee_name() throws InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		Thread.sleep(3000);
		dashboard.enterTextNameCheck("Raghupati");
	}

	@Then("populated list must contains newly created user's name")
	public void populated_list_must_contains_newly_created_user_s_name() throws InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		Thread.sleep(3000);
		Assert.assertTrue(dashboard.checkli("Raghupati"));
	}
	
	@Then("close")
	public void close_the_browser() {
		Keyword.driver.quit();
	}

	
}