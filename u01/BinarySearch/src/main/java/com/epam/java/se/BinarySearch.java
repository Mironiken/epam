package com.epam.java.se;

/**
 * Created on 09.02.2017.
 */
public class BinarySearch {


    public static boolean recBinarySearch(int[] sortedArray, int searchVal){
        if (sortedArray.length == 0)
            return false;


        return recBinarySearch_Iter(sortedArray, 0, sortedArray.length, searchVal);

    }

    private static boolean recBinarySearch_Iter(int[] sortedArray, int begInclusive, int endExclusive, int searchVal) {
        int length = endExclusive - begInclusive;
        int middle = begInclusive + length/2;

        if (length == 1)
            return (sortedArray[begInclusive] == searchVal);

        if (sortedArray[middle] == searchVal)
            return true;

        if (sortedArray[middle] > searchVal)
            return (recBinarySearch_Iter(sortedArray, begInclusive, middle, searchVal));

        if (sortedArray[middle] < searchVal)
            return (recBinarySearch_Iter(sortedArray, middle + 1, endExclusive, searchVal));

        return false; //недостижимый код
    }

    public static boolean iterBinarySearch(int[] sortedArray, int searchVal){
        if (sortedArray.length == 0)
            return false;

        int begInclusive = 0;
        int endExclusive = sortedArray.length;

        for (int length = endExclusive - begInclusive;length>1;length = endExclusive - begInclusive){
            int middle = begInclusive + length/2;

            if (sortedArray[middle] == searchVal)
                return true;

            if (sortedArray[middle] > searchVal)
                endExclusive = middle;

            if (sortedArray[middle] < searchVal)
                begInclusive =  middle + 1;
        }

        return (sortedArray[begInclusive] == searchVal);
    }


}
