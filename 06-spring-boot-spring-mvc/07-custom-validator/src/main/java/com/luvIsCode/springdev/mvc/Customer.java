package com.luvIsCode.springdev.mvc;

import com.luvIsCode.springdev.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    //we will have customer first and last name
    private String firstName;

    //we want our last name to be as required field
    @NotNull(message="is required")
    @Size(min=1,message = "is required")
    private String lastName = "";

    //we will min and max validation rule for free passes
    @NotNull(message="is required") // this is required to be filled cant leave null
    @Min(value=0, message="must be greater than 0")
    @Max(value=10, message="must be less than or equal to 10")
    private Integer freePass; // we used Integer here instead of int ,beacue initBinder works for String and Integer (wrapper class)

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }
    public Integer getFreePass() {
        return freePass;
    }

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 digit/chars")
    private String postalCode;

    //add this line of code in this line for other than ani like ayu-
    @CourseCode //(value="AYU", message="must start with AYU")
    private String CourseCode;

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String CourseCode) {
        this.CourseCode = CourseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
