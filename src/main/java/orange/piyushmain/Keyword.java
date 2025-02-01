package orange.piyushmain;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import orange.piyushmain.Errors.invalidBrowserError;

public class Keyword {
	
	public static RemoteWebDriver driver = null;
	public static FluentWait<WebDriver> wait =null;
	
	private static final Logger LOG = Logger.getLogger(Keyword.class);
	
	public void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			LOG.info("Launched Chrome Browser");
		} else if(browserName.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
			LOG.info("Launched Edge Browser");
		} else if(browserName.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
			LOG.info("Launched firefox Browser");
		} else {
			throw new invalidBrowserError(browserName);
		}
		wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		
	}
	
	public WebElement waitForElementToBeVisible(By by) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by);
	}
	
	public void launchUrl(String url) {
		driver.get(url);
	}
	
	
	public void enterText(String locatorType, String locator, String textToEnter) {
		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locator)).sendKeys(textToEnter);
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(textToEnter);
		}else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(textToEnter);
		}else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(textToEnter);
		}else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(textToEnter);
		}else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(textToEnter);
		}else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(textToEnter);
		}else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).sendKeys(textToEnter);
		}else {
			throw new InvalidSelectorException(locatorType);
		}
	
	}
	
	/**
	 * This method accepts the keys press
	 * @param locator
	 * @param x
	 */
	public void enterText(String locatorType, String locator, CharSequence x) {
		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locator)).sendKeys(x);
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(x);
		}else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(x);
		}else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(x);
		}else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(x);
		}else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(x);
		}else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(x);
		}else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).sendKeys(x);
		}else {
			throw new InvalidSelectorException(locatorType);
		}
	}
	
	/**
	 * Use this method to click on {@code WebElement} by its xpath. This method doesnt support other locator strategies.
	 * @param locator
	 */
	public void clickOn(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	
	/**
	 * Use this method to click on any {@code WebElement}. you need to provider locator-type and locator-value.  
	 * @param locatorType that is one of the following: id, name, tagname, classname, linktext etc. 
	 * @param locatorValue
	 */
	public void clickOn(String locatorType, String locatorValue) {
		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}else if (locatorType.equalsIgnoreCase("classname")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		}else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}


