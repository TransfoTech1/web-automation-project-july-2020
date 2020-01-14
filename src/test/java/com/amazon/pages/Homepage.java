package com.amazon.pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Homepage extends TestBase {

    // page object model -- 1 class against 1 page, contains all the locators


    //driver.findElement(By.linkText("Today's Deals")
    @FindBy(linkText = "Today's Deals")
    private WebElement todaysDeal;

    @FindBy(id = "nav-link-accountList")
    private WebElement signInBtn;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@data-menu-id='2']")
    private WebElement primeVideo;

    @FindBy(xpath = "//a[@data-menu-id='3']")
    private WebElement amazonMusic;

    @FindBy(xpath = "//a[@data-menu-id='4']")
    private WebElement echoNalexa;

    public void clickOnTodaysDeal() {
        //driver.findElement(By.linkText("Today's Deals")).click(); -- same as below line
        todaysDeal.click();
    }

    public void clickOnSignInButton() {
        signInBtn.click();
    }


    public void clickOnMenuButton() {
        menuButton.click();
    }

    public void validatePrimeVideo() {
        //boolean flag = primeVideo.isDisplayed();
        //Assert.assertEquals(flag,true);=
        Assert.assertTrue(primeVideo.isDisplayed());
        //String text = primeVideo.getText();
        Assert.assertEquals(primeVideo.getText(), "Prie Video");
    }


    public void validateMenuOptions() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(primeVideo.isDisplayed());
        softAssert.assertEquals(primeVideo.getText(), "Prime Video");

        softAssert.assertTrue(amazonMusic.isDisplayed());
        softAssert.assertEquals(amazonMusic.getText(), "Amaz Music");

        softAssert.assertTrue(echoNalexa.isDisplayed());
        softAssert.assertEquals(echoNalexa.getText(), "Echo & Alxa");

        softAssert.assertAll();
    }

}
