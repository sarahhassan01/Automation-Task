package validating;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;

public class Login {
    LoginPage login = new LoginPage(DriverFactory.getDriver());
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @Given("user click on login button")
    public void userClickOnLoginButton() throws InterruptedException {
        homePage.clickOnLoginBTN();
        Thread.sleep(5000);
    }

    @And("user click on sign in using email")
    public void userClickOnSignInUsingEmail() throws InterruptedException {
        login.clickOnSignUsingEmailBTN();
        Thread.sleep(5000);
    }

    @When("user insert email {string}")
    public void userInsertEmailEmail(String email) throws InterruptedException {
        login.insertEmail(email);
        Thread.sleep(5000);
    }

    @And("user insert password {string}")
    public void userInsertPasswordPassword(String password) throws InterruptedException {
        login.insertPassword(password);
        Thread.sleep(5000);
    }

    @Then("assert You seem to have a wrong email or password message displayed")
    public void assertYouSeemToHaveAWrongEmailOrPasswordMessageDisplayed() throws InterruptedException {
        Thread.sleep(15000);
        String text = login.getMessageTXt();
        softAssert.assertEquals(text,"You seem to have a wrong email or password.");
        softAssert.assertAll();
    }

    @And("user click on sign in button")
    public void userClickOnSignInButton() {
        login.clickOnSignin();
    }
}
