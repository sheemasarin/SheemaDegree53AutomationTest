package trainline;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trainline.framework.ParentScenario;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class StepDefs extends ParentScenario {

    @Given("^passenger is in home page$")
    public void passenger_is_in_home_page() throws Throwable {
        navigateTo();
        assertThat(homePage.isUserinHomepage(), is(true));
        acceptCookies();

    }

    @When("^he selects the origin (.+) and destination as (.+)$")
    public void he_selects_the_origin_and_destination_as(String from, String to) throws Throwable {
        homePage.selectOriginAndDestination(from,to);

    }

    @Then("^he should see \"([^\"]*)\"$")
    public void he_should_see_something(String text) throws Throwable {
        
        assertThat(resultsPage.hasTextOnPage(text), is(true));
    }

    @And("^he selects to return on the travel$")
    public void he_selects_to_return_on_the_travel() throws Throwable {
        homePage.selectReturn();

    }

    @And("^he selects OUT date as \"([^\"]*)\" and time as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void he_selects_out_date_as_something_and_time_as_something_and_something(String date, String hour, String minute) throws Throwable {
        homePage.selectOutDate(date,hour,minute);
    }

    @And("^he selects RETURN date as \"([^\"]*)\" and time as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void he_selects_return_date_as_something_and_time_as_something_and_something(String date, String hour, String minute) throws Throwable {
        homePage.selectReturnDate(date,hour,minute);
    }

    @And("^he selects rail card as \"([^\"]*)\"$")
    public void he_selects_rail_card_as_something(String railCard) throws Throwable {
        homePage.selectRailCard(railCard);
        homePage.clickOnDone();
    }

    @And("^search for trains$")
    public void search_for_trains() throws Throwable {
        homePage.search();
    }
   
    @Before
    public void beforeScenario() throws MalformedURLException {
        startBrowser();
    }


    @After
    public void afterScenario() {
        closeBrowser();
    }
}