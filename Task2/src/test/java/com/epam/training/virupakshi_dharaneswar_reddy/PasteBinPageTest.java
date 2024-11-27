package com.epam.training.virupakshi_dharaneswar_reddy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class PasteBinPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = WebDriverPattern.getDriver("chrome");
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCreateNewPaste() {
        PasteBinPage pasteBinPage = new PasteBinPage(driver);

        String code =  """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force
            """;
        String title = "how to gain dominance among developers";

        pasteBinPage.enterPasteCode(code);
        pasteBinPage.selectSyntaxHighlighting();
        pasteBinPage.selectPasteExpiration();
        pasteBinPage.enterPasteName(title);
        pasteBinPage.createNewPaste();
    }

    @AfterEach
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
