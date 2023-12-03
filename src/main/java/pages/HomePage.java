package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By loginBTN = By.xpath("//button[normalize-space()='Login']");
    public LoginPage clickOnLoginBTN(){
        driver.findElement(loginBTN).click();
        return new LoginPage(driver);
    }
}
