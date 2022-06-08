package ru.yandex.stellarburger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.stellarburger.helper.API.ApiRequests;
import ru.yandex.stellarburger.helper.BaseMethods.UserMethods;
import ru.yandex.stellarburger.models.UserModel;
import ru.yandex.stellarburger.pages.LoginPage;
import ru.yandex.stellarburger.pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class RegisterTests {

    UserModel user;

    @Before
    public void setUp() {
        System.out.println("Set up");
        user = UserMethods.generateRandomUser();
    }


    @Test
    public void shouldBeSuccessfulRegisteredTest() {
        RegisterPage registerPage = open(RegisterPage.url, RegisterPage.class);
        registerPage.setValueInNameInput(user.getName());
        registerPage.setValueInEmailInput(user.getEmail());
        registerPage.setValueInPasswordInput(user.getPassword());
        registerPage.clickOnRegisterButton();
        //Нужно сделать нормальное ожидание
        sleep(800);
        Assert.assertEquals(LoginPage.url, url());

        //Убеждаемся, что пользователь зарегистрирован
        Assert.assertEquals(ApiRequests.sendPostRequest(user, "/api/auth/login").statusCode(), 200);
    }


    @After
    public void tearDown() {
        System.out.println("Tear down");
        String token = ApiRequests.getUsersToken(user);
        ApiRequests.deleteUser(token);
    }


}
