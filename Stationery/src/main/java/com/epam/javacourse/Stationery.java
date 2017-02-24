package com.epam.javacourse;

/**
 * Created on 24.02.2017.
 */
public class Stationery {
    private double price;
    private double lifeTime;


    public Stationery(double price, double lifeTime) {
        this.price = price;
        this.lifeTime = lifeTime;
    }

    public double getPrice() {
        return price;
    }

    public double getLifeTime() {
        return lifeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stationery that = (Stationery) o;

        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        return Double.compare(that.getLifeTime(), getLifeTime()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getPrice());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLifeTime());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
