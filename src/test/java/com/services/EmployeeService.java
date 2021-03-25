package com.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Employees;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class EmployeeService {
    private String baseURI ="http://jsonplaceholder.typicode.com";
    private String basePath = "/posts";
    private ObjectMapper mapper = new ObjectMapper();
    public void saveNewEmployee(Employees employees){
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


    }

    public Employees readAFile(String file){

        URL url = getClass().getClassLoader().getResource(file);
        Employees employees=null;
        try {
            employees = mapper.readValue(url, Employees.class);
        } catch (IOException e) {
            System.out.println("File reading error");
            e.printStackTrace();

        }
        System.out.println(employees);
        return employees;


    }
}
