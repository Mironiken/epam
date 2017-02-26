package com.epam.javacourse;

import java.time.Period;

/**
 * Created on 24.02.2017.
 */
public class Stationery {
    private double price;
    private Period lifeTime;


    Stationery(double price, Period lifeTime) {
        if (price < 0)
            new IllegalArgumentException("Price must be more than zero");
        this.price = price;
        this.lifeTime = lifeTime;
    }

    public double getPrice() {
        return price;
    }

    public Period getLifeTime() {
        return lifeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stationery that = (Stationery) o;

        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        return getLifeTime().equals(that.getLifeTime());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getPrice());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getLifeTime().hashCode();
        return result;
    }
}
