package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {

        if (browser.equals("edge")) {
            return null;

        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/gdundar/Documents/PersonalPrograms/Selenium Dependencies/drivers/chromedriver");
            return new ChromeDriver();

        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "/Users/gdundar/Documents/PersonalPrograms/Selenium Dependencies/drivers/geckodriver");
            return new FirefoxDriver();

        } else if (browser.equals("safari")) {
            System.setProperty("webdriver.safari.driver", "/System/Library/CoreServices/SafariSupport.bundle/Contents/MacOS/safaridriver");
            return new SafariDriver();
        }
        return null;
    }
}
///System/Library/CoreServices/SafariSupport.bundle/Contents/MacOS/safaridriver

// /usr/bin/safaridriver