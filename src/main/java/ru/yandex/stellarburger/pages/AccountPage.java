package ru.yandex.stellarburger.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.disappear;

public class AccountPage extends BasePage{

    public final static String url = "https://stellarburgers.nomoreparties.site/account/profile";

    //Logout button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Выход')]")
    private SelenideElement logoutButton;

    @Step("Нажать на кнопку {logoutButton}")
    public void clickOnLogoutButton() {
        logoutButton.click();
        logoutButton.shouldBe(disappear);
    }


}
