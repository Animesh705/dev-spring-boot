package com.luvIsCode.springdev.mvc;

import jakarta.validation.constraints.*;

public class Customer {
    //we will have customer first and last name
    private String firstName;

    //we want our last name to be as required field
    @NotNull(message="is required")
    @Size(min=1,message = "is required")
    private String lastName = "";

    //we will min and max validation rule for free passes
    @Min(value=0, message="must be greater than 0")
    @Max(value=10, message="must be less than or equal to 10")
    private int freePass;


    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 digit/chars")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getFreePass() {
        return freePass;
    }

    public void setFreePass(int freePass) {
        this.freePass = freePass;
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
