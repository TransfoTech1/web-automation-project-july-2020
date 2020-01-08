package com.amazon.testcases;

import com.amazon.base.TestBase;
import com.amazon.pages.FashionPage;
import com.amazon.pages.Homepage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.TodaysDealPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegressionTests extends TestBase {

    Homepage homepage;
    LoginPage loginPage;
    TodaysDealPage todaysDealPage;
    FashionPage fashionPage;

    //Annotations -- Before/AfterClass, Before/AfterMethod, Before/AfterTest,
    @BeforeMethod
    public void setupObjects() {
        homepage = PageFactory.initElements(driver, Homepage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        todaysDealPage = PageFactory.initElements(driver, TodaysDealPage.class);
        fashionPage = PageFactory.initElements(driver, FashionPage.class);
    }

    @Test(enabled = false)
    public void userBeingAbleToGoToTodaysDealFromHomePage() {
        homepage.clickOnTodaysDeal();
    }

    @Test(enabled = false)
    public void userBeingAbleToSignInAmazonUsingValidCredentials() {
        homepage.clickOnSignInButton();
        loginPage.fillUpEmailAndPassword();
    }


    @Test
    public void userBeingAbleToseeDropDownAtFashionPagefromTodaysDeal() {
        homepage.clickOnTodaysDeal();
        todaysDealPage.clickOnFashion();
        fashionPage.validateFromDropDown();
        waitFor(5);
    }
}
