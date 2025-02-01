package orange.piyush;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import orange.pages.dashboardPage;
import orange.pages.loginPage;
import orange.pages.pimMenuPage;
import orange.piyushmain.Keyword;
import orange.piyushmain.base.testbase;

import util.app;
import util.propertiesUtil;

public class AddUserTests extends testbase{
	
	@Test
	public void verifyIfNameOfAlreadyCreatedUserPopuplatesInListUsingKeyword() throws InterruptedException {
		
		Keyword keyword = new Keyword();
		
		keyword.waitForElementToBeVisible(By.cssSelector(propertiesUtil.getLocator("username")));
		keyword.enterText("css",propertiesUtil.getLocator("username"),app.getUsername("qa"));
		keyword.enterText("css",propertiesUtil.getLocator("password"),app.getPassword("qa"));
		keyword.clickOn("css",propertiesUtil.getLocator("submit"));
		
		keyword.waitForElementToBeVisible(By.cssSelector(propertiesUtil.getLocator("pimMenu")));
		keyword.clickOn("css",propertiesUtil.getLocator("pimMenu"));
		keyword.waitForElementToBeVisible(By.cssSelector(propertiesUtil.getLocator("addBtn")));
		keyword.clickOn("css",propertiesUtil.getLocator("addBtn"));
		
		keyword.waitForElementToBeVisible(By.cssSelector(propertiesUtil.getLocator("firstName")));
		keyword.enterText("css",propertiesUtil.getLocator("firstName"),"Hannah");
		keyword.enterText("css",propertiesUtil.getLocator("middleName"),"Gibs");
		keyword.enterText("css",propertiesUtil.getLocator("lastName"),"Mandana");
		
		keyword.waitForElementToBeVisible(By.cssSelector(propertiesUtil.getLocator("savebtn")));
		keyword.clickOn("css",propertiesUtil.getLocator("savebtn"));
		keyword.clickOn("css",propertiesUtil.getLocator("admin"));
		keyword.waitForElementToBeVisible(By.cssSelector(propertiesUtil.getLocator("addbtn2")));
		keyword.clickOn("css",propertiesUtil.getLocator("addbtn2"));
		
		keyword.waitForElementToBeVisible(By.cssSelector(propertiesUtil.getLocator("role")));
		keyword.clickOn("css",propertiesUtil.getLocator("role"));
		keyword.enterText("css",propertiesUtil.getLocator("role"), Keys.ARROW_DOWN);
		keyword.enterText("css",propertiesUtil.getLocator("role"), Keys.ARROW_DOWN);
		keyword.enterText("css",propertiesUtil.getLocator("role"), Keys.TAB);
		keyword.enterText("css",propertiesUtil.getLocator("nameCheck"), "Hannah");
		List<WebElement> names = Keyword.driver.findElements(By.xpath("//div[@role='option']/span"));
		boolean isfound = false;
		for(WebElement name: names) {
			if(name.getText().contains("Hannah")) {
				isfound = true;
			}
			Assert.assertTrue(isfound);
		}		
	}
	
	@Test
	public void verifyIfNameOfAlreadyCreatedUserPopuplatesInListUsingPom() throws InterruptedException {
		
		loginPage login = new loginPage();
		login.waitForUsernameToBeVisibile();
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLoginBtn();
		
		dashboardPage dashboard = new dashboardPage();
		dashboard.waitForPimMenuToBeVisibile();
		dashboard.clickOnPimMenu();
		dashboard.waitForAddBtn1ToBeVisibile();
		dashboard.clickOnAddBtn();
		dashboard.EnterNameBoxes("ram","lala", "bhagwan");
		dashboard.clickOnSaveBtn();
		dashboard.clickOnAdminMenu();
		dashboard.clickOnAddBtn2();
		dashboard.clickOnRole();
		dashboard.enterTextNameCheck("ram");
		Assert.assertTrue(dashboard.checkli("ram"));
	}
	
	@Test
	public void loginErrorMessageForInvalidCredentials() throws InterruptedException {
		loginPage login = new loginPage();
		login.waitForUsernameToBeVisibile();
		login.enterUsername("ddkkj");
		login.enterPassword("jjfl");
		login.clickOnLoginBtn();
		Assert.assertTrue(login.loginerrorMessage());
	}
	
	@Test
	public void SearchEmployeeInPIMModuleWithName() throws InterruptedException {
		loginPage login = new loginPage();
		login.AutoLogin();
		pimMenuPage pim = new pimMenuPage();
		pim.waitForPimMenuToBeVisibile();
		pim.clickOnPimMenu();
		pim.enterSearchName("Amelia");
		pim.clickOnSearchBtn();
		Assert.assertTrue(pim.getTextOfFirstFindnm().contains("Amelia"));
			
	}
	
	@Test
	public void SearchEmployeeInPIMModuleWithID() throws InterruptedException {
		loginPage login = new loginPage();
		login.AutoLogin();
		pimMenuPage pim = new pimMenuPage();
		pim.waitForPimMenuToBeVisibile();
		pim.clickOnPimMenu();
		pim.enterSearchID("0312");
		pim.clickOnSearchBtn();
		Assert.assertTrue(pim.getTextOfFirstFindid().contains("0312"));		
	}
	
	@Test
	public void checkIflogoutFreatureWorking() throws InterruptedException {
		loginPage login = new loginPage();
		login.AutoLogin();
		dashboardPage dashboard = new dashboardPage();
		dashboard.clickOnProfilePic();
		dashboard.clickOnLogoutBtn();
		Assert.assertEquals(dashboard.getCurrentURl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void checkingChangePasswordFeature() throws InterruptedException {
		loginPage login = new loginPage();
		login.AutoLogin();
		dashboardPage dashboard = new dashboardPage();
		dashboard.clickOnProfilePic();
		dashboard.clickOnChangePassword();
		dashboard.EnterCurrentPass("admin123");
		dashboard.EnterNewPass("admin123");
		dashboard.VerifyNewPass("admin123");
		dashboard.clickOnPassSaveBtn();
		dashboard.waitfortoast();
		Assert.assertEquals(dashboard.gettingAlertText(), "Successfully Saved");
	}
	
	
	
}

