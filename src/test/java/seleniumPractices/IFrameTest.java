package seleniumPractices;

import com.amazon.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase {

    @Test
    public void testIframe() {
        driver.switchTo().frame("IF1");
        // name, id, index
        waitFor(10);
        driver.findElement(By.linkText("Software Testing Tutorial")).click();
    }

}
