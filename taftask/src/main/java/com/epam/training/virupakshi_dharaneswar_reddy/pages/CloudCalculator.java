package com.epam.training.virupakshi_dharaneswar_reddy.pages;

import com.epam.training.virupakshi_dharaneswar_reddy.pojos.CalculatorInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class CloudCalculator {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//span[text()='Add to estimate'])[1]")
    private WebElement addToEstimate;

    @FindBy(xpath = "//div[@data-service-form='8']")
    private WebElement computeEngine;

    @FindBy(xpath = "//div[text()='Number of instances']")
    private WebElement numberOfInstancesTitle;

    @FindBy(xpath = "(//input[@jsname='YPqjbf'])[1]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "(//div[@class='VfPpkd-TkwUic'])[4]")
    private WebElement OperatingSystemField;

    @FindBy(xpath = "//li[@data-708c49e2-dcf0-4d62-b457-88577bfe3081='Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)']")
    private WebElement OperatingSystemType;

    @FindBy(xpath = "(//div[@class='c0GfYc']//descendant::div)[2]")
    private WebElement provisioningModel;

    @FindBy(xpath = "//div[@jsname='Wsw6tc']")
    private WebElement machineFamily;

    @FindBy(xpath = "//li[@data-value='general-purpose']")
    private WebElement machineFamilyType;

    @FindBy(xpath = "//div[@jsname='vGGDlb']")
    private WebElement series;

    @FindBy(xpath = "//li[@data-value='n1']")
    private WebElement seriesType;

    @FindBy(xpath = "//div[@jsname='kgDJk']")
    private WebElement machineType;

    @FindBy(xpath = "//li[@data-value='n1-standard-8']")
    private WebElement machineTypeValue;

    @FindBy(xpath = "(//div[@class='qUa9tb']//button[@jsname='DMn7nd'])[5]")
    private WebElement addGpuButton;

    @FindBy(xpath = "(//div[@jsname='wSASue'])[8]")
    private WebElement gpuModel;

    @FindBy(xpath = "//li[@data-value='nvidia-tesla-p100']")
    private WebElement gpuModelType;

    @FindBy(xpath = "(//div[@jsname='wSASue'])[9]")
    private WebElement numberOfGpus;

    @FindBy(xpath = "(//li[@data-value='1'])[1]")
    private WebElement getNumberOfGpus;


    @FindBy(xpath = "(//div[@jsname='wSASue'])[10]")
    private WebElement localSsd;

    @FindBy(xpath = "(//li[@data-value='2'])[2]")
    private WebElement localSsdValue;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[11]")
    private WebElement region;

    @FindBy(xpath = "//li[@data-value='europe-west4']")
    private WebElement regionType;

    @FindBy(xpath = "//label[text()='1 year']")
    private WebElement discountOptions;

    @FindBy(xpath = "//span[text()='Share']")
    private WebElement shareButton;

    @FindBy(xpath = "//a[@track-name='open estimate summary']")
    private WebElement estimateSummary;


    public CloudCalculator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectOperatingSystem(){
        OperatingSystemField.click();
        OperatingSystemType.click();
    }

    public void selectMachineFamily(){
        machineFamily.click();
        machineFamilyType.click();
    }

    public void selectSeries(){
        series.click();
        seriesType.click();
    }

    public void selectMachineType(){
        machineType.click();
        machineTypeValue.click();
    }

    public void selectGpuModel() {
        wait.until(ExpectedConditions.elementToBeClickable(gpuModel));
        gpuModel.click();

        wait.until(ExpectedConditions.elementToBeClickable(gpuModelType));
        gpuModelType.click();
    }

    public void selectNumberOfGpus(){
        numberOfGpus.click();
        getNumberOfGpus.click();
    }

    public void selectLocalSsd(){
        localSsd.click();
        localSsdValue.click();
    }

    public void selectRegion() {
        region.click();

        wait.until(ExpectedConditions.elementToBeClickable(regionType));
        regionType.click();
    }

    public void switchToNewWindow(){
        String mainWindow = driver.getWindowHandle();
        Set<String> urls = driver.getWindowHandles();
        for(String url:urls){
            if(!url.equals(mainWindow)){
                driver.switchTo().window(url);
                break;
            }
        }
    }

    public void calculateCloudCost(CalculatorInput input) throws InterruptedException {
        addToEstimate.click();
        wait.until(ExpectedConditions.visibilityOf(computeEngine));
        computeEngine.click();
        wait.until(ExpectedConditions.visibilityOf(numberOfInstancesTitle));
        numberOfInstances.clear();
        numberOfInstances.sendKeys("4");
        selectOperatingSystem();
        provisioningModel.click();
        selectMachineFamily();
        selectSeries();
        selectMachineType();
        addGpuButton.click();
        Thread.sleep(1000);
        selectGpuModel();
        selectNumberOfGpus();
        selectLocalSsd();
        selectRegion();
        discountOptions.click();
        Thread.sleep(2000);
        shareButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(estimateSummary));
        estimateSummary.click();
        switchToNewWindow();
    }
}
