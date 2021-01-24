package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageForDataProvider extends PageBase {
    public MainPageForDataProvider(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name=\"ion-input-0\"]")
    WebElement fromField;

    @FindBy(css = "[name=\"ion-input-1\"]")
    WebElement toField;

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-0-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityFrom;

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-1-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityTo;

    @FindBy(css = "ion-button.ion-color-primary")
    WebElement letsGoButton;

    @FindBy(css = ".city")
    List<WebElement> resultList;



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

    public boolean isResultDisplayed() {
        return resultList.size()> 0;
    }
}
