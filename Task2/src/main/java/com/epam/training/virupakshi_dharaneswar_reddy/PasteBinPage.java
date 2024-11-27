package com.epam.training.virupakshi_dharaneswar_reddy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinPage {
    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(id = "postform-text")
    private WebElement textField;

    @FindBy(id = "select2-postform-format-container")
    private WebElement highlighDropdown;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashOption;

    @FindBy(id = "select2-postform-expiration-container")
    public WebElement expirationDropdown;

    @FindBy(id = "postform-name")
    private WebElement pasteTitle;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement expirationOption;

    public PasteBinPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPasteCode(String code) {
        textField.sendKeys(code);
    }

    public void selectSyntaxHighlighting() {
        highlighDropdown.click();
        bashOption.click();
    }

    public void selectPasteExpiration() {
        wait.until(ExpectedConditions.visibilityOf(expirationDropdown));
        expirationDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(expirationOption));
        expirationOption.click();
    }

    public void enterPasteName(String pasteName) {
        pasteTitle.sendKeys(pasteName);
    }

    public void createNewPaste() {
        createNewPasteButton.click();
    }
}
