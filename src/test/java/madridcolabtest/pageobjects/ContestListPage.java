package madridcolabtest.pageobjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContestListPage extends AbstractPageObject {
	@FindBy(xpath = "//a[@href='/contests?viewType=GRID&filter=&showAllContests=true']")
	private WebElement buttonAllContests;
	@FindBy(xpath = "//a[@href='/contests?viewType=LIST&filter=&showAllContests=true']")
	private WebElement buttonToListMode;
	@FindBy(xpath = "//a[@href='/contests?viewType=OUTLINE&filter=&showAllContests=true']")
	private WebElement buttonToAttributeMode;
	@FindBy(xpath="//div[@class='c-ContestBox']")
	private List<WebElement> visibleContests;
	private ArrayList<Integer> contestWithProposals = new ArrayList();
	@FindBy(xpath="//div[@class='c-ContestBox__metaCount']/span[1]/strong")
	private List<WebElement> countCommentsValues;
	
	public ContestListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void viewAllContests() {
		buttonAllContests.click();
	}

	public boolean checkIfContestVisible(String nameOfContest) {

		String nameOfContestAux = nameOfContest.replaceAll("\\.", "");
		nameOfContestAux = nameOfContestAux.replaceAll(" ", "-");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		nameOfContestAux = "//a[@href='/contests/" + year + "/".concat(nameOfContestAux + "']");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nameOfContestAux))));
		return driver.findElement(By.xpath(nameOfContestAux)).isDisplayed();
	}

	public void changeToViewAttributes() {

		buttonToAttributeMode.click();
	}

	public void changeToViewList() {
		buttonToListMode.click();
	}

	public ContestPage clickOnContestByName(String contestName) {
		driver.findElement(By.linkText(contestName)).click();
		return new ContestPage (this.driver);
	}

	private void loadContestsWithProposals() {
		for (int i = 0; i<this.visibleContests.size();i++) {
			if(Integer.parseInt(this.countCommentsValues.get(i).getText())>0) {
				this.contestWithProposals.add(i);
			}
			
		}
	}


	public String getNameOfrandomContestWithProposals() {
		this.loadContestsWithProposals();
		int i = (int) (Math.random() * this.contestWithProposals.size())+1;
		return driver.findElement(By.xpath("//div[@class='c-ContestBox']["+i+"]/div/div/h3")).getText();
		
	}



}
