package helperMethods;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.Setup;

import java.util.List;

public class ContentValidationHelpers extends Setup {
    public void clickElement(By locator){
        driver.findElement(locator).click();
    }
    public void hover(By locator){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).perform();
    }
    public void technologyBlocksContain (String title, String image, String description){
        List<WebElement> listOfHeadings = driver.findElements(By.className("card-heading"));
        WebElement headings = null;
        for (WebElement heading: listOfHeadings) {
            String firstElement = heading.getText();
            if(firstElement.equals(title)){
                headings = heading;
            }
        }
        Assertions.assertNotNull(headings, "One of technology block does not contain heading");

        List<WebElement> listOfImages = driver.findElements(By.cssSelector("img"));
        WebElement imgs = null;
        for (WebElement img: listOfImages) {
            String secondElement = img.getAttribute("alt");
            if(secondElement.equals(image)){
                imgs = img;
            }
        }
        Assertions.assertNotNull(imgs, "One of technology block does not contain image");

        List<WebElement> listOfDescriptions = driver.findElements(By.className("card-description"));
        WebElement descs = null;
        for (WebElement desc: listOfDescriptions) {
            String thirdElement = desc.getText();
            if(thirdElement.equals(description)){
                descs = desc;
            }
        }
        Assertions.assertNotNull(descs, "One of technology block does not contain description");
    }
}
