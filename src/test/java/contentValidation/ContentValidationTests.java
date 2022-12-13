package contentValidation;

import helperMethods.ContentValidationHelpers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Setup;
import static locators.ContentValidationLocators.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static stringVariables.ContentValidationVariables.*;

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
        wait.until(presenceOfElementLocated(cookieAcceptButton));
        contentValidationHelpers.clickElement(cookieAcceptButton);
    }
    @AfterEach
    public void closeAndQuit(){
        driver.quit();
    }
    @Test
    public void listOfCapabilities(){
        //On the header locate the capabilities dropdown
        wait.until(presenceOfElementLocated(megaMenuCapabilities));
        assertTrue(driver.findElement(megaMenuCapabilities).isDisplayed());
        contentValidationHelpers.hover(megaMenuCapabilities);
        //Ensure that the capabilities dropdown list contains [Products & Platforms, Technology Expertise]
        wait.until(presenceOfElementLocated(megaSubmenuProductsAndPlatforms));
        assertTrue(driver.findElement(megaSubmenuProductsAndPlatforms).isDisplayed());
        wait.until(presenceOfElementLocated(submenuTechnologyExpertise));
        assertTrue(driver.findElement(submenuTechnologyExpertise).isDisplayed());
        //Select Technology Expertise and ensure that the page contains a list of technologies
        contentValidationHelpers.clickElement(submenuTechnologyExpertise);
        wait.until(presenceOfElementLocated(salesforceBlock));
        assertTrue(driver.findElement(salesforceBlock).isDisplayed());
        wait.until(presenceOfElementLocated(acquiaBlock));
        assertTrue(driver.findElement(acquiaBlock).isDisplayed());
        wait.until(presenceOfElementLocated(acousticBlock));
        assertTrue(driver.findElement(acousticBlock).isDisplayed());
        wait.until(presenceOfElementLocated(adobeBlock));
        assertTrue(driver.findElement(adobeBlock).isDisplayed());
        wait.until(presenceOfElementLocated(bynderBlock));
        assertTrue(driver.findElement(bynderBlock).isDisplayed());
        wait.until(presenceOfElementLocated(sitecoreBlock));
        assertTrue(driver.findElement(sitecoreBlock).isDisplayed());
        //Each of the technology blocks should contain: Name, Image, Description]
        contentValidationHelpers.technologyBlocksContain(salesforceHeading, salesforceImage, salesforceDescription);
        contentValidationHelpers.technologyBlocksContain(acquiaHeading, acquiaImage, acquiaDescription);
        contentValidationHelpers.technologyBlocksContain(acousticHeading, acousticImage, acousticDescription);
        contentValidationHelpers.technologyBlocksContain(adobeHeading, adobeImage, adobeDescription);
        contentValidationHelpers.technologyBlocksContain(bynderHeading, bynderImage, bynderDescription);
        contentValidationHelpers.technologyBlocksContain(sitecoreHeading, sitecoreImage, sitecoreDescription);
    }

}
