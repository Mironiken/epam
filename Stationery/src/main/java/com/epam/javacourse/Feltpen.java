package com.epam.javacourse;

import java.time.Period;

/**
 * Created on 26.02.2017.
 */
public class Feltpen extends Stationery {

    private Color color;

    public Feltpen(double price, Color color) {
        super(price, Period.ofMonths(3), StationaryName.Feltpen);
        this.color = color;
    }


    public Color getColor() {
        return color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pen)) return false;
        if (!super.equals(o)) return false;

        Pen pen = (Pen) o;

        return getColor() == pen.getColor();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getColor().hashCode();
        return result;
    }
}
