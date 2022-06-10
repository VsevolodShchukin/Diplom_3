package ru.yandex.stellarburger;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.stellarburger.helpers.API.ApiMethods;
import ru.yandex.stellarburger.helpers.BaseMethods.UserMethods;
import ru.yandex.stellarburger.helpers.models.UserModel;
import ru.yandex.stellarburger.pages.LoginPage;
import ru.yandex.stellarburger.pages.RegisterPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class RegisterTests {

    UserModel user;

    @Before
    public void setUp() {
        System.out.println("Set up");
        user = UserMethods.generateRandomUser();
    }

    @After
    public void tearDown() {
        System.out.println("Tear down");
        try {
            String token = ApiMethods.getUsersToken(user);
            ApiMethods.deleteUser(token);
        } catch (Exception e) {
            System.out.println("Пользователь не был удален");
        }
    }


    @Test
    @DisplayName("Возможно создать пользователя через страницу регистрации")
    public void shouldBeSuccessfulRegisteredTest() {
        RegisterPage registerPage = open(RegisterPage.url, RegisterPage.class);
        registerPage.registerNewUser(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertEquals("Url отличается от ожидаемого", LoginPage.url, url());

        //Убеждаемся, что пользователь зарегистрирован
        Assert.assertEquals("Статус код отличается от ожидаемого", ApiMethods.sendPostRequest(user, "/api/auth/login").statusCode(), 200);
    }

    @Test
    @DisplayName("Невозможно создать пользователя с некорректным паролем через страницу регистрации")
    public void registrationWithInvalidPassword() {
        RegisterPage registerPage = open(RegisterPage.url, RegisterPage.class);
        registerPage.setValueInNameInput(user.getName());
        registerPage.setValueInEmailInput(user.getEmail());
        registerPage.setValueInPasswordInput("12345");
        registerPage.clickOnRegisterButton();
        Assert.assertNotEquals("Url совпадает", LoginPage.url, url());
        Assert.assertTrue("Сообщение 'Некорректный пароль' не отобразилось", $(byText("Некорректный пароль")).exists());
    }


}
