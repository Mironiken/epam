package com.epam.javacourse;

import org.junit.Test;

import java.time.Period;

import static org.junit.Assert.*;

/**
 * Created on 26.02.2017.
 */
public class StaplerTest {
    @Test
    public void testThatDifferentStaplersIsNotEqual(){
        Stapler that = new Stapler(10.5);
        Stapler other = new Stapler(11);
        assertFalse(that.equals(other));
    }
    @Test
    public void testThatEqualStaplersIsEqual(){
        Stapler that = new Stapler(10.5);
        Stapler other = new Stapler(10.5);
        assertTrue(that.equals(other));
    }
    @Test
    public void testThatEqualStaplersHaveEqualHashCode(){
        Stapler that = new Stapler(10.5);
        Stapler other = new Stapler(10.50);
        assertTrue(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatDifferentStaplersHaveDifferentHashCode(){
        Stapler that = new Stapler(10.5);
        Stapler other = new Stapler(11);
        assertFalse(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatOneStaplerHasEqualHashCode(){
        Stapler that = new Stapler(10.5);
        assertTrue(that.hashCode() == that.hashCode());
    }

}