package pages;

import org.openqa.selenium.By;
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

    @FindBy(tagName = "ion-badge")
    WebElement totalPrice;

    @FindBy(className = "mat-expansion-panel")
    List<WebElement> tripDataList;


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


    public boolean isTotalPriceEqualSumOfPrices() {
        double priceSum = 0.0;
        double totalPrice = 0.0;
        waitUntilAllElementsVisible(tripDataList, 30);
        System.out.println("Size: " + tripDataList.size());

//        создаем список элементов
        List<WebElement> tripDataList = driver.findElements(By.className("mat-expansion-panel"));
//         перебираем элементы по одному
        for (WebElement tripData: tripDataList){
//            в элементе ищем другой элемент
            WebElement totalPriceElement = tripData.findElement(By.tagName("ion-badge"));
            waitUntilElementVisible(totalPriceElement, 10);
            totalPrice = Double.parseDouble(totalPriceElement.getText().substring(1));
            System.out.println("Total price: " + totalPrice);

            WebElement openList = driver.findElement(By.cssSelector("[style=\"transform: rotate(0deg);\"]"));
            waitUntilElementVisible(openList, 10);
            openList.click();


            List <WebElement> priceListElement = tripData.findElements(By.cssSelector("span.currency"));
            int count = priceListElement.size();
            System.out.println("Count:" + count);

            for (WebElement priseElement : priceListElement){
                System.out.println("Price: " + priseElement.getAttribute("text"));
//                priceSum += Double.parseDouble(priseElement.getText().substring(1));
            }
            System.out.println("Price sum: " + priceSum);


        }

        return totalPrice == priceSum;
        
    }


}
