package pageObjects;

import org.junit.Assert;

import static com.codeborne.selenide.Selenide.open;

public class Navigation extends Shared {
    private Modal modal = new Modal();
    private ConsentCookie consentCookie = new ConsentCookie();

    public void navigateToUrl(String url) {
        open(url);

        if (modal.isModalVisibleByHeader("We use cookies")) {
            Assert.assertTrue(consentCookie.acceptAllConsentCookies());
            Assert.assertTrue(modal.isModalVisible());
        }
    }
}
