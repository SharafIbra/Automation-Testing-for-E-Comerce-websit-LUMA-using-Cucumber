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
    private By signin_obj = new By.ById("send2");
    private By errorloginmessage_obj = new By.ByXPath("/html/body/div[2]/main/div[2]/div[2]/div/div");

    private final By signinbutton_obj = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    public void clickLoginPage() {
        click(signinbutton_obj);
    }


    public void setLoginCredentials(String Email, String Password) {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(email_obj));

        sendKeys(email_obj, Email);
        sendKeys(password_obj, Password);
    }
    public void verifySignIn_Is_Successfully() {
        String expectedURL = "https://magento.softwaretestingboard.com/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
    }

    public void clickSignIn() {
        click(signin_obj);
    }

    public void verifySignIn_Is_UnSuccessfully() {
        /*String expectedError = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";*/

        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
        String actualURL = getCurrentURL();
        assertEquals(actualURL, expectedURL);
    }


}
