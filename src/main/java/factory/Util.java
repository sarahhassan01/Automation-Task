package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Util {
    WebDriver driver;

    public Util(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public void selectAndRemoveText(By by) {
        driver.findElement(by).sendKeys(Keys.chord(Keys.CONTROL, "A"));
        driver.findElement(by).sendKeys(Keys.BACK_SPACE);
    }

    public void threadSleep(int second) throws InterruptedException {
        Thread.sleep(second);
    }

    public void decreaseValue(WebDriver driver, By by) {
        WebElement field = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(field).click().sendKeys(Keys.DOWN).perform();
        actions.moveToElement(field).click().sendKeys(Keys.DOWN).perform();
    }

    public void moveToElement(WebDriver driver, By by) {
        WebElement field = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(field).click().perform();
    }

    public void selectElementByVisibleText(WebDriver driver, By by, String value) {
        WebElement list = driver.findElement(by);
        Select select = new Select(list);
        select.selectByVisibleText(value);
    }

    public void clickEnter(WebDriver driver, By by) {
        WebElement field = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(field).sendKeys(Keys.ENTER);
    }

    public String getSelectedOption(WebDriver driver, By by) {
        WebElement list = driver.findElement(by);
        Select select = new Select(list);
        WebElement option = select.getFirstSelectedOption();
        String optionValue = option.getText();
        return optionValue;
    }
}
