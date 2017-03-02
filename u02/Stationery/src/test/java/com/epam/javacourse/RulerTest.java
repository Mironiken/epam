package com.epam.javacourse;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 26.02.2017.
 */
public class RulerTest {
    @Test
    public void testThatDifferentRulersIsNotEqual(){
        Ruler that = new Ruler(10.5, 12);
        Ruler other = new Ruler(11, 11);
        assertFalse(that.equals(other));
    }
    @Test
    public void testThatEqualRulersIsEqual(){
        Ruler that = new Ruler(10.5, 12);
        Ruler other = new Ruler(10.5, 12);
        assertTrue(that.equals(other));
    }
    @Test
    public void testThatEqualRulersHaveEqualHashCode(){
        Ruler that = new Ruler(10.5, 12);
        Ruler other = new Ruler(10.50, 12);
        assertTrue(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatDifferentRulersHaveDifferentHashCode(){
        Ruler that = new Ruler(10.5, 12);
        Ruler other = new Ruler(11, 12);
        assertFalse(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatOneRulerHasEqualHashCode(){
        Ruler that = new Ruler(10.5, 12);
        assertTrue(that.hashCode() == that.hashCode());
    }

}