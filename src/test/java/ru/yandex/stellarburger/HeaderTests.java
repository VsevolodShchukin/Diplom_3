package ru.yandex.stellarburger;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.stellarburger.helpers.API.ApiMethods;
import ru.yandex.stellarburger.helpers.BaseMethods.UserMethods;
import ru.yandex.stellarburger.helpers.models.UserModel;
import ru.yandex.stellarburger.pages.AccountPage;
import ru.yandex.stellarburger.pages.LoginPage;
import ru.yandex.stellarburger.pages.ConstructorPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HeaderTests {


    UserModel user;
    String token;

    @Before
    public void setUp() {
        System.out.println("Set up");
        user = UserMethods.generateRandomUser();
        token = ApiMethods.registerUser(user);
        LoginPage loginPage = open(LoginPage.url, LoginPage.class);
        loginPage.logIn(user.getEmail(), user.getPassword());
    }

    @After
    public void tearDown() {
        System.out.println("Tear down");
        try {
            ApiMethods.deleteUser(token);
        } catch (Exception e) {
            System.out.println("Пользователь не был удален");
        }
    }

    @Test
    @DisplayName("Открывается страница 'Личный кабинет' при клике по кнопке 'Личный кабинет'")
    public void shouldOpenAccountPageByClickingOnAccountLinkTest() {
        ConstructorPage constructorPage = page(ConstructorPage.class);
        constructorPage.clickOnAccountPageButton();
        Assert.assertEquals(AccountPage.url, url());
    }

    @Test
    @DisplayName("Открывается страница 'Конструктор' при переходе по логотипу")
    public void shouldOpenConstructorPageByClickingOnLogoLinkTest() {
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickOnAccountPageButton();
        accountPage.clickOnLogoLinkButton();
        Assert.assertEquals(ConstructorPage.url, url());
    }

    @Test
    @DisplayName("Открывается страница 'Конструктор' при клике по кнопке 'Конструктор'")
    public void shouldOpenConstructorPageByClickingOnConstructorLinkTest() {
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickOnAccountPageButton();
        accountPage.clickOnConstructorLinkButton();
        Assert.assertEquals(ConstructorPage.url, url());
    }

}
