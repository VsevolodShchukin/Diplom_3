package ru.yandex.stellarburger.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {

    //Account link button
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Личный Кабинет')]")
    private SelenideElement accountLinkButton;

    //Constructor link button
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Конструктор')]")
    private SelenideElement constructorLinkButton;

    //Logo link button
    @FindBy(how = How.XPATH, using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logoLinkButton;

    @Step("Нажать на кнопку {accountLinkButton}")
    public void clickOnAccountPageButton() {
        accountLinkButton.click();
    }

    @Step("Нажать на кнопку {constructorLinkButton}")
    public void clickOnConstructorLinkButton() {
        constructorLinkButton.click();
    }

    @Step("Нажать на кнопку {logoLinkButton}")
    public void clickOnLogoLinkButton() {
        logoLinkButton.click();
    }

}
