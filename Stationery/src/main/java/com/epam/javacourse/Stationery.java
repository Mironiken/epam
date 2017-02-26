package com.epam.javacourse;

import java.time.LocalDate;
import java.time.Period;
/**
 * Created on 24.02.2017.
 */
class Stationery {

    private double price;
    private Period lifeTime;
    private LocalDate startOfUsing;
    private StationaryName name;


    Stationery(double price, Period lifeTime, StationaryName name) {
        if (price < 0)
            new IllegalArgumentException("Price must be more than zero");
        this.price = price;
        this.lifeTime = lifeTime;
        this.name = name;
        this.startOfUsing = LocalDate.now();
    }


    public double getPrice() {
        return price;
    }

    public Period getLifeTime() {
        return lifeTime;
    }

    public StationaryName getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stationery)) return false;

        Stationery that = (Stationery) o;

        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        return getName() == that.getName();

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getPrice());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getName().hashCode();
        return result;
    }
}
