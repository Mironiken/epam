package com.epam.javacourse;

import java.time.Period;

/**
 * Created on 26.02.2017.
 */
public class Sheet extends Stationery {

    private int numberOfSheet;

    public Sheet (double price) {
        super(price, Period.ofMonths(1), StationeryName.Sheet);
        this.numberOfSheet = 250;
    }

    public int getNumberOfSheet() {
        return numberOfSheet;
    }

    public void setNumberOfSheet(int numberOfSheet) {
        this.numberOfSheet = numberOfSheet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sheet)) return false;
        if (!super.equals(o)) return false;

        Sheet sheet = (Sheet) o;

        return getNumberOfSheet() == sheet.getNumberOfSheet();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNumberOfSheet();
        return result;
    }
}
