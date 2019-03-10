package madridcolabtest.selenium;

import java.io.File;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverManager extends WebDriverManager {
	private InternetExplorerDriverService ieService;

	@Override
	protected void startService() {
		if (ieService == null) {
			try {

				ieService = new InternetExplorerDriverService.Builder()
						.usingDriverExecutable(new File("C:\\Users\\solmedom\\Desktop\\IEDriverServer.exe"))
						.usingAnyFreePort().build();
				ieService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void stopService() {
		if (ieService != null && ieService.isRunning()) {
			ieService.stop();
		}

	}

	@Override
	protected void createDriver() {
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\solmedom\\Desktop\\IEDriverServer.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		InternetExplorerOptions ieOptions = new InternetExplorerOptions();
		driver = new InternetExplorerDriver(ieService, capabilities);
	}

}
