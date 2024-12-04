package com.epam.training.virupakshi_dharaneswar_reddy;

import com.epam.training.virupakshi_dharaneswar_reddy.config.ConfigReader;
import com.epam.training.virupakshi_dharaneswar_reddy.driver.WebDriverPattern;
import com.epam.training.virupakshi_dharaneswar_reddy.pages.CloudCalculator;
import com.epam.training.virupakshi_dharaneswar_reddy.pages.CloudCostSummary;
import com.epam.training.virupakshi_dharaneswar_reddy.pojos.CalculatorInput;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class CloudCalculatorTest {
    private WebDriver driver;
    private CloudCalculator cloudCalculator;
    private CloudCostSummary cloudCostSummary;
    private static Logger logger = LoggerFactory.getLogger(CloudCalculatorTest.class);

    public WebDriver getDriver(){
       return driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Initializing WebDriver for browser: {}", browser);
        driver = WebDriverPattern.getDriver(browser);
        logger.info("WebDriver initialized for browser: {}", browser);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));
        cloudCalculator = new CloudCalculator(driver);
        cloudCostSummary = new CloudCostSummary(driver);
    }

    @Test
    public void validateCloudCalculatorInputValues() throws InterruptedException {
        logger.info("Starting test: validateCloudCalculatorInputValues");
        CalculatorInput input = new CalculatorInput(
                "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)",
                "Regular",
                "n1-standard-8, vCPUs: 8, RAM: 30 GB",
                "NVIDIA TESLA P100",
                "1",
                "2x375 GB",
                "Netherlands (europe-west4)",
                "1 year"
        );
        logger.info("Input Values: {}", input);

        cloudCalculator.calculateCloudCost(input);
        logger.info("Cloud cost calculation completed.");

        CalculatorInput summary = cloudCostSummary.fetchSummaryValues();
        logger.info("Fetched Cloud Cost Summary: {}", summary);

        try {
            assertEquals(summary, input, "Mismatch between input and summary values!");
            logger.info("Test passed: Input and summary values match.");
        } catch (AssertionError e) {
            logger.error("Test failed: {}", e.getMessage());
            throw e;
        }

    }

    @AfterClass
    public void tearDown() {
        logger.info("Tearing down after test execution.");
        WebDriverPattern.quitDriver();
        logger.info("Web driver quit successfully.");
    }
}

