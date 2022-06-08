package ru.yandex.stellarburger.helper.BaseMethods;

import org.apache.commons.lang3.RandomStringUtils;
import ru.yandex.stellarburger.models.UserModel;

public class UserMethods {

    public static UserModel generateRandomUser() {
        String randomData = RandomStringUtils.randomAlphabetic(10);
        UserModel userModel = new UserModel(randomData, randomData + "@example.com", randomData);
        return userModel;
    }

}
