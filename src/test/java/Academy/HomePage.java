package Academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.io.IOException;
import resources.Base;

public class HomePage extends Base {
    public WebDriver driver;

    @Test(dataProvider = "getData")
    public void basePageNavigation(String email, String password, String type) throws IOException {
        driver = initializeDriver();
        log.info("Driver Is Initialized");
        driver.get(prop.getProperty("url"));
        driver.findElement(By.xpath("//span//div//div[6]")).click();
        log.info("Closed The Pop-Up");


        LandingPage landingP = new LandingPage(driver);
        LoginPage loginP=landingP.login();
        loginP.emailAddress().sendKeys(email);
        loginP.password().sendKeys(password);
        System.out.println(type);
        loginP.loginButton().click();

        ForgotPasswordPage forgotPage = loginP.forgotPassword();
        forgotPage.emailAddressTab().sendKeys(email);
        forgotPage.instructionsButton().click();

        driver.close();

    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][3];
        data[0][0] = "non@restricted.com";
        data[0][1]=  "password";
        data[0][2] = "Restricted user";

        data[1][0] = "non@rested.com";
        data[1][1]=  "pasd";
        data[1][2] = "Non-Restricted user";
        return data;

    }

}
