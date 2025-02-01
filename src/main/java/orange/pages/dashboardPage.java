package orange.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.piyushmain.Keyword;

public class dashboardPage {
	
	public dashboardPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a")
	WebElement pimMenu;
	
	public void clickOnPimMenu() {
		pimMenu.click();
	}
	
	public WebElement waitForPimMenuToBeVisibile() {
		Keyword keyword = new Keyword();
		return keyword.waitForElementToBeVisible(pimMenu);
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a > span")
	WebElement adminMenu;
	
	public void clickOnAdminMenu() {
		adminMenu.click();
	}
	
	@FindBy(css="a[href*='LeaveMod']")
	WebElement leaveMenu;
	
	@FindBy(css="button[class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbtn1;
	
	public WebElement waitForAddBtn1ToBeVisibile() {
		Keyword keyword = new Keyword();
		return keyword.waitForElementToBeVisible(addbtn1);
	}
	
	public void clickOnAddBtn() {
		addbtn1.click();
	}
		
	@FindBy(css="input[placeholder='First Name']")
	WebElement fname;
	
	@FindBy(css="input[placeholder='Middle Name']")
	WebElement mname;
	
	@FindBy(css="input[placeholder='Last Name']")
	WebElement lname;
	
	public void EnterNameBoxes(String fn, String mn, String ln) throws InterruptedException {
		fname.sendKeys(fn);
		//Keyword.wait.wait(1000);
		mname.sendKeys(mn);
		//Keyword.wait.wait(1000);
		lname.sendKeys(ln);
	}
	
	@FindBy(css="button[type='submit']")
	WebElement saveBtn;
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button")
	WebElement addBtn2;
	
	public void clickOnAddBtn2() {
		addBtn2.click();
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div.oxd-select-text-input")
	WebElement role;
	
	public void clickOnRole() {
		role.click();
		role.sendKeys(Keys.ARROW_DOWN);
		role.sendKeys(Keys.ARROW_DOWN);
		role.sendKeys(Keys.TAB);
	}
	
	@FindBy(css="input[placeholder='Type for hints...']")
	WebElement nameCheck;
	
	public void enterTextNameCheck(String name) {
		nameCheck.sendKeys(name);
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > div.oxd-autocomplete-dropdown.--positon-bottom")
	List<WebElement> li;
	
	public boolean checkli(String chknm) {
		boolean isTrue=false;
		for(WebElement l: li) {
			System.out.println(l.getText());
			if(l.getText().contains(chknm))
			isTrue = true;
		}return isTrue;
	}
	
	@FindBy(css="img.oxd-userdropdown-img")
	WebElement  profile;
	
	public void clickOnProfilePic() {
		profile.click();
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-userarea > ul > li > ul > li:nth-child(4) > a")
	WebElement  logoutBtn;
	
	public void clickOnLogoutBtn() {
		logoutBtn.click();
	}
	
	public String getCurrentURl() {
		String s = Keyword.driver.getCurrentUrl();
		return s;
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-userarea > ul > li > ul > li:nth-child(3) > a")
	WebElement changePass ;
	
	public void clickOnChangePassword() {
		changePass.click();
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement currentPass ;
	
	public void EnterCurrentPass(String cpass) {
		currentPass.sendKeys(cpass);
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input")
	WebElement newPass ;
	
	public void EnterNewPass(String npass) {
		newPass.sendKeys(npass);
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement verifynpass ;
	
	public void VerifyNewPass(String vpass) {
		verifynpass.sendKeys(vpass);
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
	WebElement passSaveBtn;
	
	public void clickOnPassSaveBtn() {
		passSaveBtn.click();
	}
	
	@FindBy(css=".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
	WebElement toast ;
	
	public WebElement waitfortoast() {
		Keyword keyword = new Keyword();
		return keyword.waitForElementToBeVisible(toast);
	}
	
	public String gettingAlertText() {
		return toast.getText();	
	}
	
}
























