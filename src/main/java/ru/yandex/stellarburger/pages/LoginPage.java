package ru.yandex.stellarburger.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.disappear;

public class LoginPage extends BasePage {

    public final static String url = "https://stellarburgers.nomoreparties.site/login";

    //Email input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Email')]/following::input[1]")
    private SelenideElement emailInputField;

    //Password input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Пароль')]/following::input[1]")
    private SelenideElement passwordInputField;

    //Login button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти')]")
    private SelenideElement loginButton;

    @Step("Ввести значение {email}")
    public void setValueInEmailInput(String email) {
        emailInputField.val(email);
    }

    @Step("Ввести значение {password}")
    public void setValueInPasswordInput(String password) {
        passwordInputField.val(password);
    }

    @Step("Нажать на кнопку {loginButton}")
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Step("Войти под пользователем")
    public void logIn(String email, String password) {
        setValueInEmailInput(email);
        setValueInPasswordInput(password);
        clickOnLoginButton();
        loginButton.shouldBe(disappear);
    }


}
