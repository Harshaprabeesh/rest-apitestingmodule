package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Employees;
import com.services.EmployeeService;
import org.testng.annotations.Test;


public class EmployeeTest {
private ObjectMapper mapper  = new ObjectMapper();
//moved to common class service
//private String baseURI ="http://jsonplaceholder.typicode.com";
//private String basePath = "/posts";
 @Test
    public void saveANewEmployee() {

        String file ="employee.json";


    EmployeeService employeeService =new EmployeeService();
     Employees employees= employeeService.readAFile(file);
     employeeService.saveNewEmployee(employees);


     //post--moved to common class
//given().baseUri(baseURI)
//             .basePath(basePath)
//             .contentType(ContentType.JSON)
//             .body(employees)
//             .log().all()
//     .when()
//             .log().all()
//             .post("/")
//
//     .then()
//             .log().all()
//             .assertThat().statusCode(HttpStatus.SC_CREATED);

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

