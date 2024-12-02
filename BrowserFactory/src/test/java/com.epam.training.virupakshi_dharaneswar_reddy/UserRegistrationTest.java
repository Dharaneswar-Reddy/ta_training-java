package com.epam.training.virupakshi_dharaneswar_reddy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver();
        driver.get("https://formy-project.herokuapp.com/form");

        User user = new User.UserBuilder()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setJobTitle("Software Engineer")
                .setEducationLevel("College")
                .setSexType("Male")
                .setYearsOfExperience("14")
                .setDate("5/31/2003")
                .build();

        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys(user.getFirstName());

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys(user.getLastName());

        WebElement jobTitleField = driver.findElement(By.id("job-title"));
        jobTitleField.sendKeys(user.getJobTitle());

        int educType = switch (user.getEducationLevel()){
            case "High School"-> 1;
            case "College" -> 2;
            case "Grad School" -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + user.getEducationLevel());
        };
        driver.findElement(By.id("radio-button-%d".formatted(educType))).click();

        int sexType = switch (user.getSexType()){
            case "Male"-> 1;
            case "Female" -> 2;
            case "Prefer not to say" -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + user.getEducationLevel());
        };
        driver.findElement(By.id("checkbox-%d".formatted(sexType))).click();

        String experienceRange = user.getYearsOfExperience();
        if (Integer.parseInt(experienceRange) >= 10) experienceRange = ">=10";


        int index = switch (experienceRange){
            case "0", "1" -> 1;
            case "2", "3", "4" -> 2;
            case "5", "6", "7", "8", "9" -> 3;
            case ">=10" -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + user.getYearsOfExperience());
        };
        WebElement experienceField = driver.findElement(By.id("select-menu"));
        Select select = new Select(experienceField);
        select.selectByIndex(index);

        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys(user.getDate());

        WebElement submitButton = driver.findElement(By.className("btn"));
        submitButton.click();

        BrowserFactory.quitDriver();
    }
}
