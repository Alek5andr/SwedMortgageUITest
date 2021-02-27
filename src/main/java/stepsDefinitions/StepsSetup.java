package stepsDefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import services.Log;

public class StepsSetup {
    private static boolean isConfigured = false;

    @Before
    public void beforeScenario() {
        if (!isConfigured) {
            Configuration.reportsFolder = "errorShots";
            Configuration.startMaximized = true;
            Configuration.pageLoadTimeout = 10000;
            Configuration.browser = "Chrome";
            Configuration.browserCapabilities = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-background-networking",
                    "--disable-component-extensions-with-background-pages");
            Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            isConfigured = true;
        }

        Log.info("========== Start of Test ==========");
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {

            Log.error("Taking screenshot on failure.");
            scenario.attach(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES), "image/png", "errorShot");
        }
        Log.info("========== End of Test ==========");
    }

}
