package com.epam.javacourse;

import java.util.Collection;
import java.util.List;

/**
 * Created on 27.02.2017.
 */
class StationaryList {
    List<Stationery> stationeries;
    private List<Stationery> stationaries;


    public StationaryList(List<Stationery> stationeries) {
        this.stationeries = stationeries;
    }

    public StationaryList(StationaryList newList) {
        stationeries.addAll(newList.getStationaries());
    }

    public List<Stationery> getStationaries() {
        return stationaries;
    }

    public void add (Stationery newItem){

    }

    public void delete (Stationery item){

    }

    public void search (Stationery item){

    }
}
