package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageTests extends TestBase {
    MainPage mainPage;

    @BeforeMethod
    public void initTest(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test(priority = 2, groups = {"UI"})
    public void sloganValidationTest(){
        String text = "CheapTrip. Pay less, travel more";
        assert mainPage.isSloganContainsText(text);

    }

    @Test(priority = 1, groups = {"functional"})
    public void changeLanguageValidationTest(){
        mainPage.selectRussianLanguage();
        assert mainPage.isLanguageOnPageRussian();

    }


}
