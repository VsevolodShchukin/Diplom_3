package ru.yandex.stellarburger.helper.API;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.yandex.stellarburger.models.BaseModel;
import ru.yandex.stellarburger.models.UserModel;

import static io.restassured.RestAssured.given;

public class ApiRequests {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    @Step("Send Post request")
    public static Response sendPostRequest(BaseModel request, String url) {
        Response response = given()
                .spec(getBaseSpec())
                .and()
                .body(request)
                .when()
                .post(url);
        return response;
    }

    @Step("Send Delete request")
    public static Response sendDeleteRequest(String url, String token) {
        Response response = given()
                .spec(getBaseSpec())
                .auth().oauth2(token)
                .and()
                .when()
                .delete(url);
        return response;
    }

    @Step("Get user's token")
    public static String getUsersToken(UserModel user) {
        String token = sendPostRequest(user, "/api/auth/login").body().path("accessToken").toString().split(" ")[1];
        return token;
    }

    @Step("Delete user")
    public static void deleteUser(String token){
        ApiRequests.sendDeleteRequest("/api/auth/user", token);
    }


}
