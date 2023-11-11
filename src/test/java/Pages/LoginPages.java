package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

public class LoginPages {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;


    public LoginPages(WebDriver driver){
        this.driver=driver;
        this.elementHelper=new ElementHelper(driver);
        this.wait=new WebDriverWait(driver,10);
    }

    static By loginButton=By.id("login-button");
    static By errorMessage=By.cssSelector("h3[data-test='error']");
    static By userNameElement=By.id("user-name");
    static By passWordElement=By.id("password");
    String checkUrlElement="https://www.saucedemo.com/inventory.html";

    public void checkUserAtLoginPage() {
        driver.get("https://www.saucedemo.com");
    }

    public void clickLoginButton() {
        elementHelper.click(loginButton);
    }

    public void checkErrorMessage(String arg0) {
        elementHelper.checkText(arg0,errorMessage);
    }

    public void writeUserName(String userName) {
        elementHelper.sendKey(userNameElement,userName);
    }

    public void writePassword(String password) {
        elementHelper.sendKey(passWordElement,password);
    }
    public void checkUrl(){

        try
        {
            Assert.assertEquals(driver.getCurrentUrl(),checkUrlElement);

            System.out.println("("+driver.getCurrentUrl()+") is correct adres");
        }
        catch (Exception e)
        {
            System.out.println("("+driver.getCurrentUrl()+") is false adres");
        }
    }
}
