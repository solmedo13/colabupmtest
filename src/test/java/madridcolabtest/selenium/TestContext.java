package madridcolabtest.selenium;

public class TestContext {
private DriverManagerFactory webDriverManagerFactory;
private PageObjectManager pageObjectManager;
private ScenarioContext scenarioContext;

public TestContext () {
	webDriverManagerFactory = new DriverManagerFactory();
	
	pageObjectManager = new PageObjectManager(webDriverManagerFactory.getDriver(DriverType.CHROME).getDriver());
	
	scenarioContext = new ScenarioContext();
}
public DriverManagerFactory getDriverManagerFactory() {
	return webDriverManagerFactory;
}
public PageObjectManager getPageObjectManager(){
	return pageObjectManager;
}

public ScenarioContext getScenarioContext() {
return scenarioContext;
}
}
