package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class LoginPageObject {
	private final Logger logger = LogManager.getLogger(LoginPageObject.class);
	public WebDriver driver;
	WebDriverWait wait;

	private By username = By.id("username");
	private By password = By.id("password");
	private By login = By.id("loginButton");
	private By location = By.id("Inpatient Ward");

//============= Constructor ========================================================================//
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;

	}

//============ 1. Method to validate SignIn Button =================================================//
	public void loginButtonValidation() {
		WebElement loginBtn = driver.findElement(login);
		Assert.assertEquals(true, loginBtn.isDisplayed());
		logger.info("Validated the Login Button");

	}

//============ 2. Method to enter username =================================================//
	public void enterUsername(String user) {

		WebElement unsernameBox = driver.findElement(username);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(unsernameBox));
		unsernameBox.sendKeys(user);
		logger.info("Entered username");

	}

	// ============ 3. Method to enter password
	// =================================================//
	public void enterPassword(String pass) {

		WebElement passwordBox = driver.findElement(password);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(passwordBox));
		passwordBox.sendKeys(pass);
		logger.info("Entered password");

	}

//============ 4. Method to click on Login Button =================================================//
	public void clickOnLoginBtn() {

		WebElement loginBtn = driver.findElement(login);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		loginBtn.click();
		logger.info("Clicked on the Login Button");

	}

	public void SelectLocation() {

		WebElement locationOption = driver.findElement(location);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locationOption));
		locationOption.click();
		logger.info("Selected location option Inpatient Ward");

	}

//============ 5. Method to validate Login page title =============================================//
	public void validateLoginPage(String LoginPageTitle) {
		wait = new WebDriverWait(driver, 20);
		boolean xyz = wait.until(ExpectedConditions.titleIs(LoginPageTitle));
		Assert.assertEquals(true, xyz);
		logger.info("Validate title of Login page, so title is: " + LoginPageTitle);

	}

//==================================================================================================//

}
