package com.epam.javacourse;

import java.time.Period;

/**
 * Created on 26.02.2017.
 */
public class Ruler extends Stationery {

    private int length;

    public Ruler (double price, int length) {
        super(price, Period.ofMonths(1), StationeryName.Ruler);
        this.length = length;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ruler)) return false;
        if (!super.equals(o)) return false;

        Ruler ruler = (Ruler) o;

        return length == ruler.length;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + length;
        return result;
    }
}
