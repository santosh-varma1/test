package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class StepDefinitions extends Base {

    @Given("^initialise the browser with chrome$")
    public void initialise_the_browser_with_chrome() throws Throwable {
        driver = initializeDriver();

    }

    @And("^navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        driver.get(strArg1);

    }

    @And("^click on Login link on home page to land on sign in page$")
    public void click_on_login_link_on_home_page_to_land_on_sign_in_page() throws Throwable {
        LandingPage landingP = new LandingPage(driver);
        if(driver.findElement(By.xpath("//span//div//div[6]")).isDisplayed()){
            driver.findElement(By.xpath("//span//div//div[6]")).click();
            landingP.login();

        }else{
            landingP.login();
        }

    }


    @When("^user enters (.+) and (.+) and login in$")
    public void user_enters_something_and_something_and_login_in(String strArg1, String strArg2) {
        LoginPage loginP = new LoginPage(driver);
        loginP.emailAddress().sendKeys(strArg1);
        loginP.password().sendKeys(strArg2);
        loginP.loginButton().click();
    }

    @Then("^verify user is successfully logged in$")
    public void verify_user_is_successfully_logged_in() throws Throwable {

    }

    @Then("^close browsers$")
    public void closeBrowser() {
        driver.close();

    }

}