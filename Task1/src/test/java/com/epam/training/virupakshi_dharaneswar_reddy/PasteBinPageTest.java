package com.epam.training.virupakshi_dharaneswar_reddy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class PasteBinPageTest {
    private WebDriver driver;
    private PasteBinPage pasteBinPage;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser){
        driver = WebDriverPattern.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
        pasteBinPage = new PasteBinPage(driver);
    }

    @Test
    public void testPasteBinPage() throws InterruptedException {
        pasteBinPage.createNewPaste("Hello from WebDriver", "helloweb");

    }

    @AfterClass
    public void tearDown(){
        WebDriverPattern.quitDriver();
    }

}
