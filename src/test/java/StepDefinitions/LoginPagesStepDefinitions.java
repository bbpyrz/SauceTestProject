package StepDefinitions;

import Pages.LoginPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class LoginPagesStepDefinitions {
    WebDriver driver= DriverFactory.getDriver();
    LoginPages loginPages=new LoginPages(driver);
    @Given("User At Login Page")
    public void userAtLoginPage() {
        loginPages.checkUserAtLoginPage();
    }

    @When("Click Login Button")
    public void clickLoginButton() {
        loginPages.clickLoginButton();
    }

    @Then("Check {string} Message About UserName")
    public void checkMessageAboutUserName(String arg0) {
        loginPages.checkErrorMessage(arg0);
    }


    @When("Write {string} For UserName Field")
    public void writeForUserNameField(String userName) {
        loginPages.writeUserName(userName);
    }

    @Then("Check {string} Message Abaout Password")
    public void checkMessageAbaoutPassword(String arg0) {
        loginPages.checkErrorMessage(arg0);
    }

    @When("Write {string} For Password Field")
    public void writeForPasswordField(String password) {
        loginPages.writePassword(password);
    }

    @Then("Check Login")
    public void chenckLogin() {
        loginPages.checkUrl();
    }
}
