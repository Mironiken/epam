package com.epam.java.se;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 10.02.2017.
 */
public class BinarySearchTest {

    @Test
    public void iterBinarySearch() throws Exception {
        int[] testAr = new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50};
        assertTrue(BinarySearch.iterBinarySearch(testAr, 20));
        assertTrue(BinarySearch.iterBinarySearch(testAr, 50));
        assertTrue(BinarySearch.iterBinarySearch(testAr,  24));
        assertTrue(BinarySearch.iterBinarySearch(testAr, -16));
        assertTrue(BinarySearch.iterBinarySearch(testAr, -9));
        assertFalse(BinarySearch.iterBinarySearch(testAr, 19));
        assertFalse(BinarySearch.iterBinarySearch(testAr, 90));
        assertFalse(BinarySearch.iterBinarySearch(testAr, -19));
        assertFalse(BinarySearch.iterBinarySearch(testAr, 1));
        testAr = new int[]{7};
        assertFalse(BinarySearch.iterBinarySearch(testAr, 8));
        assertTrue(BinarySearch.iterBinarySearch(testAr, 7));
        testAr = new int[]{};
        assertFalse(BinarySearch.iterBinarySearch(testAr, 19));
    }

    @Test
    public void recBinarySearch() throws Exception {
        int[] testAr = new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50};
        assertTrue(BinarySearch.recBinarySearch(testAr, 20));
        assertTrue(BinarySearch.recBinarySearch(testAr, 50));
        assertTrue(BinarySearch.recBinarySearch(testAr,  24));
        assertTrue(BinarySearch.recBinarySearch(testAr, -16));
        assertTrue(BinarySearch.recBinarySearch(testAr, -9));
        assertFalse(BinarySearch.recBinarySearch(testAr, 19));
        assertFalse(BinarySearch.recBinarySearch(testAr, 90));
        assertFalse(BinarySearch.recBinarySearch(testAr, -19));
        assertFalse(BinarySearch.recBinarySearch(testAr, 1));
        testAr = new int[]{7};
        assertFalse(BinarySearch.recBinarySearch(testAr, 8));
        assertTrue(BinarySearch.recBinarySearch(testAr, 7));
        testAr = new int[]{};
        assertFalse(BinarySearch.recBinarySearch(testAr, 19));
    }

}