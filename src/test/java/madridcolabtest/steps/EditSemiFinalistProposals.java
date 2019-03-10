package madridcolabtest.steps;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import madridcolabtest.pageobjects.ContestListPage;
import madridcolabtest.pageobjects.ContestManagerPage;
import madridcolabtest.pageobjects.ContestPage;
import madridcolabtest.pageobjects.CreateProposalPage;
import madridcolabtest.pageobjects.EditionContestPage;
import madridcolabtest.pageobjects.MainPage;
import madridcolabtest.pageobjects.ProposalDetailsPage;
import madridcolabtest.selenium.DriverManagerFactory;
import madridcolabtest.selenium.DriverType;
import madridcolabtest.selenium.TestContext;
import madridcolabtest.selenium.WebDriverManager;

public class EditSemiFinalistProposals {
	private WebDriverManager driverManager;
	private WebDriver driver;
	private MainPage mainPage;
	private ContestManagerPage contestManagerPage;
	private EditionContestPage editionContestPage;
	private ContestListPage contestListPage;
	private ContestPage contestPage;
	private CreateProposalPage createProposalPage;
	private ProposalDetailsPage proposalDetailsPage;
	private String nameSchedule;
	private String nameContest;
	private SimpleDateFormat format;
	private Calendar now;
	private TestContext testContext;

	public EditSemiFinalistProposals(TestContext testContext){
		this.testContext = testContext;
		contestPage = this.testContext.getPageObjectManager().getContestPage();
	
	}
	
	
	@Given("^a contest which is in proposal revision phase$")
	public void a_member_into_a_contest_which_is_in_proposal_revision_phase() throws Exception {
		String contestPhase = contestPage.getCurrentPhase();
		if (!contestPhase.contains("Revisi�n de propuestas")) {
			throw new Exception();
		}
	}

	@When("^a member access to the contest$")
	public void the_member_try_to_create_a_new_proposal() {
//		mainPage = new MainPage(contestManagerPage.getDriver());
//		this.mainPage.getDriver().get("http://localhost:18082/?&lang=es");
//		mainPage.closeSession();
		contestPage.clickEnter();
		contestPage.insertValidUserAndPassword("member", "odemlo13");
		contestPage.clickSubmmit();
		
	}

	@Then("^the button to create new proposals is disabled$")
	public void the_button_to_create_new_proposals_is_disabled() throws Throwable {
	  Assert.assertTrue(!contestPage.checkIfCreateNewProposalButtonIsDisplay());
	}

	@Given("^a semi-finalist proposal in proposal revision phase$")
	public void a_semi_finalist_proposal_in_proposal_revision_phase() throws Throwable {
		
		contestPage.clickOnProposalByName("Titulo");
			
	}

	@When("^the author enter in the proposal page$")
	public void the_author_enter_in_the_proposal_page() throws Throwable {
		contestPage.clickEnter();
		contestPage.insertValidUserAndPassword("member","odemlo13");
		contestPage.clickSubmmit();
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
	   
	}

	@Then("^the author can edit the proposal$")
	public void the_author_can_edit_the_proposal() throws Throwable {
	    Assert.assertTrue(this.proposalDetailsPage.editButtonIsDisplay());
	}
	
	private void login(String userName, String password) {
		mainPage.clickEnter();
		mainPage.insertValidUserAndPassword(userName, password);
		mainPage.clickSubmmit();
	}


////	@After("@selectSemiFinalist, @EditSemiFinalistProposal")
////	public void tearDown(Scenario scenario) {
////		if (scenario.isFailed()) {
////			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
////			scenario.embed(screenshot, "image/png"); // stick it in the report
////		}
////		driver.close();
////	}
//	

}
