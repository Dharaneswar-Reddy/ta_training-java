package com.epam.training.virupakshi_dharaneswar_reddy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CloudCalculatorTest {
    private WebDriver driver;
    private CloudCalculator cloudCalculator;
    private CloudCostSummary cloudCostSummary;

    @BeforeEach
    public void setup(){
        driver = WebDriverPattern.getDriver("chrome");
        driver.get("https://cloud.google.com/products/calculator");
        driver.manage().window().maximize();
        cloudCalculator = new CloudCalculator(driver);
        cloudCostSummary = new CloudCostSummary(driver);
    }

    @Test
    public void testCloudCalculator() throws InterruptedException {
        cloudCalculator.calculateCloudCost();

        Map<String, String> map = cloudCalculator.getInputValues();
        Map<String, String> showSummary = cloudCostSummary.fetchSummaryValues();
        for(Map.Entry<String, String> value: map.entrySet()){
            if(!showSummary.containsValue(value.getValue())){
                assertFalse(false);
            }
        }
        assertTrue(true);



    }

    @AfterEach
    public void tearDown(){
        WebDriverPattern.quitDriver();
    }
}
