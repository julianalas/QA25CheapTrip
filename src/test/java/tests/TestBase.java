package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver driver;

    @BeforeMethod(alwaysRun=true)
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver(options);
        driver.get("http://test70.lowcoststrip.com/");
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        driver.quit();
    }
}
