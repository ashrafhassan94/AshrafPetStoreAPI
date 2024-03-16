package org.Testinium;

import io.restassured.response.Response;
import org.Testinium.Constants.EndPoints;
import org.Testinium.Constants.StatusCodes;
import static io.restassured.RestAssured.given;
import static org.Testinium.Constants.EndPoints.BASE_URL;

public class PostPetBase extends Base{

    public  String AddNewPet_returnNameUponSuccess(String Input) {

        Response response =  given()
                .spec(requestSpec())
                .body(Input)
                .when()
                .post(BASE_URL +EndPoints.PET)
                .then()
                .spec(responseSpec(StatusCodes.ACCEPTED))
                .extract().response();
        return response.jsonPath().getString("name") ;
    }
    public  String AddNewPet(String Input,int Status) {
        Response response =  given()
                .spec(requestSpec())
                .body(Input)
                .when()
                .post(BASE_URL +EndPoints.PET)
                .then()
                .spec(responseSpec(Status))
                .extract().response();

        return response.jsonPath().getString("name") ;
    }
}
