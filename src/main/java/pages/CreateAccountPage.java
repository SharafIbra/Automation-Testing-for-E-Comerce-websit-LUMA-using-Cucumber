package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class CreateAccountPage extends basePage{
    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstname_obj = new By.ById("firstname");
    private final By lastname_obj = new By.ById("lastname");
    private final By email_obj = new By.ById("email_address");
    private final By password_obj = new By.ById("password");
    private final By confirm_password_obj = new By.ById("password-confirmation");
    private final By create_account_button_obj = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private final By clickherebtn_obj = new By.ByXPath("//a[normalize-space()='click here']");


    private final By createacount_obj = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");

    public void clickCreateAccountPage() {
        click(createacount_obj);
    }

    public void setPersonalInformation(String firstName, String lastName) {
        sendKeys(firstname_obj, firstName);
        sendKeys(lastname_obj, lastName);
    }


    public void setSignInInformation(String Email, String Password, String confirmPassword) {
        sendKeys(email_obj, Email);
        sendKeys(password_obj, Password);
        sendKeys(confirm_password_obj, confirmPassword);
    }

    public void createAccountButton() {
        click(create_account_button_obj);
    }

    public void verifyPageURL() {
        String expectedPageSource = "https://magento.softwaretestingboard.com/customer/account/";
        String actualPageSource = getCurrentURL();
        assertEquals(actualPageSource, expectedPageSource, "account not created");
    }


}
