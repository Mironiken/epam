package com.epam.javacourse;

/**
 * Created on 02.03.2017.
 */
public class BeginnerStationerySet extends StationeryList {
    public BeginnerStationerySet(){
        StationeryList beginnerSet = new StationeryList();
        beginnerSet.add(new Pen(10, Color.BLUE));
        beginnerSet.add(new Sheet(15));
        beginnerSet.add(new Stapler(5));
    }
    @Override
    public void add(Stationery newItem) throws UnsupportedOperationException{
        if (contains(newItem)) {
            super.add(newItem);
        } else {
            new UnsupportedOperationException("Набор новичка не расширяется");
        }
    }
    
}
