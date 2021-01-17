package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".hide-xs.md.title-default.hydrated")
    WebElement slogan;

    @FindBy (css ="ion-buttons.select.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectLang;

    @FindBy (id = "ion-rb-1-lbl")
    WebElement russianLang;

    @FindBy (css = "ion-item.select-interface-option")
    List<WebElement> langList;

    @FindBy (tagName = "ion-card-title")
    WebElement title;

    @FindBy (className = "pointInpt")
    List<WebElement> inputFieldList;

    @FindBy(css = "ion-button.ion-color-primary")
    WebElement letsGoButton;

    @FindBy(name = "ion-input-0")
    WebElement fromField;

    @FindBy(name = "ion-input-1")
    WebElement toField;

    @FindBy (xpath = "//ion-item//ion-label[@id='ion-input-0-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityFrom;
    
    @FindBy(xpath =  "//ion-item//ion-label[@id='ion-input-1-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityTo;

    @FindBy(css = ".city")
    List<WebElement> resultsList;


    public boolean isSloganContainsText(String text) {
        return slogan.getText().contains(text);
    }

    public void selectRussianLanguage() {
        selectLang.click();
        waitUntilElementVisible(russianLang, 30);
        langList.get(1).click();
    }

    public boolean isLanguageOnPageRussian() {
        return title.getText().contains("Найдите самый дешевый способ добраться из города в город, сочетая самолет, поезд, автобус и совместные поездки на автомобиле");
    }

    public void inputCityInFromField(String cityFrom) {
        inputTextToField(fromField, cityFrom);
        waitUntilElementVisible(submitCityFrom, 10);
        submitCityFrom.click();
    }

    public void inputCityInToField(String cityTo) {
        inputTextToField(toField, cityTo);
        waitUntilElementVisible(submitCityTo, 10);
        submitCityTo.click();
    }

    public void clickOnLetsGoButton() {
        letsGoButton.click();
    }

    public boolean searchResultIsDisplayed() {
        return resultsList.size()>0;


    }

//    public void inputCityInFromField(String cityFrom) throws InterruptedException {
//        inputTextToField(fromField, cityFrom);
//        Thread.sleep(3000);
//    }
//
//    public void inputCityInToField(String cityTo) throws InterruptedException {
//        inputTextToField(toField, cityTo);
//        Thread.sleep(3000);
//    }
//
//    public void clickOnLetsGoButton() throws InterruptedException {
//        letsGoButton.click();
//        Thread.sleep(3000);
//    }
}
