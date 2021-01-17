package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;

public class SearchTests extends TestBase {
    MainPage mainPage;
    String cityFrom = "Kiev";
    String cityTo = "Moscow";

    @BeforeMethod
    public void initTest(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test()
    public void searchResultIsPresent() {
        mainPage.inputCityInFromField(cityFrom);
        mainPage.inputCityInToField(cityTo);
        mainPage.clickOnLetsGoButton();

        Assert.assertTrue(mainPage.searchResultIsDisplayed(),
                "Search result for cities:" + cityFrom + ", " +cityTo + " is not displayed!");

    }

}
