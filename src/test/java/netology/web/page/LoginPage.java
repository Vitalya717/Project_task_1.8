package netology.web.page;

import com.codeborne.selenide.SelenideElement;
import netology.web.data.DataHelper;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id='login'] input");
    private final SelenideElement passwordField = $("[data-test-id='password'] input");
    private final SelenideElement buttonField = $("[data-test-id='action-login']");
    private SelenideElement errorVerification = $("[data-test-id='error-notification'] .notification__content");


    public void verifyErrorNotification(String expectedText) {
        errorVerification.shouldHave(exactText(expectedText)).shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        buttonField.click();
        return new VerificationPage();
    }

    public LoginPage notValidLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        buttonField.click();
        return new LoginPage();
    }

}