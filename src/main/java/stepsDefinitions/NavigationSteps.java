package stepsDefinitions;

import io.cucumber.java.en.Given;
import pageObjects.Navigation;

public class NavigationSteps {
    private Navigation navigation = new Navigation();

    @Given("navigation to {string} page")
    public void navigationToPage(String page) {
        switch (page) {
            case "Mortgage loan":
                navigation.navigateToUrl("https://www.swedbank.lt/private/credit/loans/home?language=ENG");
                break;
            default:
                throw new IllegalArgumentException("No such page navigation is implemented yet: " + page);

        }
    }
}
