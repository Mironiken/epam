package com.epam.javacourse;

import java.time.Period;

/**
 * Created on 26.02.2017.
 */


public class Feltpen extends Stationery {

    private Color color;

    public Feltpen(double price, Color color) {
        super(price, Period.ofMonths(3), StationeryName.Feltpen);
        this.color = color;
    }


    public Color getColor() {
        return color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feltpen)) return false;
        if (!super.equals(o)) return false;

        Feltpen feltpen = (Feltpen) o;

        return getColor() == feltpen.getColor();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getColor().hashCode();
        return result;
    }
}
