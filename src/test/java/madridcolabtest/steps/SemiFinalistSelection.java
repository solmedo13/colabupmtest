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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import madridcolabtest.enums.Context;
import madridcolabtest.pageobjects.AbstractPageObject;
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
import madridcolabtest.utils.ContestManagerUtils;

public class SemiFinalistSelection {

	private MainPage mainPage;
	private ContestPage contestPage;
	private ProposalDetailsPage proposalDetailsPage;
	private TestContext testContext;
	private ProposalDetailsPage proposalDetails;
	private ContestManagerUtils cmUtils;

	public SemiFinalistSelection(TestContext testContext, ContestManagerUtils cmUtils) {
		this.testContext = testContext;
		this.cmUtils = cmUtils;
	}
	
	
	
	@Given("^a proposal in a contest in phase SemiFinalist selection$")
	public void a_proposal_in_a_contest_in_phase_SemiFinalist_selection() throws Throwable {
		cmUtils.createContestAndLaunch();
		cmUtils.createNewProposal("Titulo");
		cmUtils.updateSchedule("semi-finalist");
		contestPage.waitUntilProposalIsViewInSemiFinalistPhase("Titulo");
		//create contest and launch
//		mainPage = this.testContext.getPageObjectManager().getMainPage();
//		mainPage.loadMainPage();
//		this.login("solmedo", "odemlo13", mainPage);
//		mainPage.goToContestManagerPage();
//		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
//		contestManagerPage.gotoScheduleTemplate();
//		contestManagerPage.createScheduleTemplate();
//		format = new SimpleDateFormat("MM/dd/yyy HH:mm");
//		now = Calendar.getInstance();
//		nameSchedule = "pruebaSchedule" + new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "")
//				.replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "");
//		this.testContext.getScenarioContext().setContext(Context.SCHEDULE_NAME, nameSchedule);
//		contestManagerPage.initSecheduleTemplate(nameSchedule, now);
//		contestManagerPage.goToContestsSection();
//		contestManagerPage.clickOnCreateNewContestButton();
//		contestManagerPage.editNewContest();
//		editionContestPage = this.testContext.getPageObjectManager().getEditionContestPage();
//		nameContest = "Prueba semifinalista" + new Timestamp(new Date().getTime()).toString().replaceAll("\\.", "")
//				.replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "");
//		this.testContext.getScenarioContext().setContext(Context.CONTEST_NAME, nameContest);
//		editionContestPage.changeTitle(nameContest);
//		editionContestPage.selectScheduleTemplateByName(nameSchedule);
//		editionContestPage.clickOnSaveChanges();
//		editionContestPage.goToTeamSelectionPage();
//		editionContestPage.addFellow("fellow");
//		editionContestPage.addJudge("judge");
//		editionContestPage.clickOnSaveTeamButton();
//		editionContestPage.goToContestManagerPage();
//		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
//		contestManagerPage.selectContestByName(nameContest);
//		contestManagerPage.selectLaunchContestOption();
//		contestManagerPage.clickOnSubmitButton();
//		contestManagerPage.goToMainPage();
		// end create contest
		
		//login as member and create new proposal
//		mainPage = this.testContext.getPageObjectManager().getMainPage();
//		mainPage.closeSession();
//		this.login("member", "odemlo13", mainPage);
//
//		this.goToContest(nameContest);
//		contestPage = this.testContext.getPageObjectManager().getContestPage();
//		contestPage.clickOnCreateNewProposal();
//		createProposalPage = this.testContext.getPageObjectManager().getCreteProposalPage();
//		createProposalPage.fillMandatoryFields("Titulo", "Pitch");
//		createProposalPage.clickOnSaveAndPublish();
//		createProposalPage.acceptContestRules();
//		this.proposalDetailsPage = testContext.getPageObjectManager().getProposalDetailsPage();
//		proposalDetailsPage.goToMainPage();
//		this.mainPage = this.testContext.getPageObjectManager().getMainPage();
//		mainPage.closeSession();
		
		//end create proposal
		
		
		//updateSchedule
//		this.login("solmedo", "odemlo13", mainPage);
//		mainPage.goToContestManagerPage();
//		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
//		contestManagerPage.gotoScheduleTemplate();
//		contestManagerPage.selectScheduleByName(nameSchedule);
//		now = Calendar.getInstance();
//		String dateString;
//		System.out.println(now.getTime().getSeconds());
//		if (50 <= now.getTime().getSeconds() && now.getTime().getSeconds() <= 59) {
//			now.add(Calendar.MINUTE, 3);
//		} else {
//			now.add(Calendar.MINUTE, 2);
//		}
//
//		dateString = format.format(now.getTime());
//		contestManagerPage.changeScheduleSemiFinalistSelection(dateString);
//		contestManagerPage.saveSchedule();
//		contestManagerPage.goToMainPage();
//		
//		//end update schedule
//		mainPage = testContext.getPageObjectManager().getMainPage();
//		mainPage.closeSession();
//		this.goToContest(nameContest);
//		contestPage = this.testContext.getPageObjectManager().getContestPage();
//		contestPage.waitUntilProposalIsViewInSemiFinalistPhase("Titulo");
	}

	@When("^a fellow decide not advance the proposal$")
	public void a_fellow_decide_not_advance_the_proposal() throws Throwable {
		cmUtils.login("fellow", "odemlo13", contestPage);
		contestPage.clickOnProposalByName("Titulo");
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.clickOnScreeningTab();
		int[] valuesNegation = { 1, 2, 4 };
		int randomValue = (int) (Math.random() * 2);
		proposalDetailsPage.selectDecision(valuesNegation[randomValue]);
		proposalDetailsPage.saveDecission();
	}

