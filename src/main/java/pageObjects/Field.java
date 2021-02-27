package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import services.Log;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$$;

class Field {
    private SelenideElement getFieldLabelElementByText(String text) {
        return $$(byCssSelector("div[class='ui-field__label']")).find(Condition.exactText(text));
    }

    private SelenideElement getFieldLabelElementsParentByText(String text) {
        return this.getFieldLabelElementByText(text).parent();
    }

    SelenideElement getInputFieldElementByItsParentElementsText(String text) {
        return this.getFieldLabelElementsParentByText(text).$(byCssSelector("input[class='ui-slider__input']"));
    }

    void setValueToElement(SelenideElement element, String value) {
        Log.info("Setting value: " + value + " - to element: " + element.getSearchCriteria());

        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(value);
        element.pressTab();
    }
}
