package com.amazon.data;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] getDataForSearch() {
        return new Object[][]{{"Java Books"}, {"Selenium Books"}, {"Maven Books"}};
    }

    @DataProvider
    public static Object[][] getDataForLogin() {
        return new Object[][]{{"testuser@gmail.com", "pass001"}, {"testuser@gmail.com", "pass002"}, {"testuser@gmail.com", "pass003"}};
    }
}
