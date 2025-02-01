package orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.piyushmain.Keyword;

public class pimMenuPage {

	public pimMenuPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a > span")
	WebElement pimMenu;
	
	public WebElement waitForPimMenuToBeVisibile() {
		Keyword keyword = new Keyword();
		return keyword.waitForElementToBeClickable(pimMenu);
	}
	
	public void clickOnPimMenu() {
		pimMenu.click();
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input")
	WebElement searchName;
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement searchEmpId ;
	
	public void enterSearchName(String nm) {
		searchName.sendKeys(nm);
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
	WebElement searchBtn;
	
	public void enterSearchID(String id) {
		searchEmpId.sendKeys(id);
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div.oxd-table-body > div:nth-child(1) > div > div:nth-child(3)")
	WebElement firstFindnm ;
	
	public String getTextOfFirstFindnm() {
		return firstFindnm.getText();
	}
	
	@FindBy(css="#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div.oxd-table-body > div:nth-child(1) > div > div:nth-child(2)")
	WebElement firstFindId ;
	
	public String getTextOfFirstFindid() {
		return firstFindId.getText();
	}
	
}
