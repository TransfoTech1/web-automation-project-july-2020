package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginToAmazon() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("ap_password")).sendKeys("mypassword");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

}
