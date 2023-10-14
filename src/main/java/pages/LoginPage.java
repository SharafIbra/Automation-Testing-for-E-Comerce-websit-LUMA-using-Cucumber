package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginPage extends basePage{
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By email_obj = new By.ById("email");
    private By password_obj = new By.ById("pass");
    private By signinbutton_obj = new By.ById("send2");
    private By errorloginmessage_obj = new By.ByXPath("/html/body/div[2]/main/div[2]/div[2]/div/div");

    public void setLoginCredentials(String Email, String Password) {
        sendKeys(email_obj, Email);
        sendKeys(password_obj, Password);
    }
    public void clickSignIn() {
        click(signinbutton_obj);
    }

    public void verifySignIn_Is_Successfully() {
        String expectedURL = "https://magento.softwaretestingboard.com/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
    }

    public void verifySignIn_Is_UnSuccessfully(String expectedError) {
        /*String expectedError = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";*/
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorloginmessage_obj));


        String actualURL = getText(errorloginmessage_obj);
        assertEquals(actualURL, expectedError);
    }


}
