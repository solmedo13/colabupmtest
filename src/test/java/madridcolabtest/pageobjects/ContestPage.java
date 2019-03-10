package madridcolabtest.pageobjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContestPage extends AbstractPageObject {

	@FindBy(tagName = "h1")
	private WebElement titleOfContest;
	@FindBy(css = ".p-ContestProposals__header__description")
	private WebElement descriptionOfContest;
	@FindBy(css = ".p-ContestProposals__header__title.clearfix")
	private WebElement questionOfContest;
	@FindBy(id = "readMoreLink")
	private WebElement readMoreLink;
	@FindBy(id = "content")
	private WebElement contentResources;
	@FindBy(css = ".p-ContestProposals__header__team__member")
	private List<WebElement> namesTeamMembers;
	@FindBy(xpath = "//div[@id='proposalList']/a")
	private WebElement createProposalButton;
	@FindBy(xpath = "//div[@class='c-TableGrid__row c-TableGrid__row--continued                                           ']/div/a[1]")
	private List<WebElement> proposalNames;
	@FindBy(xpath = "//div[@class='p-ContestProposals__header__buttons cb-btn-spacer']/a[contains(@href,'discuss')]")
	private WebElement discussButton;
	@FindBy(xpath = "//div[@class='col-12 col-lg-5 col-xl-6 c-TableGrid__cell propname-authors']")
	private List<WebElement> proposals;
//	@FindBy(id = "shouldAdvanceProposal")
//	private WebElement advanceProposalSelect;
//	@FindBy(id = "rating4")
//	private WebElement noveltyMaxScore;
//	@FindBy(id = "rating9")
//	private WebElement feasibilityMaxScore;
//	@FindBy(id = "rating14")
//	private WebElement impactMaxScore;
//	@FindBy(id = "rating24")
//	private WebElement presentationMaxScore;
//	@FindBy(id = "saveProposalJudging")
//	private WebElement saveProposalJudgingButton;
//	@FindBy(id = "comment")
//	private WebElement commentTextArea;

	@FindBy(xpath = "//button[contains(@data-url,'subscribeContest')]/img[contains(@src,'subscribe')]")
	private WebElement subscribeButton;

	@FindBy(xpath = "//button[contains(@data-url,'subscribeContest')]/img[contains(@src,'unsubscribe')]")
	private WebElement unsubscribeButton;

	public ContestPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public String getNameContestShown() {

		return titleOfContest.getText();

	}

	public String getDescriptionContest() {
		return descriptionOfContest.getText();
	}

	public String getQuestionContest() {
		return questionOfContest.getText();
	}

	public boolean readMoreIsVisible() {

		return readMoreLink.isDisplayed();
	}

	public void goToViewResources() {
		this.readMoreLink.click();

	}

	public List<String> getResourcesParagraphs() {
		List<WebElement> paragraphs;
		List<String> paragraphText = new ArrayList<String>();
		paragraphs = contentResources.findElements(By.tagName("p"));
		for (int i = 1; i < paragraphs.size(); i++) {
			paragraphText.add(paragraphs.get(i).getText());
		}

		return paragraphText;
	}

	public boolean checkThatOntologyWhatExist(String whatOntologyName) {
		// TODO Auto-generated method stub
		return driver.findElement(By.linkText(whatOntologyName)).isDisplayed();
	}

	public boolean checkThatOntologyWhereExist(String whereOntologyName) {
		// TODO Auto-generated method stub
		return driver.findElement(By.linkText(whereOntologyName)).isDisplayed();
	}

	public boolean checkThatOntologyWhoExist(String whoOntologyName) {
		// TODO Auto-generated method stub
		return driver.findElement(By.linkText(whoOntologyName)).isDisplayed();
	}

	public boolean checkThatOntologyHowExist(String howOntologyName) {
		// TODO Auto-generated method stub
		return driver.findElement(By.linkText(howOntologyName)).isDisplayed();
	}

	public boolean checkIfTeamIsShownInContestPage(String nameIAFellow, String nameFellow, String nameAdvisor,
			String nameJudge) {
		boolean equalsNames = false;

		if (this.namesTeamMembers.get(0).getText().equals(nameIAFellow)
				&& this.namesTeamMembers.get(1).getText().equals(nameFellow)
				&& this.namesTeamMembers.get(2).getText().equals(nameAdvisor)
				&& this.namesTeamMembers.get(3).getText().equals(nameJudge)) {
			equalsNames = true;
		}

		return equalsNames;
	}

	public int getSizeTeam() {
		return this.namesTeamMembers.size();

	}

	public void clickOnCreateNewProposal() {
		this.createProposalButton.click();

	}

	public boolean createProposalButtonIsEnabled() {
		boolean displayed = false;
		try {
			displayed = this.createProposalButton.isDisplayed();
		} catch (NoSuchElementException ex) {

		}
		return displayed;
	}

	public boolean isProposalInContest(String titulo) {
		boolean proposalNameExist = false;
		int i = 0;
		while (i < this.proposalNames.size() && !proposalNameExist) {
			if (proposalNames.get(i).equals(titulo)) {
				proposalNameExist = true;
			}
			i++;
		}
		return proposalNameExist;
	}

	public ProposalDetailsPage clickOnAProposalCreatedBy(String proposalCreator) {
		driver.findElement(By.xpath(
				"//div[@class='c-TableGrid__row c-TableGrid__row--continued                                           ']/div/a[contains(text(),'"
						+ proposalCreator + "')]"))
				.click();
		return new ProposalDetailsPage(this.driver);
	}

	public DiscussionPage clickOnDiscuss() {
		discussButton.click();
		return new DiscussionPage(this.driver);
	}

	public String getNameOfRandomProposal() {
		int i = (int) (Math.random() * this.proposals.size());
		return driver
				.findElements(
						By.xpath("//div[@class='col-12 col-lg-5 col-xl-6 c-TableGrid__cell propname-authors']/a[1]"))
				.get(i).getText();
	}

	public ProposalDetailsPage clickOnProposalByName(String proposalName) {
		driver.findElement(By.linkText(proposalName)).click();
		return new ProposalDetailsPage(driver);
	}

	public void waitUntilProposalIsViewInSemiFinalistPhase(final String proposalName) {

		Thread a = new Thread() {

			public void run() {

				do {
					driver.navigate().refresh();
					try {
						this.sleep(3000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				} while (true);

			}
		};

		try {
			a.start();
			WebDriverWait wait = new WebDriverWait(driver, 240);

			wait.pollingEvery(5, TimeUnit.SECONDS).until(ExpectedConditions.and(
					ExpectedConditions.presenceOfElementLocated(By.linkText(proposalName)),
					ExpectedConditions.presenceOfElementLocated(By.xpath(
							"//div[@class='c-Count c-Count--accent' and contains(text(),'Selección de semifinalistas')]"))));
		} catch (TimeoutException ex) {
			ex.printStackTrace();
		} finally {
			a.stop();
		}

//		boolean rightPhase=false;
//		
//		future.add(Calendar.MINUTE, 1);
//		do {
//			now = Calendar.getInstance();
//			this.driver.navigate().refresh();
//			rightPhase=driver.findElement(By.cssSelector(".c-Count.c-Count--accent")).getText().contains(" hours until Semi-Finalist selection ends");
//		
//		}while((!driver.findElement(By.linkText(proposalName)).isDisplayed() && rightPhase)||now.compareTo(future)!=0) ; 
//		}
//		
	}

	public boolean checkIfProposalIsShowInProposalRevisionPhase(String proposalName) {

		boolean isShown = false;
		Thread a = new Thread() {

			public void run() {

				do {
					driver.navigate().refresh();
				} while (true);

			}
		};

		try {
			a.start();
			WebDriverWait wait = new WebDriverWait(driver, 240);

			wait.pollingEvery(5, TimeUnit.SECONDS).until(ExpectedConditions.and(
					ExpectedConditions.presenceOfElementLocated(By.linkText(proposalName)),
					ExpectedConditions.presenceOfElementLocated(By.xpath(
							"//div[@class='c-Count c-Count--accent' and contains(text(),'Revisión de propuestas')]"))));
			isShown = true;
		} catch (TimeoutException ex) {
			isShown = false;
		} finally {
			a.stop();
			return isShown;
		}
	}

//	public boolean checkVisibilityOfAdvanceProposalSelect() {
//		boolean visible = false;
//		try {
//			visible = advanceProposalSelect.isDisplayed();
//		} catch (NoSuchElementException ex) {
//			visible = false;
//		} finally {
//			return visible;
//		}
//	}

//	public void selectMaxScoreRatings() {
//		this.noveltyMaxScore.click();
//		this.feasibilityMaxScore.click();
//		this.impactMaxScore.click();
//		this.presentationMaxScore.click();
//
//	}
//
//	public void advanceProposal() {
//		Select select = new Select(this.advanceProposalSelect);
//		select.selectByValue("true");
//
//	}
//
//	public void saveProposalJudging() {
//		this.saveProposalJudgingButton.click();
//
//	}
//
//	public void writeJudgingComment(String comment) {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//
//		wait.until(ExpectedConditions.visibilityOf(commentTextArea));
//		this.commentTextArea.clear();
//		this.commentTextArea.sendKeys(comment);
//	}

	public boolean checkIfCreateNewProposalButtonIsDisplay() {
		boolean display = false;
		try {
			display = this.createProposalButton.isDisplayed();
		} catch (NoSuchElementException ex) {
			display = false;
			logger.info("Elemento no encontrado");
		} finally {
			return display;
		}
	}

	public void clickOnSubscribeButton() {
		this.subscribeButton.click();
	}

	public void clickOnUnsubscribeButton() {
		this.unsubscribeButton.click();
	}

	public boolean unsubscribeButtonIsDisplay() {
		boolean isDisplay = false;
		try {
			isDisplay = this.unsubscribeButton.isDisplayed();
		}
		catch(NoSuchElementException ex) {
			isDisplay = false;
		}
		return isDisplay;
	}

	public boolean subscribeButtonIsDisplay() {
		boolean isDisplay = false;
		try {
			isDisplay = this.subscribeButton.isDisplayed();
		}
		catch(NoSuchElementException ex) {
			isDisplay = false;
		}
		return isDisplay;
	}

	public void waitUntilProposalIsViewInFinalistPhase(final String proposalName) {

		Thread a = new Thread() {

			public void run() {

				do {
					driver.navigate().refresh();
					try {
						this.sleep(3000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				} while (true);

			}
		};

		try {
			a.start();
			WebDriverWait wait = new WebDriverWait(driver, 240);

			wait.pollingEvery(5, TimeUnit.SECONDS).until(ExpectedConditions.and(
					ExpectedConditions.presenceOfElementLocated(By.linkText(proposalName)),
					ExpectedConditions.presenceOfElementLocated(By.xpath(
							"//div[@class='c-Count c-Count--accent' and contains(text(),'Selección de finalistas')]"))));
		} catch (TimeoutException ex) {
			ex.printStackTrace();
		} finally {
			a.stop();
		}

//		boolean rightPhase=false;
//		
//		future.add(Calendar.MINUTE, 1);
//		do {
//			now = Calendar.getInstance();
//			this.driver.navigate().refresh();
//			rightPhase=driver.findElement(By.cssSelector(".c-Count.c-Count--accent")).getText().contains(" hours until Semi-Finalist selection ends");
//		
//		}while((!driver.findElement(By.linkText(proposalName)).isDisplayed() && rightPhase)||now.compareTo(future)!=0) ; 
//		}
//		
	}

	public boolean checkIfProposalIsShowInVotingPhase(final String proposalName) {

		boolean isShown = false;
		Thread a = new Thread() {

			public void run() {

				do {
					driver.navigate().refresh();
				} while (true);

			}
		};

		try {
			a.start();
			WebDriverWait wait = new WebDriverWait(driver, 240);

			wait.pollingEvery(5, TimeUnit.SECONDS).until(ExpectedConditions.and(
					ExpectedConditions.presenceOfElementLocated(By.linkText(proposalName)),
					ExpectedConditions.presenceOfElementLocated(By.xpath(
							"//div[@class='c-Count c-Count--accent' and contains(text(),'Periodo de votaciones')]"))));
			isShown = true;
		} catch (TimeoutException ex) {
			isShown = false;
		} finally {
			a.stop();
			return isShown;
		}
	}

	public String getCurrentPhase() {
		return driver.findElement(By.xpath("//div[@class='c-Count c-Count--accent']")).getText();
	}

	public int getNumberOfProposals() {
		return this.proposals.size();
	}

}