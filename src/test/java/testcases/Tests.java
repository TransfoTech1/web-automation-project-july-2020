package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Tests extends TestBase {

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
        clickByXpath(" //a[@href='/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_customerservice']");
    }

    @Test
    public void loginToAmazon() {
        clickById("nav-link-accountList");
        sendKeysUsingId("ap_email", "testuser@gmail.com");
        clickByXpath("//input[@type='submit']");
        sendKeysUsingId("ap_password", "mypassword");
        clickByXpath("//input[@type='submit']");
    }

    @Test
    public void searchForJavaBooksAndValidate() {
        sendKeysUsingId("twotabsearchtextbox", "Java Books");
        clickByXpath("//input[@value='Go']");
        boolean result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).isDisplayed();
        if (result == true) {
            System.out.println(result + " : element is displayed");
        } else {
            System.out.println(result + " : element is not displayed");
        }
        clickByXpath("//span[text()='Head First Java, 2nd Edition']");
    }

}
