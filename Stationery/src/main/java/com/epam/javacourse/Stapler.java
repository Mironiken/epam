package com.epam.javacourse;

import java.time.Period;

/**
 * Created on 25.02.2017.
 */
public class Stapler extends Stationery {

    public Stapler (double price) {
        super(price, Period.ofYears(3), StationaryName.Stapler);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stapler)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }
}
