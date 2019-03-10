package madridcolabtest.steps;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import madridcolabtest.pageobjects.AbstractPageObject;
import madridcolabtest.pageobjects.LightBoxLoginPage;
import madridcolabtest.pageobjects.MainPage;
import madridcolabtest.selenium.DriverManagerFactory;
import madridcolabtest.selenium.DriverType;
import madridcolabtest.selenium.TestContext;
import madridcolabtest.selenium.WebDriverManager;

public class LoginSteps{
	private WebDriverManager driverManager;
	private WebDriver driver;
	private MainPage mainPage;
	private LightBoxLoginPage lightBoxLoginPage;
	
	private TestContext testContext;
	public LoginSteps(TestContext testContext) {
		this.testContext = testContext;
		this.mainPage = this.testContext.getPageObjectManager().getMainPage();
	}
	

	@When("^click on enter button$")
	public void clickEnter() {

		mainPage.clickEnter();

	}

	@And("^insert a valid credentials$")
	public void insertValidUserAndPassword() {

		// TODO hacerlo de manera automatica cogiendolo de un fichero properties
		mainPage.insertValidUserAndPassword("solmedo", "odemlo13");
		mainPage.clickSubmmit();

	}

	@Then("^the user sign in$")
	public void checkUserLoged() {
		Assert.assertTrue(mainPage.checkUserLogedIn());
	}

    @When ("^click on close session$")
    public void closeSession() {
    	mainPage.closeSession();
    }

    @Then ("^the session closed rightly$")
    public void checkLogOut() {
    	Assert.assertFalse(mainPage.checkUserLogedIn());
    }
	
	@And("^insert a invalid credentials$")
	public void insertInvalidUserAndPassword() {

		// TODO hacerlo de manera automatica cogiendolo de un fichero properties
		mainPage.insertInvalidUserAndPassword("solmedo", "solmedo");
		lightBoxLoginPage = this.testContext.getPageObjectManager().getLightBoxLoginPage();
		

	}

	@Then("^an error is shown$")
	public void checkErrorLoginMessage() {
		
		Assert.assertTrue(lightBoxLoginPage.isErrorMessageDisplayed());
	}
	
	@Then("^the message \"([^\"]*)\" is shown$")
	public void checkErrorLoginMessageText(String textoMensaje) {
		Assert.assertEquals(lightBoxLoginPage.getErrorMessageText(),"Error de autenticación, comprueba tu nombre de usuario y contraseña.");
	}
	
	@And("^logged in the platform with his username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void logged_in_the_platform_with_his_username_as_and_password_as(String user, String password) throws Throwable {
	    mainPage.clickEnter();
	    mainPage.insertValidUserAndPassword(user, password);
	    mainPage.clickSubmmit();
	}
	
//	@After ("@login")
//	public void tearDown(Scenario scenario) {
//	    if (scenario.isFailed()) {
//	            final byte[] screenshot = ((TakesScreenshot) driver)
//	                        .getScreenshotAs(OutputType.BYTES);
//	            scenario.embed(screenshot, "image/png"); //stick it in the report
//	    }
//	    driver.close();
//	}

}
