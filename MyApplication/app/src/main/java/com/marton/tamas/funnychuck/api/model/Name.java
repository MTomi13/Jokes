package com.marton.tamas.funnychuck.api.model;

/**
 * Created by tamas.marton on 21/03/2017.
 */
//helper object class to handle firstname, and lastname parameters for the changeNameOfCharacter requests
public class Name {

    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}