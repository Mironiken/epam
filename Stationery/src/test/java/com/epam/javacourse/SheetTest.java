package com.epam.javacourse;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 26.02.2017.
 */
public class SheetTest {
    @Test
    public void testThatDifferentSheetsIsNotEqual(){
        Sheet that = new Sheet(10.5);
        Sheet other = new Sheet(11);
        assertFalse(that.equals(other));
    }
    @Test
    public void testThatEqualSheetsIsEqual(){
        Sheet that = new Sheet(10.5);
        Sheet other = new Sheet(10.5);
        assertTrue(that.equals(other));
    }
    @Test
    public void testThatEqualSheetsHaveEqualHashCode(){
        Sheet that = new Sheet(10.5);
        Sheet other = new Sheet(10.50);
        assertTrue(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatDifferentSheetsHaveDifferentHashCode(){
        Sheet that = new Sheet(10.5);
        Sheet other = new Sheet(11);
        assertFalse(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatOneSheetHasEqualHashCode(){
        Sheet that = new Sheet(10.5);
        assertTrue(that.hashCode() == that.hashCode());
    }
}