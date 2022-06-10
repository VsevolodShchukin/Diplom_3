package ru.yandex.stellarburger;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.stellarburger.helpers.API.ApiMethods;
import ru.yandex.stellarburger.helpers.BaseMethods.UserMethods;
import ru.yandex.stellarburger.helpers.models.UserModel;
import ru.yandex.stellarburger.pages.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginAndLogoutTests {

    UserModel user;
    String token;

    @Before
    public void setUp() {
        System.out.println("Set up");
        user = UserMethods.generateRandomUser();
        token = ApiMethods.registerUser(user);
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
    @DisplayName("Возможно залогиниться, перейдя по кнопке 'Войти'")
    public void loginByConstructorPageTest() {
        ConstructorPage constructorPage = open(ConstructorPage.url, ConstructorPage.class);
        constructorPage.clickOnToLoginPageButton();
        Assert.assertEquals(LoginPage.url, url());

        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(user.getEmail(), user.getPassword());

        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", $(byText("Оформить заказ")).exists());
    }

    @Test
    @DisplayName("Возможно залогиниться, перейдя по кнопке 'Личный кабинет'")
    public void loginByAccountPageTest() {
        BasePage constructorPage = open(ConstructorPage.url, ConstructorPage.class);
        constructorPage.clickOnAccountPageButton();
        Assert.assertEquals(LoginPage.url, url());

        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(user.getEmail(), user.getPassword());

        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", $(byText("Оформить заказ")).exists());
    }

    @Test
    @DisplayName("Возможно залогиниться, перейдя по ссылке со страницы 'Регистрация'")
    public void loginByRegisterPageTest() {
        RegisterPage registerPage = open(RegisterPage.url, RegisterPage.class);
        registerPage.clickOnLoginLink();
        Assert.assertEquals(LoginPage.url, url());

        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(user.getEmail(), user.getPassword());

        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", $(byText("Оформить заказ")).exists());
    }

    @Test
    @DisplayName("Возможно залогиниться, перейдя по ссылке со страницы 'Забыли пароль'")
    public void loginByForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.url, ForgotPasswordPage.class);
        forgotPasswordPage.clickOnLoginLink();
        Assert.assertEquals(LoginPage.url, url());

        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(user.getEmail(), user.getPassword());

        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", $(byText("Оформить заказ")).exists());
    }

    @Test
    @DisplayName("Возможно разлогиниться из аккаунта через страницу 'Личный кабинет'")
    public void logoutByAccountPageTest() {
        LoginPage loginPage = open(LoginPage.url, LoginPage.class);
        loginPage.logIn(user.getEmail(), user.getPassword());

        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickOnAccountPageButton();

        accountPage.clickOnLogoutButton();
        Assert.assertEquals("Url отличается от ожидаемого", LoginPage.url, url());
    }

}
