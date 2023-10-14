package step_def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;
import pages.LoginPage;

public class step_definitions {
    private LoginPage loginPage;
    private CreateAccountPage accountPage;

    protected WebDriver driver;
    @Before
    public void setUpDriver(){
        driver = new ChromeDriver();
    }



    @After
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }


    @Given("I'm in LUMA HomePage")
    public void setHomePage(){
        driver.get("https://magento.softwaretestingboard.com/");
        accountPage = new CreateAccountPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Given("I'm on LUMA login page")
    public void setLoginPage(){
        loginPage.clickLoginPage();
    }
    @And("I have entered a valid username and password")
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
        loginPage.verifySignIn_Is_UnSuccessfully();
    }


    /*
    * For Create Account
    * */






    @Given("I'm on Create New Customer Account Page")
    public void setCreateAccountPage(){
        accountPage.clickCreateAccountPage();
    }

    @When("I have entered First name: {string} & Last name: {string}")
    public void setUsernameAndPassword(String FirstName , String LastName){
        accountPage.setPersonalInformation(FirstName, LastName);
    }

    @And("I have entered Email: {string} & Password: {string} & Confirm Password: {string}")
    public void setEmailPassword(String Email, String Password, String confirmPassword){
        accountPage.setSignInInformation(Email, Password, confirmPassword);
    }
    @And("I have clicked on Create an account button")
    public void clickCreateAccount(){
        accountPage.createAccountButton();
    }
    @Then("I should be created a new customer and redirected to his Account Page")
    public void checkAccount_isCreatedSuccessfully(){
        accountPage.verifyPageURL();
    }






}
