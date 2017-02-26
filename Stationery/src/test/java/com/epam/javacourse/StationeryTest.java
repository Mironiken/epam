package com.epam.javacourse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Period;

import static org.junit.Assert.*;

/**
 * Created on 24.02.2017.
 */
public class StationeryTest {
    @Test
    public void testThatDifferentStationeryIsNotEqual(){
        Stationery that = new Stationery(10, Period.ofYears(1), StationaryName.Pen);
        Stationery other = new Stationery(12, Period.ofYears(1), StationaryName.Pen);
        assertFalse(that.equals(other));
    }
    @Test
    public void testThatEqualStationeriesIsEqual(){
        Stationery that = new Stationery(10, Period.ofYears(1), StationaryName.Pen);
        Stationery other = new Stationery(10, Period.ofYears(1), StationaryName.Pen);
        assertTrue(that.equals(other));
    }
    @Test
    public void testThatEqualStationaryHaveEqualHashCode(){
        Stationery that = new Stationery(10, Period.ofYears(1), StationaryName.Pen);
        Stationery other = new Stationery(10, Period.ofYears(1), StationaryName.Pen);
        assertTrue(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatDifferentStationaryHaveDifferentHashCode(){
        Stationery that = new Stationery(10, Period.ofYears(1), StationaryName.Pen);
        Stationery other = new Stationery(12, Period.ofYears(1), StationaryName.Pen);
        assertFalse(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatOneStationaryHasEqualHashCode(){
        Stationery that = new Stationery(10, Period.ofYears(1), StationaryName.Pen);
        assertTrue(that.hashCode() == that.hashCode());
    }
}