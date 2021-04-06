package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailAddressTab= By.id("user_email");
    By passwordTab = By.id("user_password");
    By loginButton = By.xpath("//input[@type='submit']");
    By forgotPassword = By.cssSelector("[href*='password/new']");

    public WebElement emailAddress(){
        return driver.findElement(emailAddressTab);
    }
    public WebElement password(){
        return driver.findElement(passwordTab);
    }
    public WebElement loginButton(){
        return driver.findElement(loginButton);
    }
    public ForgotPasswordPage forgotPassword(){
        driver.findElement(forgotPassword).click();
        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);
        return forgotPage;
    }


}
