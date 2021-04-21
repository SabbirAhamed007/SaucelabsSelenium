package stepDEFinition;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApartmentsAlif {

	private WebDriver driver;
	private String sessionId;
	private WebDriverWait wait;

	private String username = System.getenv("SAUCE_USERNAME");
	private String accesskey = System.getenv("SAUCE_ACCESS_KEY");

	private final String BASE_URL = "https://buyrentbd.com/property/alif-ail-properties-ltd/";

	@io.cucumber.java.Before
	public void setUp(Scenario scenario) throws MalformedURLException {

		// Set up the ChromeOptions object, which will store the capabilities for the
		// Sauce run
		ChromeOptions caps = new ChromeOptions();
		caps.setCapability("version", "latest");
		caps.setCapability("platform", "Windows 10");
		caps.setExperimentalOption("w3c", true);

		// Create a map of capabilities called "sauce:options", which contain the info
		// necessary to run on Sauce
		// Labs, using the credentials stored in the environment variables. Also runs
		// using the new W3C standard.
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "Spartan_QA");
		sauceOptions.setCapability("accessKey", "228f3809-3940-4b84-b9ef-91f187e0e586");
		sauceOptions.setCapability("seleniumVersion", "3.141.59");
		sauceOptions.setCapability("name", scenario.getName());

		// Assign the Sauce Options to the base capabilities
		caps.setCapability("sauce:options", sauceOptions);

		// Create a new RemoteWebDriver, which will initialize the test execution on
		// Sauce Labs servers
		String SAUCE_REMOTE_URL = "https://ondemand.saucelabs.com/wd/hub";
		driver = new RemoteWebDriver(new URL(SAUCE_REMOTE_URL), caps);
		sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
		wait = new WebDriverWait(driver, 55);

	}

	@io.cucumber.java.After

	public void tearDown(Scenario scenario) {
		driver.quit();
	}

	@Given("I open Alif Ail apartments")
	public void i_open_alif_ail_apartments() {

		driver.get(BASE_URL);

	}

	@Given("change the picture for alif ail apartments")
	public void change_the_picture_for_alif_ail_apartments() {

		driver.findElement(By.xpath("//a[@class='flex-next']")).click();

		driver.findElement(By.xpath("//a[@class='flex-prev']")).click();

	}

	@When("I verify text for alif ail apartments")
	public void i_verify_text_for_alif_ail_apartments() {

		WebElement element = driver.findElement(By.xpath("//div[@class='content clearfix']"));

		System.out.println(element.getText());

	}

	@When("I verify monthly mortgage payment for alif ail apartments")
	public void i_verify_monthly_mortgage_payment_for_alif_ail_apartments() {

		driver.findElement(By.id("mc-down-payment")).sendKeys("100");

		driver.findElement(By.id("mc-interest-rate")).sendKeys("8.4");

		driver.findElement(By.id("mc-mortgage-period")).sendKeys("14");

		driver.findElement(By.id("mc-submit")).click();

	}

	@Then("close the browser for alif ail apartments")
	public void close_the_browser_for_alif_ail_apartments() {

		driver.quit();

	}

}
