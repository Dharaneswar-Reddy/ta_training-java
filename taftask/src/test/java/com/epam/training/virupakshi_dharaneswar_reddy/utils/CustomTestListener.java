package com.epam.training.virupakshi_dharaneswar_reddy.utils;

import com.epam.training.virupakshi_dharaneswar_reddy.CloudCalculatorTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomTestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(CustomTestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        if (testClass instanceof CloudCalculatorTest) {
            WebDriver driver = ((CloudCalculatorTest) testClass).getDriver();

            if (driver != null) {
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File("screenshots/" + result.getName() + "_" + timestamp + ".png"));
                    logger.info("Screenshot captured for failed test: {}", result.getName());
                } catch (Exception e) {
                    logger.error("Failed to capture screenshot for test {}: {}", result.getName(), e.getMessage());
                }
            } else {
                logger.warn("Driver is null. Screenshot capture skipped for test: {}", result.getName());
            }
        } else {
            logger.warn("Test class is not an instance of CloudCalculatorTest. Cannot capture screenshot.");
        }
    }
}