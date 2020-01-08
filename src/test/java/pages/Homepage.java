package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends TestBase {

    // page object model -- 1 class against 1 page, contains all the locators


    //driver.findElement(By.linkText("Today's Deals")
    @FindBy(linkText = "Today's Deals")
    private WebElement todaysDeal;

    @FindBy(id = "nav-link-accountList")
    private WebElement signInBtn;


    public void clickOnTodaysDeal() {
        //driver.findElement(By.linkText("Today's Deals")).click(); -- same as below line
        todaysDeal.click();
    }

    public void clickOnSignInButton() {
        signInBtn.click();
    }


}
