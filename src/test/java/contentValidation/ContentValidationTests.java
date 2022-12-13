package contentValidation;

import helperMethods.ContentValidationHelpers;
import locators.ContentValidationLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Setup;
import stringVariables.ContentValidationVariables;

public class ContentValidationTests extends Setup {
    ContentValidationHelpers contentValidationHelpers = new ContentValidationHelpers();
    WebDriverWait wait;
    @BeforeEach
    public void driverSetup() throws Exception{
        Setup setupBrowser = new Setup();
        setupBrowser.setup("chrome");
        //open main page
        driver.get(BASIC_URL);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.cookieAcceptButton));
        contentValidationHelpers.clickElement(ContentValidationLocators.cookieAcceptButton);
    }
    @AfterEach
    public void closeAndQuit(){
        driver.quit();
    }
    @Test
    public void listOfCapabilities(){
        //On the header locate the capabilities dropdown
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.megaMenuCapabilities));
        contentValidationHelpers.hover(ContentValidationLocators.megaMenuCapabilities);
        //Ensure that the capabilities dropdown list contains [Products & Platforms, Technology Expertise]
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.megaSubmenuProductsAndPlatforms));
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.submenuTechnologyExpertise));
        //Select Technology Expertise and ensure that the page contains a list of technologies
        contentValidationHelpers.clickElement(ContentValidationLocators.submenuTechnologyExpertise);
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.salesforceBlock));
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.acquiaBlock));
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.acousticBlock));
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.adobeBlock));
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.bynderBlock));
        wait.until(ExpectedConditions.presenceOfElementLocated(ContentValidationLocators.sitecoreBlock));
        //Each of the technology blocks should contain: Name, Image, Description]
        contentValidationHelpers.technologyBlocksContain(ContentValidationVariables.salesforceHeading, ContentValidationVariables.salesforceImage, ContentValidationVariables.salesforceDescription);
        contentValidationHelpers.technologyBlocksContain(ContentValidationVariables.acquiaHeading, ContentValidationVariables.acquiaImage, ContentValidationVariables.acquiaDescription);
        contentValidationHelpers.technologyBlocksContain(ContentValidationVariables.acousticHeading, ContentValidationVariables.acousticImage, ContentValidationVariables.acousticDescription);
        contentValidationHelpers.technologyBlocksContain(ContentValidationVariables.adobeHeading, ContentValidationVariables.adobeImage, ContentValidationVariables.adobeDescription);
        contentValidationHelpers.technologyBlocksContain(ContentValidationVariables.bynderHeading, ContentValidationVariables.bynderImage, ContentValidationVariables.bynderDescription);
        contentValidationHelpers.technologyBlocksContain(ContentValidationVariables.sitecoreHeading, ContentValidationVariables.sitecoreImage, ContentValidationVariables.sitecoreDescription);
    }

}
