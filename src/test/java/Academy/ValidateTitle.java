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

public class ValidateTitle extends Base {

    public WebDriver driver;
    @BeforeTest
    public void goToTest() throws IOException {
        driver = initializeDriver();
        log.info("Driver Is Initialized");
        driver.get(prop.getProperty("url"));
        driver.findElement(By.xpath("//span//div//div[6]")).click();
        log.info("Closed The Pop-Up");

        System.out.println("killer gitl");
        System.out.println("i am sorry");
        System.out.println("i cant be alive");

    }

    @Test
    public void titleTest(){

        LandingPage landingP = new LandingPage(driver);
        Assert.assertTrue(landingP.getTitle().getText().equalsIgnoreCase("Featured Courses"));

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }

}
