package trainline.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink(String text) {
        click(By.linkText(text));
    }
    public void clickTab(String link) {
        click(By.linkText(link));
    }

    public void click(By by) {
        driver.findElement(by).click();
    }
    public void type(By by,String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void selectDropDown(By by,String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public boolean hasElement(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public boolean hasText(String text) {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    public String getFutureDate(String oldDate,int days){

        //Specifying date format that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        Calendar c = Calendar.getInstance();
        try{
            //Setting the date to the given date
            c.setTime(sdf.parse(oldDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        //Number of Days to add
        c.add(Calendar.DATE, days);
        //Date after adding the days to the given date
        String newDate = sdf.format(c.getTime());
        return newDate;
    }

    protected String readText(By by){
        return driver.findElement(by).getAttribute("value");
    }

    protected void clickButton(String buttonText) {
        click(By.xpath("//*[text()='"+buttonText+"']"));
    }



}
