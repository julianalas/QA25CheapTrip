package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hide-xs.md.title-default.hydrated")
    WebElement slogan;

    @FindBy(css ="ion-buttons.select.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectLan;

    @FindBy(id = "ion-rb-1-lbl")
    WebElement russianLan;

    @FindBy(tagName = "ion-card-title")
    WebElement title;


    public boolean isSloganContainsText(String text) {
        return slogan.getText().contains(text);
    }

    public void selectRussianLanguage() {
        selectLan.click();
        waitUntilElementVisible(russianLan, 30);
        russianLan.click();
        waitUntilElementVisible(title, 30);
    }

    public boolean isLanguageOnPageRussian() {
        return title.getText().contains("Найдите самый дешевый способ добраться из города в город, сочетая самолет, поезд, автобус и совместные поездки на автомобиле");
    }
}
