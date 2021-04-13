package trainline.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trainline.framework.ParentPage;


public class ResultsPage extends ParentPage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }


    public boolean hasTextOnPage(String text) {
        return hasText(text);
    }


}
