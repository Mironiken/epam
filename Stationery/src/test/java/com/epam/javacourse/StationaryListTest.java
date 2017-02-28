package com.epam.javacourse;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 27.02.2017.
 */
public class StationaryListTest {
    @Test
    public void testThatWeCanCreateStationaryListFromOtherStationaryList(){
        StationaryList list1 = new StationaryList();
        StationaryList list2 = new StationaryList(list1);
        assertTrue(list2 instanceof StationaryList);
    }
    @Test
    public void testThatWeCanCreateStationaryListFromOtherListOfStationary(){
        List<Stationery> list1 = Arrays.asList(new Pen(10.5, Color.BLACK));
        StationaryList list2 = new StationaryList(list1);
        assertTrue(list2 instanceof StationaryList);
    }
    @Test
    public void testThatWeCanFindAddedElementInStationaryList(){
        StationaryList list = new StationaryList();
        list.add(new Pen(10.5, Color.BLACK));
        list.add(new Pen(11, Color.BLACK));
        list.add(new Stapler(12));
        list.add(new Pencil(10));
        assertTrue(list.search(new Pencil(10)));
    }
    @Test
    public void testThatWeCanAddElementInStationaryList(){

    }
    @Test
    public void testThatWeCanDeleteAddedElementInStationaryList(){

    }
    @Test
    public void testThatWeCanDeleteNotAddedElementInStatinaryList(){

    }

}