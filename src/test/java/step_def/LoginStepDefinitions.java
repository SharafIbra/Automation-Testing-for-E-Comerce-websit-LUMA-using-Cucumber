package step_def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUpDriver(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }

    @Given("I'm on LUMA login page")
    public void setLoginPage(){
        loginPage = new LoginPage(driver);
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");

    }
    @Given("I have entered a valid username and password")
    public void enterValidUsernameAndPassword(){
        loginPage.setLoginCredentials("bigah1x43x31a01@ipniel.com","P@ssw0rd");
    }
    @When("I click on Sign In button")
    public void clickSignInButton(){
        loginPage.clickSignIn();
    }
    @Then("I should be logged in successfully")
    public void checkLoginSuccessfully(){
        loginPage.verifySignIn_Is_Successfully();
    }


    /*
     */


    @When("I have entered invalid {string} & {string}")
    public void enterValidUsernameAndPassword(String UserName , String Password){
        loginPage.setLoginCredentials(UserName,Password);
    }
    @Then("I get error message: {string}")
    public void checkLoginUnsuccessfully(String errorMessage){
        loginPage.verifySignIn_Is_UnSuccessfully(errorMessage);
    }


}
