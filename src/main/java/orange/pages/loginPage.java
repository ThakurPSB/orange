package orange.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orange.piyushmain.Keyword;

public class loginPage {
	
	public loginPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	
	@FindBy(css="input[placeholder='Username']")
	WebElement usernameTxtBx;
	
	@FindBy(css="input.oxd-input[name=\"password\"]")		
	WebElement passwordTxtBx;
	
	@FindBy(css="button[type='submit']")
	WebElement loginBtn;
	
	public void enterUsername(String username) {
		usernameTxtBx.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtBx.sendKeys(password);
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	public void waitForLoad() {
	    wait = (Keyword.driver, 30).until((ExpectedCondition<Boolean>) wd ->
	            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	
	public void waitForUsernameToBeVisibile() {
		Keyword keyword = new Keyword();
		//waitForLoad();
		keyword.waitForElementToBeVisible(usernameTxtBx);
	}
	
	@FindBy(css="p.oxd-text.oxd-text--p.oxd-alert-content-text")
	WebElement loginError;
	
	public boolean loginerrorMessage() {
		String msg= loginError.getText();
		if(msg.contentEquals("Invalid credentials"))
			return true;
		else 
			return false;
	}
	
	public void AutoLogin() throws InterruptedException {
		loginPage login = new loginPage();
		login.waitForUsernameToBeVisibile();
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLoginBtn();
	}
	
	
	
}
