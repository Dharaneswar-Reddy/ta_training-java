package com.epam.training.virupakshi_dharaneswar_reddy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinPage {
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement textField;

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

    public void createNewPaste(String text, String title) throws InterruptedException {
        textField.sendKeys(text);
        expirationDropdown.click();
        expirationOption.click();
        pasteTitle.sendKeys(title);
        createNewPasteButton.click();
    }
}
