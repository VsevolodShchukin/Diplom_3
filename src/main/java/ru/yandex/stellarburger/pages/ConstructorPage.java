package ru.yandex.stellarburger.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class ConstructorPage extends BasePage{

    public final static String url = "https://stellarburgers.nomoreparties.site/";

    //To login page button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти в аккаунт')]")
    private SelenideElement toLoginPageButton;

    //Make an order page button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Оформить заказ')]")
    private SelenideElement makeAnOrderButton;

    //Selector of buns
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Булки')]")
    private SelenideElement bunSectorButton;

    //Selector of sauces
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Соусы')]")
    private SelenideElement sauceSectorButton;

    //Selector of ingredients
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Начинки')]")
    private SelenideElement ingredientSectorButton;

    @Step("Нажать на кнопку {bunSectorButton}")
    public void clickOnBunSectorButton() {
        bunSectorButton.click();
    }

    @Step("Нажать на кнопку {sauceSectorButton}")
    public void clickOnSauceSectorButton() {
        sauceSectorButton.click();
    }

    @Step("Нажать на кнопку {ingredientSectorButton}")
    public void clickOnIngredientSectorButton() {
        ingredientSectorButton.click();
    }

    @Step("Нажать на кнопку {toLoginPageButton}")
    public void clickOnToLoginPageButton() {
        toLoginPageButton.click();
    }

    @Step("Проверить, что выбран селект - {name}")
    public boolean checkCurrentSelectInConstructor(String name) {
        return $(By.xpath("//div[contains(@class, 'current') and //span[contains(text(), '" + name + "')]]")).exists();

    }

}
