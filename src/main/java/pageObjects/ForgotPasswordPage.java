package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    public WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailAddressTab= By.id("user_email");
    By sendInstructionsButton = By.xpath("//input[@type='submit']");

    public WebElement emailAddressTab(){
        return driver.findElement(emailAddressTab);
    }

    public WebElement instructionsButton(){
        return driver.findElement(sendInstructionsButton);
    }
}
