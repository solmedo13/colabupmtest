package madridcolabtest.selenium;

public class DriverManagerFactory {
	
	public static WebDriverManager getDriver(DriverType dType){
		WebDriverManager driverManager;
		switch(dType) {
		
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case IE:
			driverManager = new IEDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
		
	}


}
