package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MainPageForDataProvider;
import util.DataProviders;

public class DataProviderTest extends TestBase{
    MainPageForDataProvider mainPageDP;
//    String cityFrom = "Moscow";
//    String cityTo = "Kiev";

    @BeforeMethod
    public void initTest(){
        mainPageDP = PageFactory.initElements(driver, MainPageForDataProvider.class);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usingCSVFile")
    public void searchResultIsDisplayedTest(String cityFrom, String cityTo){
        mainPageDP.inputCityInFromField(cityFrom);
        mainPageDP.inputCityInToField(cityTo);
        mainPageDP.clickOnLetsGoButton();
        Assert.assertTrue(mainPageDP.isResultDisplayed(),
                "Result is not displayed for cities: " + cityFrom + " and " + cityTo);
    }
}

