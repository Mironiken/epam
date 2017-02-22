package com.epam.java.se;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created on 11.02.2017.
 */
public class MergeSortTest {
    @Test
    public void sort() throws Exception {
        int[] testArray1 = new int[]{};
        int[] testArray2 = new int[]{1};
        int[] testArray3 = new int[]{1, 2};
        int[] testArray4 = new int[]{2, 1};
        int[] testArray5 = new int[]{1, 3, 2};
        int[] testArray6 = new int[]{1, 3, 3, 2};
        int[] testArray7 = new int[]{1, 2, 3, 5, -2};
        int[] testArray8 = new int[]{9, 2, 4, 3, 5, 7, 6, 8, 1};

        int[] sortedArray1 = MergeSort.sort(testArray1);
        int[] sortedArray2 = MergeSort.sort(testArray2);
        int[] sortedArray3 = MergeSort.sort(testArray3);
        int[] sortedArray4 = MergeSort.sort(testArray4);
        int[] sortedArray5 = MergeSort.sort(testArray5);
        int[] sortedArray6 = MergeSort.sort(testArray6);
        int[] sortedArray7 = MergeSort.sort(testArray7);
        int[] sortedArray8 = MergeSort.sort(testArray8);

        Arrays.sort(testArray1);
        Arrays.sort(testArray2);
        Arrays.sort(testArray3);
        Arrays.sort(testArray4);
        Arrays.sort(testArray5);
        Arrays.sort(testArray6);
        Arrays.sort(testArray7);
        Arrays.sort(testArray8);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray1[i] == sortedArray1[i]);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray2[i] == sortedArray2[i]);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray3[i] == sortedArray3[i]);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray4[i] == sortedArray4[i]);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray5[i] == sortedArray5[i]);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray6[i] == sortedArray6[i]);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray7[i] == sortedArray7[i]);

        for (int i = 0; i < testArray1.length; i++)
            assertTrue(testArray8[i] == sortedArray8[i]);

        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int randLength = rand.nextInt(1000);
            System.out.println(randLength);
            int[] randArr = new int[randLength];
            for (int val: randArr) {
                val = rand.nextInt();
            }
            int[] sortedRandArr = MergeSort.sort(randArr);

            Arrays.sort(randArr);

            for (int j = 0; j < sortedRandArr.length; j++)
                assertTrue(sortedRandArr[j] == randArr[j]);

        }
    }


}