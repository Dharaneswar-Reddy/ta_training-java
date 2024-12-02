package com.epam.training.virupakshi_dharaneswar_reddy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
    private static volatile WebDriver driver;

    private BrowserFactory(){}

    public static WebDriver getDriver(){
        if(driver==null){
            synchronized (BrowserFactory.class){
                if(driver==null){
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                }
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
