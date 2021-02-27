package pageObjects;

class ConsentCookie extends Shared {
    Boolean acceptAllConsentCookies() {
        return super.clickButtonWithText("Consent to all cookies");
    }
}
