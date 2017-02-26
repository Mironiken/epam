package com.epam.javacourse;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 26.02.2017.
 */
public class PencilTest {
    @Test
    public void testThatDifferentPencilsIsNotEqual(){
        Pencil that = new Pencil(10.5);
        Pencil other = new Pencil(11);
        assertFalse(that.equals(other));
    }
    @Test
    public void testThatEqualPencilsIsEqual(){
        Pencil that = new Pencil(10.5);
        Pencil other = new Pencil(10.5);
        assertTrue(that.equals(other));
    }
    @Test
    public void testThatEqualPencilsHaveEqualHashCode(){
        Pencil that = new Pencil(10.5);
        Pencil other = new Pencil(10.50);
        assertTrue(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatDifferentPencilsHaveDifferentHashCode(){
        Pencil that = new Pencil(10.5);
        Pencil other = new Pencil(11);
        assertFalse(that.hashCode() == other.hashCode());
    }
    @Test
    public void testThatOnePencilHasEqualHashCode(){
        Pencil that = new Pencil(10.5);
        assertTrue(that.hashCode() == that.hashCode());
    }

}