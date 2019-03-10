package madridcolabtest.selenium;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
	protected WebDriver driver;
	protected abstract void startService();
	protected abstract void stopService();
	protected abstract void createDriver();
	
	public WebDriver getDriver() {
		startService();
		createDriver();
		return this.driver;
	}
}
