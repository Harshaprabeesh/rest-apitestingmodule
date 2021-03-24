package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Employees;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import static io.restassured.RestAssured.given;


public class EmployeeTest {
private ObjectMapper mapper  = new ObjectMapper();
private String baseURI ="http://jsonplaceholder.typicode.com";
private String basePath = "/posts";
 @Test
    public void saveANewEmployee() {

        String file ="employee.json";
        URL url = getClass().getClassLoader().getResource(file);
     Employees employees=null;
     try {
        employees = mapper.readValue(url, Employees.class);
     } catch (IOException e) {
         System.out.println("File reading error");
         e.printStackTrace();
     }
     System.out.println(employees);
     //post
given().baseUri(baseURI)
             .basePath(basePath)
             .contentType(ContentType.JSON)
             .body(employees)
             .log().all()
     .when()
             .log().all()
             .post("/")

     .then()
             .log().all()
             .assertThat().statusCode(HttpStatus.SC_CREATED);

////GET - stores and asserts body
//     ValidatableResponse response=given().baseUri(baseURI)
//             .basePath(basePath)
//             .contentType(ContentType.JSON)
//             .body(employees)
//             .log().all()
//
//     .when()
//             .log().all()
//             .get("/")
//
//     .then()
//            // .log().all()
//             .assertThat().statusCode(HttpStatus.SC_OK);
//     Employees actualEmployees = response.extract().body(). as(Employees.class);
//     System.out.println(actualEmployees);
//     //Assert.assertEquals(actualEmployees,employees,"Employees correct details");


  }


}

