package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

    public static WebDriver driver;

    @Parameters({"browserName", "os"})
    @BeforeMethod
    public void launchBrowser(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }
        driver.get("https://www.amazon.com");
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
