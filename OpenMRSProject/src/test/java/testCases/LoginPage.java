package testCases;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import resources.Base;

public class LoginPage extends Base {
	
	public LoginPage lp;
	public LoginPageObject lpo;
	//public RegisterAPatientObject rpo;
	public static Logger log = (Logger) LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	/*public LoginPage(WebDriver driver) {
		this.driver = driver;
	}*/
	

	
	@Test
	public void loginToApp() {
		lpo = new LoginPageObject(driver);
		driver.get(prop.getProperty("url"));
		lpo.enterUsername("Admin");
		lpo.enterPassword("Admin123");
		lpo.SelectLocation();
		lpo.clickOnLoginBtn();
	//	return rpo = new RegisterAPatientObject(driver);
	}

}
