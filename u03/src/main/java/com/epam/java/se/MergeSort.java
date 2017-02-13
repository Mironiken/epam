package com.epam.java.se;

/**
 * Created on 10.02.2017.
 */
public class MergeSort {
    public static int[] sort(int[] unsortedAr) {
        int[] res = unsortedAr.clone();
        if (res.length < 2) {
            return res;
        }
        int begInclusive1;
        int endExclusive1;
        int begInclusive2;
        int endExclusive2;
        int[] arVariable;


        for (int i = 1; i < unsortedAr.length; i *= 2) {
            for (int j = 0; j + i < unsortedAr.length; j += 2 * i) {
                begInclusive1 = j;
                endExclusive1 = j + i;
                begInclusive2 = j + i;
                endExclusive2 = (j + 2 * i) > unsortedAr.length ? unsortedAr.length : (j + 2 * i);
                arVariable = merge(unsortedAr, begInclusive1, endExclusive1, begInclusive2, endExclusive2);
                for (int k = 0; k < arVariable.length; k++)
                    res[begInclusive1 + k] = arVariable[k];
            }
        }
        return res;
    }
    private static int[] merge(int[] array, int begInclusive1, int endExclusive1, int begInclusive2, int endExclusive2){
        int[] res = new int[endExclusive1 + endExclusive2 - begInclusive1 - begInclusive2];
        int i = begInclusive1;
        int j = begInclusive2;
        for (int k = 0;k<res.length; k++){
            if (i == endExclusive1){
                res[k] = array[j];
                j++;
            } else if (j == endExclusive2){
                res[k] = array[i];
                i++;
            }else if(array[j]>array[i]){
                res[k] = array[j];
                j++;
            }else if (array[i]>array[j]){
                res[k] = array[i];
                i++;
            }
        }
        return res;
    }
}
