package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import services.Log;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

class Shared {
    private SelenideElement pageContainer() {
        return $(byId("wrap"));
    }

    String getH1() {
        return "h1";
    }

    String getH2() {
        return "h2";
    }

    String getButton() {
        return "button";
    }

    Boolean clickElementBySelector(String selector, SelenideElement parenElement) {
        Log.info("Clicking on element with selector: " + parenElement.getSearchCriteria() + " " + selector);
        SelenideElement element = parenElement.$(selector);
        return this.clickElement(element);
    }

    Boolean clickElementBySelector(String selector) {
        Log.info("Clicking on element with selector: " + selector);
        SelenideElement element = this.pageContainer().$(selector);
        return this.clickElement(element);
    }

    Boolean clickElement(SelenideElement element) {
        Log.info("Clicking on element with selector: " + element.getSearchCriteria());
        boolean isExist = element.exists();

        if (isExist) {
            element.scrollTo();
            element.click();
        }
        return isExist;
    }

    Boolean clickButtonWithText(String text) {
        Log.info("Clicking on button with text: " + text);
        SelenideElement element = pageContainer().$$(getButton()).findBy(Condition.exactText(text));
        return this.clickElement(element);
    }

    Boolean clickButtonContainingText(String text) {
        Log.info("Clicking on button containing text: " + text);
        SelenideElement element = pageContainer().$$(getButton()).findBy(Condition.text(text));
        return this.clickElement(element);
    }

}
