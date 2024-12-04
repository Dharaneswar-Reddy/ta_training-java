package com.epam.training.virupakshi_dharaneswar_reddy.pages;

import com.epam.training.virupakshi_dharaneswar_reddy.pojos.CalculatorInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CloudCostSummary {
    private WebDriver driver;

    public CloudCostSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public CalculatorInput fetchSummaryValues() {
        return new CalculatorInput(
                getFieldValue("Operating System / Software"),
                getFieldValue("Provisioning Model"),
                getFieldValue("Machine type"),
                getFieldValue("GPU Model"),
                getFieldValue("Number of GPUs"),
                getFieldValue("Local SSD"),
                getFieldValue("Region"),
                getFieldValue("Committed use discount options")
        );
    }

    private String getFieldValue(String field) {
        try {
            String xpath = "//span[text()='" + field + "']/following-sibling::span";
            WebElement element = driver.findElement(By.xpath(xpath));
            return element.getText().trim();
        } catch (Exception e) {
            return "Field Not Found";
        }
    }
}
