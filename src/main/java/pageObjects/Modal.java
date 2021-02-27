package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageObjects.Shared;
import services.Log;

import static com.codeborne.selenide.Selenide.$$;

class Modal extends Shared {
    private ElementsCollection getModalContainerElements() {
        return $$("div[class='ui-modal__window']");
    }

    private SelenideElement getModalHeader () {
        SelenideElement visibleModal = this.getModalContainerElements().find(Condition.visible);

        return visibleModal.$(super.getH1()).exists() ?
                visibleModal.$(super.getH1()) :
                visibleModal.$(super.getH2());
    }

    Boolean isModalVisible() {
        boolean isVisible = getModalContainerElements().find(Condition.visible).exists();
        Log.info("Is modal window visible? - " + isVisible);
        return isVisible;
    }


    Boolean isModalVisibleByHeader(String headerText) {
        boolean isVisible = this.getModalHeader().getText().equals(headerText);
        Log.info("Is modal window visible with its header text: " + headerText + "? - " + isVisible);
        return isVisible;
    }
}
