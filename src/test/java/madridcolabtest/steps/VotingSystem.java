package madridcolabtest.steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import madridcolabtest.enums.Context;
import madridcolabtest.pageobjects.ContestListPage;
import madridcolabtest.pageobjects.ContestPage;
import madridcolabtest.pageobjects.MainPage;
import madridcolabtest.pageobjects.ProposalDetailsPage;
import madridcolabtest.selenium.TestContext;

public class VotingSystem {
private TestContext testContext;
private ContestPage contestPage;
private ProposalDetailsPage proposalDetailsPage;
private int numVotes;
private MainPage mainPage;
private ContestListPage contestListPage;
private String nameContest;
	
	public VotingSystem(TestContext testContext) {
		this.testContext = testContext;
		this.contestPage = this.testContext.getPageObjectManager().getContestPage();
	}
	
//	@And("^wait until phase change to voting phase$")
//	public void waitUntilProposalIsInSemiFinalistPhase() {
//		this.proposalDetailsPage=this.testContext.getPageObjectManager().getProposalDetailsPage();
//		this.proposalDetailsPage.goToMainPage();
//		mainPage = this.testContext.getPageObjectManager().getMainPage();
//		mainPage.closeSession();
//		mainPage.goToContest();
//		contestListPage = this.testContext.getPageObjectManager().getContestListPage();
//		nameContest = (String) this.testContext.getScenarioContext().getContext(Context.CONTEST_NAME);
//		contestListPage.clickOnContestByName(nameContest);
//		contestPage = this.testContext.getPageObjectManager().getContestPage();
//		this.contestPage.checkIfProposalIsShowInVotingPhase("Titulo");
//	}
//	

@Given("^a \"([^\"]*)\" into the proposal which can be vote$")
public void goIntoProposalInVotingPhase(String memberType) {
	this.contestPage.clickOnProposalByName("Titulo");
	
}
@When ("^vote for the proposal$")
public void voteProposal() {
	proposalDetailsPage = this.testContext.getPageObjectManager().getProposalDetailsPage();
	numVotes = proposalDetailsPage.getNumVotes();
	proposalDetailsPage.voteProposal();
}
@Then ("^the button change to remove vote$")
public void checkButtonChangeToRemoveVote() {
	Assert.assertEquals("RETIRAR voto",proposalDetailsPage.getButtonVoteText());
}
@And  ("^the count increment in 1$")
public void checkIncrementVotesCount() {
	Assert.assertTrue((this.numVotes+1) == proposalDetailsPage.getNumVotes());
}


@Then("^appear a message to notify of the vote$")
public void checkIfVoteMessageNotifyIsVisible() {
	Assert.assertTrue(this.proposalDetailsPage.checkIfVoteNotifyIsVisible());
}

@And("^click on remove vote$")
public void removeVote() {
	numVotes = proposalDetailsPage.getNumVotes();
	proposalDetailsPage.removeVote();
}

@Then("^the button change to vote again$")
public void checkButtonChangeToVote() {
	Assert.assertEquals("VOTA la propuesta",proposalDetailsPage.getButtonVoteText());
}
@And("^the count decreased in 1$")
public void checkDecreaseVotesCount() {
	Assert.assertTrue((this.numVotes-1) == proposalDetailsPage.getNumVotes());
}
@And("^close voting message$")
public void closeVotingMessage() {
	this.proposalDetailsPage.closeMessage();
}
	
}
