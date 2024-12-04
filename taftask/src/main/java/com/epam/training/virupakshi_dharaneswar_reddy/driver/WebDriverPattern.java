package com.epam.training.virupakshi_dharaneswar_reddy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverPattern {
    private static volatile WebDriver driver;

    private WebDriverPattern() {}

    private static WebDriver getBrowser(String browser){
        return switch (browser.toLowerCase()){
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("Browser is not supported");
        };
    }
    public static WebDriver getDriver(String browser){
        if(driver == null){
            synchronized (WebDriverPattern.class){
                if(driver == null){
                    driver = getBrowser(browser);
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
