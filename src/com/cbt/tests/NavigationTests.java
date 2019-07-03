package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        String [] browsers = {"chrome", "firefox", "safari"};

        for (String browser : browsers){

            WebDriver driver = BrowserFactory.getDriver(browser);
            driver.manage().window().maximize();
            driver.get("https://google.com");

            String title1 = driver.getTitle();
            driver.get("https://etsy.com");

            String title2 = driver.getTitle();

            driver.navigate().back();
            System.out.println(browser);
            StringUtility.verifyEquals(driver.getTitle(),title1);

            driver.navigate().forward();
            StringUtility.verifyEquals(driver.getTitle(),title2);

            driver.quit();

        }


    }
}
