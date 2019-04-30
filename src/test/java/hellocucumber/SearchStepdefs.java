package hellocucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchStepdefs {

    private TestContext testContext;

    public SearchStepdefs(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I have a favourite search engine")
    public void i_have_a_favourite_search_engine() {

    }

    @When("I want to search something")
    public void i_want_to_search_something() {

    }

    @Then("My favourite search engine should load")
    public void i_use_my_favourite_search_engine() {
        testContext.navigateTo(testContext.getFavouriteSerchEngineUrl());

        new WebDriverWait(testContext.getDriver(), 2L);

        String title = testContext.getDriver().getTitle();
        Assert.assertEquals(this.testContext.getFavouriteSerchEngineName(), title);
    }

    @After
    public void quitBrowser() {
        testContext.getDriver().quit();
    }
}
