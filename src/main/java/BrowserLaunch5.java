import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch5 {

    private static WebDriver driver;

    public static void main(String[] args) {
        BrowserLaunch5 browserLaunch5 = new BrowserLaunch5();
        browserLaunch5.launchBrowser("chrome", "mac");
        browserLaunch5.waitFor(2);
        //browserLaunch5.searchForJavaBooksAndValidate();
        //browserLaunch5.loginToAmazon();
        browserLaunch5.clickOnBestSeller();
        browserLaunch5.waitFor(5);
        browserLaunch5.quitBrowser();
    }

    public void clickOnBestSeller() {
        //driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']")).click();
        driver.findElement(By.linkText("Amazon Rewards Visa Signature Cards"));

    }

    public void loginToAmazon() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("ap_password")).sendKeys("mypassword");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public void searchForJavaBooksAndValidate() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        boolean result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).isDisplayed();
        if (result == true) {
            System.out.println(result + " : element is displayed");
        } else {
            System.out.println(result + " : element is not displayed");
        }
        //span[@id='whatever']
        //span[text()='Mastering JavaFX 10: Build advanced and visually stunning Java applications']
        //span[contains(text(),'Mastering JavaFX 10')]
        driver.findElement(By.xpath("//span[text()='Mastering JavaFX 10: Build advanced and visually stunning Java applications']")).click();
    }


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

    public void quitBrowser() {
        driver.quit();
    }

}
