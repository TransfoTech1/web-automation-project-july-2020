import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch2 {

    WebDriver driver;

    public static void main(String[] args) {
        BrowserLaunch2 browserLaunch2 = new BrowserLaunch2();
        browserLaunch2.launchBrowser("firefox");
        browserLaunch2.wait5seconds();
        browserLaunch2.quitBrowser();
    }

    public void launchBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.get("https://www.amazon.com");
    }

    public void wait5seconds() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quitBrowser() {
        driver.quit();
    }

}
