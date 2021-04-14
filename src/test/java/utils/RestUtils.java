package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class RestUtils {
    Response response;

    public String key(String key) {
        return response.getBody().jsonPath().getString(key);
    }
    public List<String> keyList(String key){
        List<String> keys = new ArrayList<String>();
        keys = response.getBody().jsonPath().getList(key);
        return keys;
    }

    public void get(String url, String endpoint) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(url)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        this.response = response;
    }

    public void post(String url, String endpoint,Object json) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(url)
                .when()
                .body(json)
                .post(endpoint)
                .then()
                .extract()
                .response();
        this.response = response;
    }
}
