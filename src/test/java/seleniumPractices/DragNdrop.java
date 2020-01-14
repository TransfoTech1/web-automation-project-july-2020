package seleniumPractices;

import com.amazon.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragNdrop extends TestBase {

    public static void draG() {

    }

    public static void main(String[] args) {
        draG();
    }

    @Test
    public void testDragNdrop() {
        WebElement from = driver.findElement(By.xpath("(//li[@data-id='2'])[2]"));
        WebElement to = driver.findElement(By.id("amt8"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).build().perform();
        waitFor(5);
    }

    //homework -- create a method which will take 2 WebElements "from" and "to"
    // and perform the dragNdrop


}
