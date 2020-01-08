package testcases;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FashionPage;
import pages.Homepage;
import pages.LoginPage;
import pages.TodaysDealPage;

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
