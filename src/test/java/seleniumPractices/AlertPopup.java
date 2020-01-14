package seleniumPractices;

import com.amazon.base.TestBase;
import org.testng.annotations.Test;

public class AlertPopup extends TestBase {


    @Test
    public void webBasedPopup() {
        sendKeysUsingXpath("//input[@name='cusid']", "random");
        clickByXpath("//input[@name='submit']");
        waitFor(5);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        waitFor(5);
        clickByXpath("//input[@name='submit']");
        waitFor(5);
        driver.switchTo().alert().accept();
        System.out.println(driver.switchTo().alert().getText());
        waitFor(5);
        driver.switchTo().alert().accept();
        waitFor(10);
    }

}
