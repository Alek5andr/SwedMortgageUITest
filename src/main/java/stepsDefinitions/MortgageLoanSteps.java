package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.MortgageLoan;
import services.ErrorThrower;

public class MortgageLoanSteps {
    private ErrorThrower errorThrower = new ErrorThrower();
    private MortgageLoan mortgageLoan = new MortgageLoan();

    @When("application for a loan {string} a co-applicant")
    public void applicationForALoanACoApplicant(String applicantPreposition) {
        switch (applicantPreposition) {
            case "with":
                break;
            case "without":
                break;
            default:
                errorThrower.throwIllegalArgumentError("No such preposition is implemented: " + applicantPreposition);
        }
    }

    @When("there {string} dependants in family")
    public void thereAreDependantsInFamily(String dependentsPresence) {
        Assert.assertTrue(mortgageLoan.selectDependantsCheckbox());
    }

    @Then("options to select dependents appear")
    public void optionsToSelectDependentsAppear() {
        Assert.assertTrue(mortgageLoan.isDependantsRowVisible());
    }

    @When("{int} dependent\\(s) is selected")
    public void dependentSIsSelected(Integer people) {
        switch (people) {
            case 1:
                break;
            case 2:
                Assert.assertTrue(mortgageLoan.select2Dependants());
                break;
            default:
                errorThrower.throwIllegalArgumentError("No such people amount is implemented: " + people);
        }
    }

    @When("total monthly income {int} is set")
    public void totalMonthlyIncomeIsSet(Integer income) {
        mortgageLoan.setValueToIncomeInput(income);
    }

    @When("there {string} existing loan obligations")
    public void thereAreNoExistingLoanObligations(String obligationsPresence) {
        switch (obligationsPresence) {
            case "are":
                break;
            case "are no":
                break;
            default:
                errorThrower.throwIllegalArgumentError("No such status of obligation\'s presence is implemented: " + obligationsPresence);
        }
    }

    @When("loan amount {int} is set")
    public void loanAmountIsSet(int loan) {
        mortgageLoan.setLoanAmountValue(loan);
    }

    @When("loan term {int} is set")
    public void loanTermIsSet(int months) {
        mortgageLoan.setLoanTerm(months);
    }

    @Then("monthly loan payment is {int}")
    public void monthlyLoanPaymentIs(int payment) {
        Assert.assertEquals(String.valueOf(payment), mortgageLoan.getMonthlyPaymentValue());
    }

    @Then("maximum loan amount is {int}")
    public void maximumLoanAmountIs(int maxLoanAmount) {
        Assert.assertEquals(String.valueOf(maxLoanAmount), mortgageLoan.getMaximumLoanAmountValue());
    }
}
