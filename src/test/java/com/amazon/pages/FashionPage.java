package com.amazon.pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class FashionPage extends TestBase {

    @FindBy(xpath = "//span[@data-action=\"a-dropdown-button\"]")
    private WebElement sortByDropDown;

    @FindBy(className = "a-dropdown-item")
    private List<WebElement> dropDownList;


    public void validateFromDropDown() {
        waitFor(2);
        sortByDropDown.click();
        System.out.println(dropDownList.size());

        //String tempData1 = driver.findElement(By.id("a-autoid-0-announce")).getText();
        String tempData = sortByDropDown.getText();
        System.out.println("sort by dropdown text : " + tempData);

        /*List<String> datam = new ArrayList<>();
        datam.add("Akash ");
        datam.add("Zann");
        System.out.println(datam.get(0));*/

        System.out.println(dropDownList.get(4).getText());
        System.out.println("*******from the loop");
        for (int i = 0; i < dropDownList.size(); i++) {
            System.out.println(dropDownList.get(i).getText());
        }

    }
}
