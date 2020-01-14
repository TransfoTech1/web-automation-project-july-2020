package seleniumPractices;

import com.amazon.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MousehoverAndScrollingTest extends TestBase {

    @Test(enabled = false)
    public void testMouseHover() {
        Actions actions = new Actions(driver);
        WebElement motors = driver.findElement(By.linkText("Motors"));
        actions.moveToElement(motors).build().perform();
        waitFor(2);
        driver.findElement(By.linkText("Cars & Trucks")).click();
    }


    @Test(enabled = false)
    public void scrollToTheWebElement() {
        WebElement startSelling = driver.findElement(By.linkText("Start selling"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", startSelling);
        waitFor(10);
    }

    @Test
    public void testScroller() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        waitFor(5);
        js.executeScript("window.scrollBy(0,1000)");
        waitFor(5);
    }


}
