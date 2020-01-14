package seleniumPractices;

import org.openqa.selenium.WebElement;

public class Quiz {

    //create a method which takes a WebElement and returns the text of the webElement

    public String method1(WebElement element) {
        return element.getText();
    }

    // create a method which takes a webElement and a string and
    // returns true or false
    // based on the text of the webElement matches to the expected text on params

    public boolean method2(WebElement element, String expectedText) {
        if (element.getText().equalsIgnoreCase(expectedText)) {
            return true;
        } else
            return false;
    }


}
