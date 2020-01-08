package seleniumPractices;

import com.amazon.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MousehoverTest extends TestBase {

    @Test
    public void testMouseHover() {
        Actions actions = new Actions(driver);
        WebElement motors = driver.findElement(By.linkText("Motors"));
        actions.moveToElement(motors).build().perform();
        waitFor(2);
        driver.findElement(By.linkText("Cars & Trucks")).click();
    }

}
