package com.epam.training.virupakshi_dharaneswar_reddy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class CloudCostSummary {
    private WebDriver driver;

    public CloudCostSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Map<String, String> fetchSummaryValues() {
        Map<String, String> summaryValues = new HashMap<>();

        String[] fields = {
                "Operating System / Software",
                "Provisioning Model",
                "Machine type",
                "GPU type",
                "Number of GPUs",
                "Local SSD",
                "Region",
                "Committed use discount options"
        };

        for (String field : fields) {
            try {
                String xpath = "//span[text()='" + field + "']/following-sibling::span";
                WebElement element = driver.findElement(By.xpath(xpath));
                summaryValues.put(field, element.getText().trim());
            } catch (Exception e) {
                summaryValues.put(field, "Field Not Found");
            }
        }

        return summaryValues;
    }

}
