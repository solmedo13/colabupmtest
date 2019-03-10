package madridcolabtest.selenium;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends WebDriverManager {
	private ChromeDriverService chService;


	@Override
	protected void startService() {
		if (chService == null) {
			try {
				chService = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\solmedo\\Desktop\\chromedriver.exe")).usingAnyFreePort().build();
				chService.start();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void stopService() {
		if (chService != null && chService.isRunning()) {
			chService.stop();
		}

	}

	@Override
	protected void createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(chService,capabilities);
	}

}
