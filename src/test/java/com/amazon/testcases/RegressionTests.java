package com.amazon.testcases;

import com.amazon.base.TestBase;
import com.amazon.data.DataProviders;
import com.amazon.keyword.Events;
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
    public void userBeingAbleToseeDropDownAtFashionPagefromTodaysDeal() {
        homepage.clickOnTodaysDeal();
        todaysDealPage.clickOnFashion();
        fashionPage.validateFromDropDown();
        waitFor(5);
    }

    @Test(enabled = false)
    public void userBeingAbleToSeeThePrimeVideoUnderMenuButton() {
        homepage.clickOnMenuButton();
        homepage.validatePrimeVideo();
        waitFor(5);
    }


    @Test(enabled = false)
    public void userBeingAbleToSeeAllMenuButton() {
        homepage.clickOnMenuButton();
        homepage.validateMenuOptions();
        waitFor(5);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "getDataForSearch", enabled = false)
    public void userBeingAbleToSearchForDifferentItems(String data) {
        homepage.fillSearchTypeBox(data);
        waitFor(5);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "getDataForLogin", enabled = false)
    public void userBeingAbleToSignInAmazonUsingValidCredentials(String username, String password) {
        homepage.clickOnSignInButton();
        waitFor(5);
        loginPage.fillUpEmailAndPassword(username, password);
    }

    @Test
    public void keywordDrivenExamplesLogin() {
        Events events = new Events();
        events.funcTionEvents("login");
        waitFor(5);
    }

    @Test(enabled = false)
    public void keywordDrivenExamplesLogout() {
        Events events = new Events();
        events.funcTionEvents("login");
        events.funcTionEvents("validateUserLoggedIn");
        events.funcTionEvents("logout");
        events.funcTionEvents("validateUserLoggedOut");
        waitFor(5);
    }


}
