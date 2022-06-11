package ru.yandex.stellarburger;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.stellarburger.pages.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;

public class BurgerConstructorTests {

    @Test
    @DisplayName("Возможно перейти к разделу конструктора, нажав на его название в селекте")
    public void shouldSwitchToSelectedSectorTest() {
        ConstructorPage constructorPage = open(ConstructorPage.url, ConstructorPage.class);
        constructorPage.clickOnIngredientSectorButton();
        Assert.assertTrue(constructorPage.checkCurrentSelectInConstructor("Начинки"));

        constructorPage.clickOnSauceSectorButton();
        Assert.assertTrue(constructorPage.checkCurrentSelectInConstructor("Соусы"));

        constructorPage.clickOnBunSectorButton();
        Assert.assertTrue(constructorPage.checkCurrentSelectInConstructor("Булки"));
    }


}
