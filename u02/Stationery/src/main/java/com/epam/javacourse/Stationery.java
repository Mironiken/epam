package com.epam.javacourse;

import java.time.LocalDate;
import java.time.Period;
/**
 * Created on 24.02.2017.
 */

/**
 * Класс для канцелярского товара.
 *
 * price - цена канцелярсокого товара
 * startOfUsing - время начала использования канцелярского товара
 * lifeTime - время запланированного использования товара
 * name - наименование товара
 */
class Stationery {

    private double price;
    private Period lifeTime;
    private LocalDate startOfUsing;
    private StationeryName name;

    /**
     * Создает новый экземпляр канцелярского товара
     *
     * Конструктор для канцеляроского товара
     * @param price цена, не меньше ноля
     * @param lifeTime время запланированного использования товара
     * @param name наименования канцелярского товара
     */


    Stationery(double price, Period lifeTime, StationeryName name) {
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

    public StationeryName getName() {
        return name;
    }

    /**
     * Сравнивает объекты
     *
     * При сравнении используются поля price и  name.
     * @param o
     * @return возвращает true, если поля price и name совпадают
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stationery)) return false;

        Stationery that = (Stationery) o;

        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        return getName() == that.getName();

    }

    /**
     * Метод высчитывающий хэш для объекта
     *
     * использует price и name при вычислении
     * @return хэшкод типа int
     */

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
