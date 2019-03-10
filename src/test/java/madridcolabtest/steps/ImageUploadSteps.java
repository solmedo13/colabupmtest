package madridcolabtest.steps;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import madridcolabtest.pageobjects.MainPage;
import madridcolabtest.pageobjects.UploadImagePage;
import madridcolabtest.selenium.DriverManagerFactory;
import madridcolabtest.selenium.DriverType;
import madridcolabtest.selenium.WebDriverManager;

public class ImageUploadSteps {
	private WebDriver driver;
	private WebDriverManager driverManager;
	private UploadImagePage uploadImagePage;
	private int high;
	private int wide;
	

	@Given("^the upload image tool$")
	public void the_upload_image_tool() throws Throwable {
		driverManager = DriverManagerFactory.getDriver(DriverType.CHROME);
		driver = driverManager.getDriver();
		// TODO cogerlo de properties
		driver.get("http://localhost:18082/content-editor/imageUpload");
		uploadImagePage = new UploadImagePage(driver);
		
	}

	@When("^upload an image heavier than (\\d+)MB with crop button$")
	public void click_on_upload_image_for_crop_images(int size) throws Throwable {
		File file = new File ("src\\test\\resources\\madridcolabtest\\images\\imageHeavy.JPG");
		uploadImagePage.uploadCropImage(file.getAbsolutePath());
	
	}
	@When("^upload an image heavier than (\\d+)MB with direct button$")
	public void click_on_upload_direct_images(int size) throws Throwable {
		File file = new File ("src\\test\\resources\\madridcolabtest\\images\\imageHeavy.JPG");
		uploadImagePage.uploadDirectImage(file.getAbsolutePath());
	
	}

	@Then("^an error appear$")
	public void an_error_appear() throws Throwable {
		System.out.println("------------------"+uploadImagePage.getAlertMessage());
	    Assert.assertTrue(uploadImagePage.getAlertMessage().equals("Image upload failed."));
	}

	@When("^upload an image larger than 300x300 with crop button$")
	public void select_a_image_larger_than_limit_Crop_Button() throws Throwable {
		File file = new File ("src\\test\\resources\\madridcolabtest\\images\\imageLarger300x300.jpg");
		ImageIcon image = new ImageIcon(file.getAbsolutePath());
		
		this.wide = image.getIconWidth();
		this.high = image.getIconHeight();
		uploadImagePage.uploadCropImage(file.getAbsolutePath());
	}
	
	@When("^upload an image larger than 300x300 with direct button$")
	public void select_a_image_larger_than_limit_Direct_Button() throws Throwable {
		File file = new File ("src\\test\\resources\\madridcolabtest\\images\\imageLarger300x300_2.jpg");
		ImageIcon image = new ImageIcon(file.getAbsolutePath());
		
		this.wide = image.getIconWidth();
		this.high = image.getIconHeight();
		uploadImagePage.uploadDirectImage(file.getAbsolutePath());
	}

	@Then("^the image in the server has (\\d+)px wide x (\\d+)px high$")
	public void the_image_in_the_server_px_wide(int wide,int high) throws Throwable {
	   Assert.assertTrue(wide==uploadImagePage.getWideImageUploadWithCropOption());
	   Assert.assertTrue(high==uploadImagePage.getHighImageUploadWithCropOption());
	}


	@Then("^the image has the original size$")
	public void the_image_has_the_original_size() throws Throwable {
	    Assert.assertTrue(this.wide==uploadImagePage.getWideImageUploadWithoutCropOption());
	    Assert.assertTrue(this.high==uploadImagePage.getHighImageUploadWithoutCropOption());
	}

}
