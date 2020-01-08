package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BrowserLaunch6 {

    private static WebDriver driver;

    @Test
    public void validateOrders() {
        String valueOrders = driver.findElement(By.id("nav-orders")).getText();
        System.out.println(valueOrders);
        String valuePrime = driver.findElement(By.id("nav-link-prime")).getText();
        System.out.println(valuePrime);
    }

    @Test
    public void clickOnBestSeller() {
        driver.findElement(By.partialLinkText("Manage Your Content")).click();
    }

    @Test
    public void clickOnCustomerService() {
        driver.findElement(By.xpath(" //a[@href='/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_customerservice']")).click();
    }

    @Test
    public void loginToAmazon() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("ap_password")).sendKeys("mypassword");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test
    public void searchForJavaBooksAndValidate() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        boolean result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).isDisplayed();
        if (result == true) {
            System.out.println(result + " : element is displayed");
        } else {
            System.out.println(result + " : element is not displayed");
        }
        driver.findElement(By.xpath("//span[text()='Mastering JavaFX 10: Build advanced and visually stunning Java applications']")).click();
    }


    @BeforeMethod
    public void launchBrowserTemporary() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println("browser launched from temp method");
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }


    @Test
    public void userBeingAbleToClickOnCart() throws InterruptedException {
        driver.findElement(By.id("nav-cart")).click();
        Thread.sleep(5000);
    }


    @Test
    public void userBeingAbleToGoToBestSellersMostWishedFor() throws InterruptedException {
        driver.findElement(By.linkText("Best Sellers")).click();
        driver.findElement(By.linkText("Most Wished For")).click();
        Thread.sleep(5000);

        boolean bucket = driver.findElement(By.id("zg_banner_text_wrapper")).isDisplayed();
        System.out.println(bucket);

        if (bucket == true) {
            System.out.println("Banner is displayed");
        } else {
            System.out.println("Banner is not displayed");
        }

        String data = driver.findElement(By.id("zg_banner_text_wrapper")).getText();
        System.out.println(data);

        //expected -- Amazon Most Wished For
        //actual -- data
        //if expected and actual is same or not

        if (data.equalsIgnoreCase("Amazon Most Wished For")) {
            System.out.println(" both values are similar");
        } else {
            System.out.println("both values are not similar");
        }
    }


    @Test
    public void userBeingAbleToGoToBestSellersMostWishedFor2() throws InterruptedException {
        driver.findElement(By.linkText("Best Sellers")).click();
        driver.findElement(By.linkText("Most Wished For")).click();
        Thread.sleep(5000);

        // Assertion
        boolean bucket = driver.findElement(By.id("zg_banner_text_wrapper")).isDisplayed();
        Assert.assertEquals(bucket, true);
        String data = driver.findElement(By.id("zg_banner_text_wrapper")).getText();
        Assert.assertEquals(data, "Amazon Most Wished ");
    }

    @Test
    public void homeWorkGetAllHeadersInArrayList() {
        ArrayList<String> arrayListOfHeader = new ArrayList<String>();
        String bucket = driver.findElement(By.linkText("Today's Deals")).getText();
        arrayListOfHeader.add(bucket);
        arrayListOfHeader.add(driver.findElement(By.linkText("Best Sellers")).getText());
        //System.out.println(arrayListOfHeader);

        for (int i = 0; i < arrayListOfHeader.size(); i++) {
            System.out.println(arrayListOfHeader.get(i));
        }
    }
}
