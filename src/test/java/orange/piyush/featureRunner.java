package orange.piyush;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src\\test\\resources\\features", 
		glue="stepsdefinitions",
		dryRun = false,
		plugin = {
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
			     }
		)
public class featureRunner extends AbstractTestNGCucumberTests{
	
}
