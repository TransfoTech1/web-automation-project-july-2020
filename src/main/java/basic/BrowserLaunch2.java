package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch2 {

    private WebDriver driver;

    public static void main(String[] args) {
        BrowserLaunch2 browserLaunch2 = new BrowserLaunch2();
        browserLaunch2.launchBrowser();
        browserLaunch2.waitFor5Seconds();
        browserLaunch2.quitBrowser();
    }

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
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
