package ru.yandex.stellarburger;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.stellarburger.pages.ConstructorPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BurgerConstructorTests {

    @Test
    @DisplayName("Возможно перейти к разделу конструктора, нажав на его название в селекте")
    public void shouldSwitchToSelectedSectorTest() {
        ConstructorPage constructorPage = open(ConstructorPage.url, ConstructorPage.class);
        constructorPage.clickOnIngredientSectorButton();
        Assert.assertTrue($(By.xpath("//h2[contains(text(), 'Начинки')]")).isDisplayed());

        constructorPage.clickOnSauceSectorButton();
        Assert.assertTrue($(By.xpath("//h2[contains(text(), 'Соусы')]")).isDisplayed());

        constructorPage.clickOnBunSectorButton();
        Assert.assertTrue($(By.xpath("//h2[contains(text(), 'Булки')]")).isDisplayed());
    }


}
