package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch3 {

    private WebDriver driver;

    public static void main(String[] args) {
        BrowserLaunch3 browserLaunch2 = new BrowserLaunch3();
        browserLaunch2.launchBrowser("firefox", "mac");
        browserLaunch2.waitFor5Seconds();
        browserLaunch2.quitBrowser();
    }

    public void launchBrowser(String browserName, String os) {
        //chrome
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        //firefox
        else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }
        //browser opens & navigate to the url
        driver.get("https://www.amazon.com");
    }

    public void waitFor5Seconds() {
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
