package ru.yandex.stellarburger.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends BasePage{

    public final static String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Login link button
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Войти')]")
    private SelenideElement loginLink;

    @Step("Нажать на кнопку {loginLink}")
    public void clickOnLoginLink(){
        loginLink.click();
    }


}
