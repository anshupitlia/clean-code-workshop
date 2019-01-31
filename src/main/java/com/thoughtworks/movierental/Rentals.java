package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    private List<Rental> rentals = new ArrayList<>();

    Rentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public String textDetails() {
        String result = "";
        for (Rental each : rentals) {
            result += each.getFormattedStringForTitle() + String.valueOf(each.amount()) + "\n";
        }
        return result;
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.amount();
        }
        return totalAmount;
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints += each.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}
