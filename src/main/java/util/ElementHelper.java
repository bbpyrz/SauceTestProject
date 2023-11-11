package util;
import com.beust.jcommander.internal.Console;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.action = new Actions(driver);
    }

    public WebElement presenceElement(By key){
        return
                wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }
    public WebElement findElement(By key){
        WebElement element = presenceElement(key);
        return element;
    }
    public void click(By key){
        findElement(key).click();
    }
    public void sendKey(By key, String text){
        findElement(key).sendKeys(text);
    }
    public void checkVisible(By key){
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }
    public void checkText(String text,By key){
        try
        {
            Assert.assertEquals(findElement(key).getText(),text);

            System.out.println("("+text+") is on the home page");
        }
        catch (Exception e)
        {
            System.out.println("("+text+") is not on the home page");
        }
    }

}