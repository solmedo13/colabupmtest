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
import madridcolabtest.enums.Context;
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

public class FinalistSelection {
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
	private ProposalDetailsPage proposalDetails;

	public FinalistSelection (TestContext testContext) {
		this.testContext = testContext;
		this.contestPage = this.testContext.getPageObjectManager().getContestPage();
	}
	
	@And("^wait until phase change to finalist selection phase$")
	public void waitUntilPhaseChange() {
		contestPage.clickEnter();
		contestPage.insertValidUserAndPassword("solmedo", "odemlo13");
		contestPage.clickSubmmit();
		contestPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.gotoScheduleTemplate();
		//es necesario compartir el nombre entre escenarios
		this.nameSchedule = (String) this.testContext.getScenarioContext().getContext(Context.SCHEDULE_NAME);
		contestManagerPage.selectScheduleByName(nameSchedule);
		now = Calendar.getInstance();
		String dateString;
		System.out.println(now.getTime().getSeconds());
		if (50 <= now.getTime().getSeconds() && now.getTime().getSeconds() <= 59) {
			now.add(Calendar.MINUTE, 2);
		} else {
			now.add(Calendar.MINUTE, 1);
		}
		format = new SimpleDateFormat("MM/dd/yyy HH:mm");
		dateString = format.format(now.getTime());
		contestManagerPage.changeScheduleFinalistSelection(dateString);
		contestManagerPage.saveSchedule();
		contestManagerPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		mainPage.goToContest();
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		nameContest = (String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME);
		contestListPage.clickOnContestByName(nameContest);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
	    contestPage.waitUntilProposalIsViewInFinalistPhase("Titulo");
	}
	
	@Given("^a proposal in a contest in phase Finalist selection$")
	public void a_proposal_in_a_contest_in_phase_Finalist_selection() throws Throwable {
	   contestPage.clickOnProposalByName("Titulo");    
	}

	@Then("^the proposal is not visible in the voting phase$")
	public void the_proposal_is_not_visible_in_the_voting_phase() throws Throwable {
		proposalDetailsPage=this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		mainPage.clickEnter();
		mainPage.insertValidUserAndPassword("solmedo", "odemlo13");
		mainPage.clickSubmmit();
		mainPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.gotoScheduleTemplate();
		contestManagerPage.selectScheduleByName(nameSchedule);
		now = Calendar.getInstance();
		String dateString;
		System.out.println(now.SECOND);
		if (50 <= now.getTime().getSeconds() && now.getTime().getSeconds() <= 59) {
			now.add(Calendar.MINUTE, 3);
		} else {
			now.add(Calendar.MINUTE, 2);
		}
		dateString = format.format(now.getTime());
		contestManagerPage.changeScheduleVotingSelection(dateString);
		contestManagerPage.saveSchedule();
		contestManagerPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		mainPage.goToContest();
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.clickOnContestByName(nameContest);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		Assert.assertFalse(contestPage.checkIfProposalIsShowInVotingPhase("Titulo"));
	}

	@And("^the judge decide that can be advance$")
	public void a_finalist_proposal_which_a_judge_decide_that_can_be_advance() throws Throwable {
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		mainPage.clickEnter();
		mainPage.insertValidUserAndPassword("judge", "odemlo13");
		mainPage.clickSubmmit();
		mainPage.goToContest();
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.clickOnContestByName(nameContest);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.clickOnProposalByName("Titulo");
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetails.selectMaxScoreRatings();
		proposalDetails.advanceProposal();
		proposalDetails.writeJudgingComment("Ok");
		proposalDetails.saveProposalJudging();
		proposalDetails.closeSession();
	}

	@Then("^the proposal is visible in the voting Phase$")
	public void the_proposal_is_visible_in_the_voting_Phase() throws Throwable {
		contestPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		mainPage.clickEnter();
		mainPage.insertValidUserAndPassword("solmedo", "odemlo13");
		mainPage.clickSubmmit();
		mainPage.goToContestManagerPage();
		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
		contestManagerPage.gotoScheduleTemplate();
		contestManagerPage.selectScheduleByName(nameSchedule);
		now = Calendar.getInstance();
		String dateString;
		System.out.println(now.SECOND);
		if (50 <= now.getTime().getSeconds() && now.getTime().getSeconds() <= 59) {
			now.add(Calendar.MINUTE, 3);
		} else {
			now.add(Calendar.MINUTE, 2);
		}
		dateString = format.format(now.getTime());
		contestManagerPage.changeScheduleVotingSelection(dateString);
		contestManagerPage.saveSchedule();
		contestManagerPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		mainPage.goToContest();
		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
		contestListPage.clickOnContestByName(nameContest);
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		Assert.assertTrue(contestPage.checkIfProposalIsShowInVotingPhase("Titulo"));
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
