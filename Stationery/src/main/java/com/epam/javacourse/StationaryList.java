package com.epam.javacourse;

import java.util.Collection;
import java.util.List;

/**
 * Created on 27.02.2017.
 */
class StationaryList {
    private List<Stationery> stationeries;
    private List<Stationery> stationaries;

    public StationaryList(){}

    public StationaryList(List<Stationery> stationeries) {
        this.stationeries = stationeries;
    }

    public StationaryList(StationaryList newList) {
        stationeries.addAll(newList.getStationeries());
    }

    public List<Stationery> getStationeries() {
        return stationaries;
    }

    public void add (Stationery newItem){

    }

    public void delete (Stationery item){

    }

    public boolean search (Stationery item){

    }
}
