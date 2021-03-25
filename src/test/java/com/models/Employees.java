package com.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
//Builder is a pattern for creating objects easily
@Builder


public class Employees {

    private int userid;
    private String title;
   // private double employee_salary;
    private String body;
    private int id;
}
