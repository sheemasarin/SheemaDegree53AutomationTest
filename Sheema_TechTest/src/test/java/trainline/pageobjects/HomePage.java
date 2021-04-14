package trainline.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import trainline.framework.ParentPage;

public class HomePage extends ParentPage {

    private static final String FROM_TEXT = "from.search";
    private static final String TO_TEXT = "to.search";
    private static final String RETURN_BUTTON = "return";
    private static final String OUT_DATE = "page.journeySearchForm.outbound.title";
    private static final String RETURN_DATE = "page.journeySearchForm.inbound.title";
    private static final String RETURN_HOUR = "hours";
    private static final String RETURN_MIN = "minutes";
    private static final String RAIL_CARD = "passenger-summary-btn";
    private static final String RAIL_CARD_DROP_DOWN = "railcardRow0";
    private String todaydate = "";

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean isUserinHomepage() {
        return hasElement(By.className("banner_logo"));
    }

    public void selectOriginAndDestination(String from, String to) {
        type(By.id(FROM_TEXT),from);
        type(By.id(TO_TEXT),to);
    }

    public void selectReturn() {
        click(By.id(RETURN_BUTTON));
    }

    public void selectOutDate(String date, String hour, String minute) {
        String futureDate = "";
        if (!date.equalsIgnoreCase("today")){
            //ignore
            futureDate = getFutureDate(date,3);
        }

        todaydate = readText(By.id(OUT_DATE));

    }
    public void selectReturnDate(String date, String hour, String minute) {
        String futureDate = "";

            futureDate = getFutureDate(todaydate,Integer.parseInt(date));


        type(By.id(RETURN_DATE),futureDate);
        click(By.id(RETURN_BUTTON));
        selectDropDown(By.name(RETURN_HOUR),hour);
        selectDropDown(By.name(RETURN_MIN),minute);


    }

    public void selectRailCard(String railCard) throws InterruptedException {
        click(By.id(RAIL_CARD));
        clickButton("Add railcard");
        Thread.sleep(1000);
        selectDropDown(By.id(RAIL_CARD_DROP_DOWN),railCard);
    }

    public void clickOnDone() {
        clickButton("Done");
    }


    public void search() {
        clickButton("Get times & tickets");
    }
}
