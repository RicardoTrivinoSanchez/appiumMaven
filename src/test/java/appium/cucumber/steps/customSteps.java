package appium.cucumber.steps;

import appium.cucumber.utils.Capabilities;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class customSteps {

    private AppiumDriver driver;


    @After
    public void endUp() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^an Android user on (.*)$")
    public void anAndroidUserOnBrowser(String browser) throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), Capabilities.forAndroidBrowser(browser));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("^an iOS user on (.*)$")
    public void aniOSUserOnBrowser(String browser) throws Exception {
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), Capabilities.forIOSBrowser(browser));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @When("going to (http.*)$")
    public void goingToUrl(String url) {
        driver.get(url);
    }

    @Then("^the connection changes to HTTPS$")
    public void theConnectionChangesToHTTPS() throws MalformedURLException, InterruptedException {
        Thread.sleep(5000);
        URL url = new URL(driver.getCurrentUrl());
        Assert.assertEquals("Protocol should be HTTPS", "https", url.getProtocol());
    }

    @And("^the user is directed to mobile site$")
    public void theUserIsDirectedToMobileSite() throws MalformedURLException {
        URL url = new URL(driver.getCurrentUrl());
        Assert.assertTrue("Should redirect to mobile site", url.getQuery().contains("m=1"));
    }
}
