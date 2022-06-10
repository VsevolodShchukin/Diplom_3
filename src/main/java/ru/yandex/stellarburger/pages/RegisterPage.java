package ru.yandex.stellarburger.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.disappear;


public class RegisterPage extends BasePage{

    public final static String url = "https://stellarburgers.nomoreparties.site/register";

    //Name input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Имя')]/following::input[1]")
    private SelenideElement nameInputField;

    //Email input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Email')]/following::input[1]")
    private SelenideElement emailInputField;

    //Password input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Пароль')]/following::input[1]")
    private SelenideElement passwordInputField;

    //Register button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //Login button
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Войти')]")
    private SelenideElement loginLink;

    @Step("Ввести значение {name}")
    public void setValueInNameInput(String name) {
        nameInputField.val(name);
    }

    @Step("Ввести значение {email}")
    public void setValueInEmailInput(String email) {
        emailInputField.val(email);
    }

    @Step("Ввести значение {password}")
    public void setValueInPasswordInput(String password) {
        passwordInputField.val(password);
    }

    @Step("Нажать на кнопку {registerButton}")
    public void clickOnRegisterButton() {
        registerButton.click();
    }

    @Step("Нажать на кнопку {loginLink}")
    public void clickOnLoginLink(){
        loginLink.click();
    }

    @Step("Зарегистрировать пользователь")
    public void registerNewUser(String name, String email, String password) {
        setValueInNameInput(name);
        setValueInEmailInput(email);
        setValueInPasswordInput(password);
        clickOnRegisterButton();
        registerButton.shouldBe(disappear);
    }

}
