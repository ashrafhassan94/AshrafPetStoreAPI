package org.Testinium;

import io.restassured.response.Response;
import org.Testinium.Constants.EndPoints;
import org.Testinium.Constants.StatusCodes;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.Testinium.Constants.EndPoints.file_Bath;

public class PostPet extends Base{
    File InsertedBody = new File(file_Bath);
    public  String AddNewPet_returnNameUponSuccess() {
        Response response =  given()
                .spec(requestSpec())
                .when()
                .post(EndPoints.PET,InsertedBody)
                .then()
                .spec(responseSpec(StatusCodes.ACCEPTED))
                .extract().response();

        return response.jsonPath().getString("name") ;
    }
    public  String AddNewPet() {
        Response response =  given()
                .spec(requestSpec())
                .when()
                .post(EndPoints.PET,InsertedBody)
                .then()
                .spec(responseSpec(StatusCodes.ACCEPTED))
                .extract().response();

        return response.jsonPath().getString("name") ;
    }
}
