package trainline.framework;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trainline.pageobjects.ResultsPage;
import trainline.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParentScenario {
	
	private RemoteWebDriver driver;

    protected ResultsPage resultsPage;
    protected HomePage homePage;
       
    protected void startBrowser() throws MalformedURLException {
  
 
    	String node1URL = "http://10.0.0.4:4444/wd/hub";
	        DesiredCapabilities capability = DesiredCapabilities.chrome();
	    	
	    	capability.setBrowserName("chrome");
	    	driver = new RemoteWebDriver(new URL(node1URL), capability);
	        
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	       resultsPage = new ResultsPage(driver);
	       homePage = new HomePage(driver);   
	        
 
    	
    	String node2URL = "http://10.0.0.4:4444/wd/hub";
        DesiredCapabilities cap= DesiredCapabilities.firefox();
    	
    	cap.setBrowserName("firefox");
    	driver = new RemoteWebDriver(new URL(node2URL), cap);
    
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    	resultsPage = new ResultsPage(driver);
        homePage = new HomePage(driver);
       
    }
   

    protected void navigateTo() {
        driver.navigate().to("https://www.thetrainline.com/");
    }

    protected void acceptCookies(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,30000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
    
    protected void closeBrowser() {
        driver.quit();
    }



}
