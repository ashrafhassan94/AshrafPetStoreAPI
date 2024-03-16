package org.Testinium;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.Testinium.Constants.EndPoints;
import org.hamcrest.Matcher;

public class Base {

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(EndPoints.BASE_URL )
                .addHeader("content-type", "application/json")
                .build();
    }

    public static ResponseSpecification responseSpec(int StatusCode) {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON)
                .expectStatusCode(StatusCode)
                .build();
    }


}
