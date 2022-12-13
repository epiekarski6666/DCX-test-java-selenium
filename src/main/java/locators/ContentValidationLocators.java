package locators;

import org.openqa.selenium.By;

public class ContentValidationLocators {
    public static final By
    cookieAcceptButton = By.id("hs-eu-confirmation-button"),
    megaMenuCapabilities = By.xpath(".//span[text()='Capabilities']"),
    megaSubmenuProductsAndPlatforms = By.xpath(".//a[text()='Products & Platforms']"),
    submenuTechnologyExpertise = By.xpath(".//a[text()='Technology Expertise']")
    ;
}
