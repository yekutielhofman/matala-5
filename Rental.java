package com.company;

public class Rental {
    Book book;
    String id;
    Date rentStart;
    Date rentEnd;

    //banai
    public Rental(Book book, String id, Date rentStart) {
        this.book = book;
        this.id = id;
        this.rentStart = rentStart;
        this.rentEnd = null;
    }

    //method 1
    public void endRent(Date d) {
        rentEnd = new Date(d.day, d.month, d.year);
    }

    //method 2
    public int daysOfRent() {
        int leapYear = 0;
        int daysOfStart = rentStart.day + rentStart.year * 365;
        int daysOfEnd = rentEnd.day + rentEnd.year * 365;
        int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = rentStart.year; i<rentEnd.year;i++){
            if (i % 4 == 0 && i % 100!= 0||i % 4 == 0 && i % 100 == 0 && i % 400 == 0) {
                leapYear++;
            }
        }
        if (rentEnd == null) return -1;
        else {
            for (int i = rentStart.month-1; i > 0; i--) {
                daysOfStart += daysPerMonth[i];
            }
            for (int i = rentEnd.month-1; i > 0; i--) {
                daysOfEnd += daysPerMonth[i];
            }
        }
        return daysOfEnd - daysOfStart + leapYear;
    }
    //method 3
    public int costOf(){
        return book.getPrice()*daysOfRent();
    }
}