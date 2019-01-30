package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void testStatementReturnsResultForRegularMovieRentedForOneDay(){
        Movie movie = new Movie("Titanic", Movie.REGULAR);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("Customer1");
        customer.addRental(rental);
        String expectedResult = "Rental Record for Customer1\n"
        + "\tTitanic\t2.0\n"
        + "Amount owed is 2.0\n"
        + "You earned 1 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsResultForRegularMovieRentedForMoreThan2Days(){
        Movie movie = new Movie("Titanic", Movie.REGULAR);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("Customer1");
        customer.addRental(rental);
        String expectedResult = "Rental Record for Customer1\n"
        + "\tTitanic\t3.5\n"
        + "Amount owed is 3.5\n"
        + "You earned 1 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsResultForChildrensMovieRentedFor1Day(){
        Movie movie = new Movie("Power Puff Girls", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("Customer1");
        customer.addRental(rental);
        String expectedResult = "Rental Record for Customer1\n"
        + "\tPower Puff Girls\t1.5\n"
        + "Amount owed is 1.5\n"
        + "You earned 1 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsResultForChildrensMovieRentedForMoreThan3Days(){
        Movie movie = new Movie("Power Puff Girls", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 4);
        Customer customer = new Customer("Customer1");
        customer.addRental(rental);
        String expectedResult = "Rental Record for Customer1\n"
        + "\tPower Puff Girls\t3.0\n"
        + "Amount owed is 3.0\n"
        + "You earned 1 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsResultForNewReleaseMovieFor1Day(){
        Movie movie = new Movie("Aquaman", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("Customer1");
        customer.addRental(rental);
        String expectedResult = "Rental Record for Customer1\n"
        + "\tAquaman\t3.0\n"
        + "Amount owed is 3.0\n"
        + "You earned 1 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsResultForNewReleaseMovieForMoreThan1DayHaveBonus(){
        Movie movie = new Movie("Aquaman", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("Customer1");
        customer.addRental(rental);
        String expectedResult = "Rental Record for Customer1\n"
        + "\tAquaman\t6.0\n"
        + "Amount owed is 6.0\n"
        + "You earned 2 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsResultForMoviesOfAllKindsFor1Day(){
        Movie movieRegular = new Movie("Titanic", Movie.REGULAR);
        Movie movieChildren = new Movie("Power Puff Girls", Movie.CHILDRENS);
        Movie movieNewRelease = new Movie("Aquaman", Movie.NEW_RELEASE);
        Rental rentalRegular = new Rental(movieRegular, 1);
        Rental rentalChildren = new Rental(movieChildren, 1);
        Rental rentalNewRelease = new Rental(movieNewRelease, 1);
        Customer customer = new Customer("Customer1");
        customer.addRental(rentalRegular);
        customer.addRental(rentalChildren);
        customer.addRental(rentalNewRelease);
        String expectedResult = "Rental Record for Customer1\n"
                + "\tTitanic\t2.0\n"
                + "\tPower Puff Girls\t1.5\n"
                + "\tAquaman\t3.0\n"
                + "Amount owed is 6.5\n"
                + "You earned 3 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsResultForMoviesOfAllKindsFor4Days(){
        Movie movieRegular = new Movie("Titanic", Movie.REGULAR);
        Movie movieChildren = new Movie("Power Puff Girls", Movie.CHILDRENS);
        Movie movieNewRelease = new Movie("Aquaman", Movie.NEW_RELEASE);
        Rental rentalRegular = new Rental(movieRegular, 4);
        Rental rentalChildren = new Rental(movieChildren, 4);
        Rental rentalNewRelease = new Rental(movieNewRelease, 4);
        Customer customer = new Customer("Customer1");
        customer.addRental(rentalRegular);
        customer.addRental(rentalChildren);
        customer.addRental(rentalNewRelease);
        String expectedResult = "Rental Record for Customer1\n"
                + "\tTitanic\t5.0\n"
                + "\tPower Puff Girls\t3.0\n"
                + "\tAquaman\t12.0\n"
                + "Amount owed is 20.0\n"
                + "You earned 4 frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.statement());
    }

    @Test
    public void testStatementReturnsHTMLResultForMoviesOfAllKindsFor4Days(){
        Movie movieRegular = new Movie("Titanic", Movie.REGULAR);
        Movie movieChildren = new Movie("Power Puff Girls", Movie.CHILDRENS);
        Movie movieNewRelease = new Movie("Aquaman", Movie.NEW_RELEASE);
        Rental rentalRegular = new Rental(movieRegular, 4);
        Rental rentalChildren = new Rental(movieChildren, 4);
        Rental rentalNewRelease = new Rental(movieNewRelease, 4);
        Customer customer = new Customer("Customer1");
        customer.addRental(rentalRegular);
        customer.addRental(rentalChildren);
        customer.addRental(rentalNewRelease);
        String expectedResult = "<h1>Rental Record for <b>Customer1</b></h1><br/>"
                + "Titanic 5.0<br/>"
                + "Power Puff Girls 3.0<br/>"
                + "Aquaman 12.0<br/>"
                + "Amount owed is <b>20.0</b><br/>"
                + "You earned <b>4</b> frequent renter points";
        Assert.assertEquals("Result not equal", expectedResult, customer.htmlStatement());
    }
}