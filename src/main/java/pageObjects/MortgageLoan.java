package pageObjects;

import com.codeborne.selenide.SelenideElement;
import services.Log;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MortgageLoan extends Shared {
    private Field field = new Field();

    private SelenideElement getDependantsCheckBoxElement() {
        return $(byCssSelector("label[for='dependantsCheck']"));
    }

    private SelenideElement getDependantsRowElement() {
        return $(byClassName("dependantsRow"));
    }

    private SelenideElement getDependants2RadioButtonElement() {
        return $(byCssSelector("label[for='dependants2']"));
    }

    private SelenideElement getIncomeInputElement() {
        return $(byId("income"));
    }

    private SelenideElement getLoanAmountInputFieldElement() {
        return field.getInputFieldElementByItsParentElementsText("Choose loan amount");
    }

    private SelenideElement getLoanTermInputFieldElement() {
        return field.getInputFieldElementByItsParentElementsText("Choose loan term");
    }

    private SelenideElement getMonthlyPaymentElement() {
        return $(byId("month-payment"));
    }

    private SelenideElement getMaxLoanAmountElement() {
        return $(byId("slider-financed"));
    }

    public Boolean selectDependantsCheckbox() {
        Log.info("Selecting checkbox: More than one dependant in family");
        return super.clickElement(this.getDependantsCheckBoxElement());
    }

    public Boolean isDependantsRowVisible() {
        boolean isVisible = this.getDependantsRowElement().isDisplayed();

        Log.info("Is dependants row visible? - " + isVisible);
        return isVisible;
    }

    public Boolean select2Dependants() {
        Log.info("Selecting '2 or more' dependants");
        return super.clickElement(this.getDependants2RadioButtonElement());
    }

    public void setValueToIncomeInput(int value) {
        String incomeValue = String.valueOf(value);

        Log.info("Setting value to 'Total monthly income' field: " + incomeValue);
        field.setValueToElement(this.getIncomeInputElement(), incomeValue);
    }

    public void setLoanAmountValue(int value) {
        String loanAmountValue = String.valueOf(value);

        Log.info("Setting 'loan amount' value: " + loanAmountValue);
        field.setValueToElement(this.getLoanAmountInputFieldElement(), loanAmountValue);
    }

    public void setLoanTerm(int value) {
        String loanTermValue = String.valueOf(value);

        Log.info("Setting 'loan term' value: " + loanTermValue);
        field.setValueToElement(this.getLoanTermInputFieldElement(), loanTermValue);
    }

    public String getMonthlyPaymentValue() {
        String monthlyPaymentValue = this.getMonthlyPaymentElement().getOwnText();

        Log.info("Reading 'Monthly loan payment' value: " + monthlyPaymentValue);
        return monthlyPaymentValue;
    }

    public String getMaximumLoanAmountValue() {
        String maximumLoanAmountValue = this.getMaxLoanAmountElement().getOwnText();

        Log.info("Reading 'Maximum loan amount' value: " + maximumLoanAmountValue);
        return maximumLoanAmountValue;
    }
}
