package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Setup {
    public static WebDriver driver;
    public String BASIC_URL = "https://paragon-dcx.com";

    public void setup(String browserType) throws Exception{
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/edwinpiekarski/IdeaProjects/DCX-test-java-selenium-windows/src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else{
            throw new Exception("This browser is not valid for this test");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
