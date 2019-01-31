package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    String result = "";
    for (Rental each : rentals) {
      result += each.getFormattedStringForTitle() + String.valueOf(each.amount()) + "\n";
    }
    return new TextStatement().display(getName(), getTotalAmount(), getFrequentRenterPoints(), result);
  }

  public String htmlStatement() {
    String result = "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";

    for (Rental each : rentals) {
      result += each.getFormattedHTMLStringForTitle() + " " + String.valueOf(each.amount()) + "<br/>";
    }

    //add footer lines result
    result += "Amount owed is <b>" + String.valueOf(getTotalAmount()) + "</b><br/>";
    result += "You earned <b>" + String.valueOf(getFrequentRenterPoints())
        + "</b> frequent renter points";
    return result;
  }

  private int getFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      frequentRenterPoints += each.frequentRenterPoints();
    }
    return frequentRenterPoints;
  }

  private double getTotalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.amount();
    }
    return totalAmount;
  }
  
}

