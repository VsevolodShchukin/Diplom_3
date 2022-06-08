package ru.yandex.stellarburger.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.stellarburger.models.UserModel;

public class RegisterPage {

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

    public void setValueInNameInput(String name) {
        nameInputField.val(name);
    }

    public void setValueInEmailInput(String email) {
        emailInputField.val(email);
    }

    public void setValueInPasswordInput(String password) {
        passwordInputField.val(password);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }




}
