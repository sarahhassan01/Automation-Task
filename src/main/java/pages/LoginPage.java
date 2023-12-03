package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signUsingEmailBTN = By.xpath("//a[normalize-space()='Sign in using email']");
    private By email = By.name("email");
    private By password = By.name("password");
    private By signINBTN = By.xpath("//button[normalize-space()='Sign In']");
    private By wrongCredentialMSG = By.xpath("//p[@class='sc-8b73d51b-15 dMZQIZ']");

    public void clickOnSignUsingEmailBTN() {
        driver.findElement(signUsingEmailBTN).click();
    }

    public void insertEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void insertPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickOnSignin() {
        driver.findElement(signINBTN).click();
    }

    public String getMessageTXt() {
        String text = driver.findElement(wrongCredentialMSG).getText();
        return text;
    }
}
