package com.amazon.pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TestBase {

    @FindBy(id = "ap_email")
    private WebElement emailField;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    public void fillUpEmailAndPassword(String user, String pass) {
        // driver.findElement(By.id("whatever")).sendKeys("something@gmail.com");
        emailField.sendKeys(user);
        continueBtn.click();
        passwordField.sendKeys(pass);
    }


}
