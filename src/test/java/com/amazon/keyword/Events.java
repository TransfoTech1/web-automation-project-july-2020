package com.amazon.keyword;

import com.amazon.base.TestBase;
import com.amazon.pages.FashionPage;
import com.amazon.pages.Homepage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.TodaysDealPage;
import org.openqa.selenium.support.PageFactory;

public class Events extends TestBase {

    public void funcTionEvents(String enumValue) {
        Homepage homepage = PageFactory.initElements(driver, Homepage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        TodaysDealPage todaysDealPage = PageFactory.initElements(driver, TodaysDealPage.class);
        FashionPage fashionPage = PageFactory.initElements(driver, FashionPage.class);

        switch (functionNames.valueOf(enumValue)) {
            case login:
                homepage.clickOnSignInButton();
                loginPage.fillUpEmailAndPassword("TestUser@gmail.com", "TestPass");
                break;
            case logOut:
                //
                //
            case validateHomePage:
                homepage.validateMenuOptions();
                homepage.validatePrimeVideo();
                break;
            case validateLoginPage:
                //
                //
                //
                //
            case createUser:
                //
                //
        }

    }


    public enum functionNames {
        login, logOut, validateHomePage, validateLoginPage,
        validateAccountPage, createUser
    }


}
