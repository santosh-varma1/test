package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By signin = By.cssSelector("a[href*='sign_in']");
    By title = By.cssSelector(".text-center>h2");
    By navBar = By.xpath("//li[@class='active']");


    public WebElement getTitle(){
        return driver.findElement(title);
    }

    public LoginPage login(){
        driver.findElement(signin).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public WebElement navBar(){
        return driver.findElement(navBar);
    }

}
