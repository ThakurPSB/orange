package orange.piyushmain.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import orange.piyushmain.Keyword;
import util.app;

public class testbase {
	
	@BeforeMethod
	public void setUp() throws Exception {
		Keyword keyword = new Keyword();
		keyword.launchBrowser("Chrome");
		keyword.launchUrl(app.getAppUrl("qa"));
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Keyword.driver.quit();
	}
}
