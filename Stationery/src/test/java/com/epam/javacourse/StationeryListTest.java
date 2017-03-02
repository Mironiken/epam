package com.epam.javacourse;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 27.02.2017.
 */
public class StationeryListTest {
    @Test
    public void testThatWeCanCreateStationaryListFromOtherStationaryList(){
        StationeryList list1 = new StationeryList();
        StationeryList list2 = new StationeryList(list1);
        assertTrue(list2 instanceof StationeryList);
    }
    @Test
    public void testThatWeCanCreateStationaryListFromOtherListOfStationary(){
        List<Stationery> list1 = Arrays.asList(new Pen(10.5, Color.BLACK));
        StationeryList list2 = new StationeryList(list1);
        assertTrue(list2 instanceof StationeryList);
    }
    @Test
    public void testThatWeCanFindAddedElementInStationaryList(){
        StationeryList list = new StationeryList();
        list.add(new Pen(10.5, Color.BLACK));
        list.add(new Pen(11, Color.BLACK));
        list.add(new Stapler(12));
        list.add(new Pencil(10));
        assertTrue(list.contains(new Pencil(10)));
    }
    @Test
    public void testThatWeCanAddElementInStationaryList(){           //Что делать если ты хочешь проверить неналичие ошибки
        StationeryList list1 = new StationeryList();
        Stapler stapler = new Stapler(1);
        list1.add(stapler);
        assertTrue(list1.contains(stapler));
    }
    @Test
    public void testThatWeCanDeleteAddedElementInStationaryList(){
        StationeryList list1 = new StationeryList();
        Stapler stapler = new Stapler(1);
        list1.add(stapler);
        assertTrue(list1.contains(stapler));
        list1.delete(stapler);
        assertFalse(list1.contains(stapler));
    }
    @Test
    public void testThatWeCanDeleteNotAddedElementInStatinaryList() {
        StationeryList list1 = new StationeryList();
        Stapler stapler = new Stapler(1);
        list1.delete(stapler);
    }

}