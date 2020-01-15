package seleniumPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudExecution {


    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browser", "firefox");
        desiredCapabilities.setCapability("browser_version", "71");
        desiredCapabilities.setCapability("os", "windows");
        desiredCapabilities.setCapability("os_version", "7");
        desiredCapabilities.setCapability("name", "Cloud Execution Transfotech");
        WebDriver driver = new RemoteWebDriver(
                new URL("http://zan14:Fs7PJAifzJnzs8dFMNxx@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);

        //http://username:userAccessKey@hub-cloud.browserstack.com/wd/hub

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
