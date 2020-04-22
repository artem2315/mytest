import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class test {

    @Test
    public void users()
    {
        //create users
        RestAssured.given().contentType(ContentType.JSON).with().body(Users.UserList).when().post("https://petstore.swagger.io/v2/user/createWithList");
        //get user 1
        RestAssured.given().when().get("https://petstore.swagger.io/v2/user/Vova")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body("id",equalTo(666))
                .and()
                .body("username",equalTo("Vova"));
        //get user 2
        RestAssured.given().when().get("https://petstore.swagger.io/v2/user/Lexa")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body("id",equalTo(999))
                .and()
                .body("username",equalTo("Lexa"));
        //update user 2
        RestAssured.given().contentType(ContentType.JSON).with().body(Users.UserUpdate).when().put("https://petstore.swagger.io/v2/user/Lexa");
        //get updated user
        RestAssured.given().when().get("https://petstore.swagger.io/v2/user/Aloxa")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body("id",equalTo(999))
                .and()
                .body("username",equalTo("Aloxa"));
        //delete users
        RestAssured.given().delete("https://petstore.swagger.io/v2/user/Vova", new Object[0]);
        RestAssured.given().delete("https://petstore.swagger.io/v2/user/Aloxa", new Object[0]);
    }
}