	@Then("^the proposal is not visible in the Proposal Revision phase$")
	public void the_proposal_is_not_visible_in_the_Proposal_Revision_phase() throws Throwable {
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		cmUtils.updateSchedule("proposalRevision");
//		this.login("solmedo", "odemlo13", mainPage);
//		mainPage.goToContestManagerPage();
//		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
//		contestManagerPage.gotoScheduleTemplate();
//		contestManagerPage.selectScheduleByName(nameSchedule);
//		now = Calendar.getInstance();
//		String dateString;
//		System.out.println(now.SECOND);
//		if (50 <= now.getTime().getSeconds() && now.getTime().getSeconds() <= 59) {
//			now.add(Calendar.MINUTE, 2);
//		} else {
//			now.add(Calendar.MINUTE, 1);
//		}
//		dateString = format.format(now.getTime());
//		contestManagerPage.changeScheduleProposalRevisionSelection(dateString);
//		contestManagerPage.saveSchedule();
//		contestManagerPage.goToMainPage();
//		mainPage = this.testContext.getPageObjectManager().getMainPage();
//		mainPage.closeSession();
//		this.goToContest(nameContest);
//		contestPage = this.testContext.getPageObjectManager().getContestPage();
		
		Assert.assertFalse(contestPage.checkIfProposalIsShowInProposalRevisionPhase("Titulo"));
	}

	@When("^a fellow decide advance the proposal$")
	public void a_fellow_decide_advance_the_proposal() throws Throwable {
	
		cmUtils.login("fellow", "odemlo13", contestPage);
		contestPage.clickOnProposalByName("Titulo");
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.clickOnScreeningTab();
		proposalDetailsPage.selectDecision(3);
	}

	@When("^select the judge$")
	public void select_the_judge() throws Throwable {
		proposalDetailsPage.selectJudge();
		proposalDetailsPage.saveDecission();

	}

	@Then("^assigned judge can evaluate the proposal$")
	public void assigned_judge_can_evaluate_the_proposal() throws Throwable {
		mainPage.closeSession();
		cmUtils.login("judge", "odemlo13", mainPage);
		cmUtils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage.clickOnProposalByName("Titulo");
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();
		Assert.assertTrue(proposalDetails.checkVisibilityOfAdvanceProposalSelect());
	}

	@Given("^a proposal which a judge decide that can be advance$")
	public void a_proposal_which_a_judge_decide_that_can_be_advance() throws Throwable {
		cmUtils.createContestAndLaunch();
		cmUtils.createNewProposal("Titulo");
		cmUtils.updateSchedule("semi-finalist");
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.waitUntilProposalIsViewInSemiFinalistPhase("Titulo");
		this.a_fellow_decide_advance_the_proposal();
		this.select_the_judge();
		this.proposalDetailsPage.goToMainPage();
		mainPage.closeSession();
		cmUtils.login("judge", "odemlo13", mainPage);
		cmUtils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage = this.testContext.getPageObjectManager().getContestPage();
		contestPage.clickOnProposalByName("Titulo");
		proposalDetails = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetails.selectMaxScoreRatings();
		proposalDetails.advanceProposal();
		proposalDetails.writeJudgingComment("Ok");
		proposalDetails.saveProposalJudging();
		proposalDetails.closeSession();
	
	}

	@When("^not advance the proposal$")
	public void not_advance_the_proposal() throws Throwable {
		proposalDetailsPage.selectAdvanceDecission(1);
		proposalDetailsPage.submitAdvancing();
	}

	@When("^the fellow go to advance proposals selection section$")
	public void the_fellow_go_to_advance_proposals_selection_section() throws Throwable {
		cmUtils.login("fellow", "odemlo13", contestPage);
		cmUtils.goToContest((String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME));
		contestPage.clickOnProposalByName("Titulo");
		proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
		proposalDetailsPage.clickOnAdvancingTab();

	}

	@When("^advance the proposal$")
	public void advance_the_proposal() throws Throwable {
		proposalDetailsPage.selectAdvanceDecission(2);
		proposalDetailsPage.writeFellowCommentBeforeAdvance("Avanza");
		proposalDetailsPage.submitAdvancing();
	}

	@Then("^the proposal is visible in the Proposal Revision Phase$")
	public void the_proposal_is_visible_in_the_Proposal_Revision_Phase() throws Throwable {
		proposalDetailsPage.goToMainPage();
		mainPage = this.testContext.getPageObjectManager().getMainPage();
		mainPage.closeSession();
		cmUtils.updateSchedule("proposalRevision");
//		this.login("solmedo", "odemlo13", mainPage);
//		mainPage.goToContestManagerPage();
//		contestManagerPage = this.testContext.getPageObjectManager().getContestManagerPage();
//		contestManagerPage.gotoScheduleTemplate();
//		contestManagerPage.selectScheduleByName(nameSchedule);
//		now = Calendar.getInstance();
//		String dateString;
//		System.out.println(now.SECOND);
//		if (50 <= now.getTime().getSeconds() && now.getTime().getSeconds() <= 59) {
//			now.add(Calendar.MINUTE, 2);
//		} else {
//			now.add(Calendar.MINUTE, 1);
//		}
//		dateString = format.format(now.getTime());
//		contestManagerPage.changeScheduleProposalRevisionSelection(dateString);
//		contestManagerPage.saveSchedule();
//		contestManagerPage.goToMainPage();
//		mainPage = testContext.getPageObjectManager().getMainPage();
//		mainPage.closeSession();
//		this.goToContest(nameContest);
		Assert.assertTrue(contestPage.checkIfProposalIsShowInProposalRevisionPhase("Titulo"));
	}

	
//	@After("@selectSemiFinalist, @EditSemiFinalistProposal")
//	public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.embed(screenshot, "image/png"); // stick it in the report
//		}
//		driver.close();
//	}

}
