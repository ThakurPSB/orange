package stepsdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import orange.piyushmain.Keyword;
import util.app;

public class hooks {

	@Before
	public void setUp() throws Exception {
		Keyword keyword = new Keyword();
		keyword.launchBrowser("Chrome");
		keyword.launchUrl(app.getAppUrl("qa"));
	}
	
	@After
	public void tearDown() throws Exception {
		Keyword.driver.quit();
	}
}
