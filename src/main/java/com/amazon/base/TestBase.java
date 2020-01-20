package com.amazon.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import static com.amazon.base.ExtentTestManager.*;

public class TestBase {

    public static WebDriver driver;
    private static ExtentReports extent;

    @Parameters({"browserName", "os", "url", "cloud"})
    @BeforeMethod
    public void launchBrowser(String browserName, String os, String url, boolean cloud) throws MalformedURLException {
        if (cloud == false) {
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
        } else {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("browser", "firefox");
            desiredCapabilities.setCapability("browser_version", "71");
            desiredCapabilities.setCapability("os", "windows");
            desiredCapabilities.setCapability("os_version", "7");
            desiredCapabilities.setCapability("name", "Cloud Execution Transfotech");
            driver = new RemoteWebDriver(
                    new URL("http://zan14:Fs7PJAifzJnzs8dFMNxx@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
        }
        driver.get(url);
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

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickById(String id) {
        driver.findElement(By.xpath(id)).click();
    }

    public void sendKeysUsingId(String id, String data) {
        driver.findElement(By.id(id)).sendKeys(data);
    }

    public void sendKeysUsingXpath(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }


    //Extent report starts

    //Extent Report Setup
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentTestManager.setOutputDirectory(context);
        extent = ExtentTestManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    //Extent Report
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED : " + result.getName());
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED : " + result.getName() + " :: " + getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED : " + result.getName());
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    // Extent report ends
}
