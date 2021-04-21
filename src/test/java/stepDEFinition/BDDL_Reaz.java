package stepDEFinition;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDDL_Reaz {

	private WebDriver driver;
	private String sessionId;
	private WebDriverWait wait;

	private String username = System.getenv("SAUCE_USERNAME");
	private String accesskey = System.getenv("SAUCE_ACCESS_KEY");

	private final String BASE_URL = "https://buyrentbd.com/property/bddl-gold-palace-%e0%a6%ac%e0%a6%bf%e0%a6%a1%e0%a6%bf%e0%a6%a1%e0%a6%bf%e0%a6%8f%e0%a6%b2-%e0%a6%97%e0%a7%8b%e0%a6%b2%e0%a7%8d%e0%a6%a1-%e0%a6%aa%e0%a7%8d%e0%a6%af%e0%a6%be%e0%a6%b2%e0%a7%87/";

	@io.cucumber.java.Before
	public void setUp(Scenario scenario) throws MalformedURLException {

		// Set up the ChromeOptions object, which will store the capabilities for the
		// Sauce run
		DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "59.0");
        caps.setCapability("build", "Onboarding Sample App - Java-Junit5");
        caps.setCapability("name", "3-cross-browser");
        
        caps.setCapability("browserName", "firefox");
        caps.setCapability("platform", "macOS 10.15");
        caps.setCapability("version", "latest");
     

	 
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

	@Given("I open BDDL Reaz Bag apartment page")
	public void i_open_bddl_reaz_bag_apartment_page() {

		driver.get(BASE_URL);

	}

	@Given("change the picture for BDDL Reaz Bag apartment")
	public void change_the_picture_for_bddl_reaz_bag_apartment() {

		driver.findElement(By.xpath("//a[@class='flex-next']")).click();

		driver.findElement(By.xpath("//a[@class='flex-prev']")).click();

	}

	@When("I verify text for BDDL Reaz Bag apartment")
	public void i_verify_text_for_bddl_reaz_bag_apartment() {

		WebElement element = driver.findElement(By.xpath("//div[@class='content clearfix']"));

		System.out.println(element.getText());

	}

	@When("I verify monthly mortgage payment for BDDL Reaz Bag apartment")
	public void i_verify_monthly_mortgage_payment_for_bddl_reaz_bag_apartment() {

		driver.findElement(By.id("mc-down-payment")).sendKeys("500000");

		driver.findElement(By.id("mc-interest-rate")).sendKeys("7.5");

		driver.findElement(By.id("mc-mortgage-period")).sendKeys("18");

		driver.findElement(By.id("mc-submit")).click();

	}

	@Then("close the browser for BDDL Reaz Bag apartment")
	public void close_the_browser_for_bddl_reaz_bag_apartment() {

		driver.quit();

	}

}
