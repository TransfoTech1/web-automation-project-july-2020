package com.amazon.pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodaysDealPage extends TestBase {


    @FindBy(xpath = "//img[@src='https://m.media-amazon.com/images/G/01/goldbox/images/faceout/Fashion_white._CB468586683_.png']")
    private WebElement fashion;

    public void clickOnFashion() {
        fashion.click();
    }
}
