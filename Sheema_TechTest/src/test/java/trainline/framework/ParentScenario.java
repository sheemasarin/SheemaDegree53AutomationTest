package trainline.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trainline.pageobjects.ResultsPage;
import trainline.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ParentScenario {
	
	private WebDriver driver;

    protected ResultsPage resultsPage;
    protected HomePage homePage;

    protected void startBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
