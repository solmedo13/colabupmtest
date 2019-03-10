package madridcolabtest.selenium;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
public class FirefoxDriverManager extends WebDriverManager {
	private GeckoDriverService firefoxService;
	
	        
	@Override
	protected void startService() {
		if(firefoxService ==null) {
			try {
				firefoxService = new GeckoDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\solmedom\\Desktop\\geckodriver.exe")).build();

				firefoxService.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void stopService() {
		if (firefoxService!=null && firefoxService.isRunning()) {
			firefoxService.stop();
		}
		
	}

	@Override
	protected void createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("test-type");
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
		driver = new FirefoxDriver(firefoxService,capabilities);
	}

}
