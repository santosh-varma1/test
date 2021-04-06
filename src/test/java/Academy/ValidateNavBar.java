package Academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import java.io.IOException;
import resources.Base;

public class ValidateNavBar extends Base {
    public WebDriver driver;

    @BeforeTest
    public void goToTest() throws IOException {
        driver = initializeDriver();
        log.info("Driver Is Initialized");
        driver.get(prop.getProperty("url"));
        driver.findElement(By.xpath("//span//div//div[6]")).click();
        log.info("Closed The Pop-Up");

        System.out.println("changing web automation tools");


    }

    @Test
    public void navBarTest(){
        LandingPage landingP = new LandingPage(driver);
        Assert.assertTrue(landingP.navBar().isDisplayed());
    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }

}
