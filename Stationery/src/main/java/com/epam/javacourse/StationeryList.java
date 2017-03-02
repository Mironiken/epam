package com.epam.javacourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 27.02.2017.
 */
class StationeryList {
    private List<Stationery> stationeries = new ArrayList<Stationery>();

    public StationeryList(){}

    public StationeryList(List<Stationery> stationeries) {
        this.stationeries = stationeries;
    }

    public StationeryList(StationeryList newList) {
        stationeries.addAll(newList.getStationeries());
    }

    public List<Stationery> getStationeries() {
        return stationeries;
    } //TODO возвращать не по ссылке

    /**
     * Добавляет в список канцелярский товар.
     *
     * Добавляет в список канцелярский товар. При совпадении товаров заменяет старый на новый.
     * @param newItem добавляемый товар
     */
    public void add (Stationery newItem){
        if (contains(newItem)){
            Stationery oldItem = newItem;
            delete(oldItem);
            stationeries.add(newItem);
        }else{
            stationeries.add(newItem);
        }
    }

    /**
     * Удаляет товар из списка канцелярских товаров.
     *
     * Удаляет товар из списка канцелярских товаров.
     * @param item удаляемый предмет
     */

    public void delete (Stationery item){
        if (contains(item)){
            stationeries.remove(item);
        }
    }

    /**
     * Ищет присутствует ли товар в списке.
     *
     * @param item
     * @return true, если товар содержится в списке, иначе false. 
     */

    public boolean contains(Stationery item){
         for (Stationery i : stationeries){
            if (item.equals(i)) return true;
        }
        return false;
    }
}
