package com.thoughtworks.movierental;

public class TextStatement {
    public String display(String name, double totalAmount, int frequentRenterPoints, String rentalDetails) {
        String result = "Rental Record for " + name + "\n";
        result += rentalDetails;
        //add footer lines result
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}