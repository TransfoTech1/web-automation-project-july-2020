package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch1 {

    public static void main(String[] args) {
        // IllegalStateException -- The path to the driver executable must be set by the webdriver.chrome.driver system property
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //launch browser & goes to the url provided
        driver.get("https://www.amazon.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //quites the browser
        driver.quit();
    }

}
