package com.epam.javacourse;

import java.time.Period;

/**
 * Created on 25.02.2017.
 */
public class Pencil extends Stationery {

    public Pencil (double price) {
        super(price, Period.ofMonths(1), StationaryName.Pencil);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pencil)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }
}
