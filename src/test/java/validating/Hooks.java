package validating;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ConfigReader;

import java.util.Properties;

public class Hooks {
    public DriverFactory driverFactory;
    public WebDriver driver;
    Properties prop;
    public ConfigReader configReader;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_Prop();
    }

    @Before(order = 1)
    public void lunchBrowser() {
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browser);
        driver.get(url);
    }

    @After(order = 0)
    public void quiteBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void takeSC(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenShotNAme = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png", screenShotNAme);
        }
    }
}
