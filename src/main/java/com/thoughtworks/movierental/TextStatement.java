package com.thoughtworks.movierental;

public class TextStatement {
    public String display(Rentals rentals, String name) {
        String result = "Rental Record for " + name + "\n";
        result += rentals.textDetails();
        //add footer lines result
        result += "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
        result += "You earned " + String.valueOf(rentals.frequentRenterPoints())
                + " frequent renter points";
        return result;
    }
}