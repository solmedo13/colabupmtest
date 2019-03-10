package madridcolabtest.steps;


import madridcolabtest.pageobjects.AboutPage;
import madridcolabtest.pageobjects.ContentPage;
import madridcolabtest.pageobjects.MainPage;
import madridcolabtest.selenium.DriverManagerFactory;
import madridcolabtest.selenium.DriverType;
import madridcolabtest.selenium.WebDriverManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AboutSteps {
	private WebDriverManager driverManager;
	private WebDriver driver;
	private MainPage mainPage;
	private AboutPage aboutPage;
	private ArrayList<String> sections;
	private ArrayList<String> sectionsInHowTo;
	private String contentHtml;
	private ContentPage contentPage;
	@Given("^la pagina de informacion sobre la plataforma$")

	public void startAndGoToAbout() {
		driverManager = DriverManagerFactory.getDriver(DriverType.CHROME);
		driver = driverManager.getDriver();
		// TODO cogerlo de properties
		driver.get("http://localhost:18082");
		mainPage = new MainPage(driver);
		aboutPage = mainPage.goToAbout();
	}

	@When("^se comprueban las secciones principales que contiene$")
	public void getSections() {
		sections = aboutPage.getSections();
	}
    @Then("^son Acerca de Madrid CoLab, Origen ,Como funciona, Preguntas frecuentes, Personas, Equipo, Colaboradores y Contacto$")
    public void checkIfSectionsAreOk(){
    	Assert.assertEquals(sections.get(0),"Acerca de Madrid CoLab");
    	Assert.assertEquals(sections.get(1),"Origen");
    	Assert.assertEquals(sections.get(2),"¿Cómo funciona?");
    	Assert.assertEquals(sections.get(3),"Preguntas frecuentes");
    	Assert.assertEquals(sections.get(4),"Personas");
    	Assert.assertEquals(sections.get(5),"Equipo");
    	Assert.assertEquals(sections.get(6),"Colaboradores");
    	Assert.assertEquals(sections.get(7),"Contacto");
    
    }  
    @When("^se comprueban las secciones dentro de la seccion Como funciona$")
   public void getSectionsInHowTo() {
    	sectionsInHowTo=aboutPage.getSectionsInHowTo();
    }
   @Then("^son Concursos y Areas de trabajo y Participa$")
   public void checkIfSectionsInHowToAreCorrect() {
	   Assert.assertEquals(sectionsInHowTo.get(0), "Concursos y Áreas de trabajo");
	   Assert.assertEquals(sectionsInHowTo.get(1), "Participa");
   }
    @When("^se comprueba el contenido de la seccion Acerca de Madrid CoLab$")
    public void getAboutHtml() {
    	this.contentHtml=aboutPage.getAboutContentHtml();
    }
  
    
    @When("^se comprueba el contenido de la seccion Origen$")
    public void getOriginHtmlHtml() {
    	this.contentHtml=aboutPage.getOriginContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Concursos y Area de trabajo$")
    public void getContestAndWorkSpaceHtml() {
    	this.contentHtml=aboutPage.getContestAndWorkspacesContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Participa$")
    public void getTakePartHtml() {
    	this.contentHtml=aboutPage.getTakePartContentHtml();
    }
    
   
     
    @When("^se comprueba el contenido de la seccion Preguntas frecuentes$")
   public void frequentQuestionsHtml() {
    	this.contentHtml=aboutPage.getFrequentQuestionsContentHtml();
    }
    

    @When("^se comprueba el contenido de la seccion Personas$")
    public void getPeopleHtml() {
    	this.contentHtml=aboutPage.getPeopleContentHtml();
    }
  
    
    @When("^se comprueba el contenido de la seccion Equipo$")
    public void getTeamHtml() {
    	this.contentHtml=aboutPage.getTeamContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Colaboradores$")
    public void getCollaboratorsHtml() {
    	this.contentHtml=aboutPage.getCollaboratorsContentHtml();
    }
    
    @When("^se comprueba el contenido de la seccion Contacto$")
   public void getContactHtml() {
    	this.contentHtml=aboutPage.getContactContentHtml();
    }
    @Then("^coincide con el del fichero \"([^\"]*)\"$")
    public void checkIfEqualsThatFile(String fileName) {
    	String htmlContentInFile = "";
    	  try {
        	  
    		  BufferedReader br = new BufferedReader(new InputStreamReader(
    				    new FileInputStream(".\\src\\test\\resources\\madridcolabtest\\pageshtmldefinition\\"+fileName), "UTF-8"));
        	  
        	  String st; 
        	  
			while ((st = br.readLine()) != null) {
				htmlContentInFile = htmlContentInFile+st;
			  }
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
    	  System.out.println("-------------------------------------");
    	System.out.println(htmlContentInFile);
	    System.out.println(this.contentHtml.replaceAll("\\n", "").trim());
    	Assert.assertEquals(htmlContentInFile, this.contentHtml.replaceAll("\\n", "").trim());
    }
    
    @Given("^la pagina de terminos de uso$")
    public void loadTermsOfUsePage(){
    	driverManager = DriverManagerFactory.getDriver(DriverType.CHROME);
		driver = driverManager.getDriver();
		// TODO cogerlo de properties
		driver.get("http://localhost:18082/wiki/Terms+of+use");
		contentPage = new ContentPage(driver);
    }

    @When("^se comprueba el contenido$")
    public void checkContent(){
    	contentHtml = contentPage.getMainContentHtml();
    }

    @Given("^la pagina de normas de los concursos$")
    public void loadContestsRulesPage() {
    	driverManager = DriverManagerFactory.getDriver(DriverType.CHROME);
		driver = driverManager.getDriver();
		// TODO cogerlo de properties
		driver.get("http://localhost:18082/wiki/Contest+rules");
		contentPage = new ContentPage(driver);   
    }

    @Given("^la pagina politicas de privacidad$")
    public void loadPrivacyPolicyPage() {
     	driverManager = DriverManagerFactory.getDriver(DriverType.CHROME);
    		driver = driverManager.getDriver();
    		// TODO cogerlo de properties
    		driver.get("http://localhost:18082/wiki/Privacy+policy");
    		contentPage = new ContentPage(driver);   
    }

    @Given("^la pagina de filosofia y politicas comunes$")
    public void loadPhilosophyandCommonPoliticsPage()  {
     	driverManager = DriverManagerFactory.getDriver(DriverType.CHROME);
    		driver = driverManager.getDriver();
    		// TODO cogerlo de properties
    		driver.get("http://localhost:18082/wiki/Filosof%C3%ADa+y+Pol%C3%ADticas+Comunes");
    		contentPage = new ContentPage(driver);   
    }

	@After ("@About")
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png"); //stick it in the report
	    }
	    driver.close();
	}

    
}