package com.epam.java.se;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Никита Мирошниченко on 04.02.2017.
 */
public class IntBitTest {
    @Test
    public void add() throws Exception {
        IntBit set = new IntBit();
        assertFalse(set.contains(0));
        assertFalse(set.contains(64));
        assertFalse(set.contains(23463675));
        assertFalse(set.contains(Integer.MAX_VALUE));
        set.add(0);
        set.add(1);
        set.add(-1);
        set.add(63);
        set.add(64);
        set.add(65);
        set.add(0);
        set.add(1);
        set.add(-1);
        set.add(63);
        set.add(64);
        set.add(23463675);
        set.add(Integer.MAX_VALUE);
        assertTrue(set.contains(Integer.MAX_VALUE));
        assertTrue(set.contains(0));
        assertTrue(set.contains(1));
        assertTrue(set.contains(63));
        assertTrue(set.contains(64));
        assertTrue(set.contains(65));
        assertTrue(set.contains(23463675));
    }

    @Test
    public void remove() throws Exception {
        IntBit set = new IntBit();
        set.add(0);
        set.add(1);
        set.add(-1);
        set.add(63);
        set.add(64);
        set.add(65);
        set.add(23463675);
        set.add(Integer.MAX_VALUE);
        assertTrue(set.contains(0));
        assertTrue(set.contains(1));
        assertTrue(set.contains(63));
        assertTrue(set.contains(64));
        assertTrue(set.contains(65));
        assertTrue(set.contains(23463675));
        assertTrue(set.contains(Integer.MAX_VALUE));
        set.remove(0);
        set.remove(1);
        set.remove(-1);
        set.remove(63);
        set.remove(64);
        set.remove(65);
        set.remove(23463675);
        set.remove(Integer.MAX_VALUE);
        assertFalse(set.contains(Integer.MAX_VALUE));
        assertFalse(set.contains(0));
        assertFalse(set.contains(1));
        assertFalse(set.contains(63));
        assertFalse(set.contains(64));
        assertFalse(set.contains(65));
        assertFalse(set.contains(23463675));
        set.remove(0);
        set.remove(1);
        set.remove(-1);
        set.remove(63);
        set.remove(64);
        set.remove(65);
        int lo = 5000_000;
        int hi = lo + 70;
        for (int i = lo; i < hi; i++) {
            set.add(i);
            assertTrue(set.contains(i));
        }
        for (int i = lo; i < hi; i++){
            set.remove(i);
            assertFalse(set.contains(i));
        }
    }

    @Test
    public void contains() throws Exception {
        IntBit set = new IntBit();
        assertFalse(set.contains(0));
        assertFalse(set.contains(64));
        assertFalse(set.contains(23463675));
        assertFalse(set.contains(Integer.MAX_VALUE));
        int lo = 5000_000;
        int hi = lo + 1400;
        for (int i = lo; i < hi; i+=2) {
            set.add(i);
            assertTrue(set.contains(i));
        }
        set.add(Integer.MAX_VALUE);
        assertTrue(set.contains(Integer.MAX_VALUE));

    }

    @Test
    public void union() throws Exception {
        IntBit set1 = new IntBit();
        IntBit set2 = new IntBit();

        set1.add(0);
        set1.add(68);
        set2.add(50);
        set2.add(Integer.MAX_VALUE);

        IntBit setUnion = set1.union(set2);

        assertTrue(setUnion.contains(0));
        assertTrue(setUnion.contains(68));
        assertTrue(setUnion.contains(50));
        assertTrue(setUnion.contains(Integer.MAX_VALUE));
        assertFalse(setUnion.contains(1));
        assertFalse(setUnion.contains(120));
        assertFalse(setUnion.contains(Integer.MAX_VALUE - 1));
    }

    @Test
    public void intersection() throws Exception {
        IntBit set1 = new IntBit();
        IntBit set2 = new IntBit();

        set1.add(0);
        set1.add(68);

        IntBit nullSetIntersect = set2.intersection(set1);
        IntBit setNullIntersect = set1.intersection(set2);

        assertFalse(nullSetIntersect.contains(0));
        assertFalse(nullSetIntersect.contains(50));
        assertFalse(nullSetIntersect.contains(68));
        assertFalse(nullSetIntersect.contains(Integer.MAX_VALUE));

        assertFalse(setNullIntersect.contains(0));
        assertFalse(setNullIntersect.contains(50));
        assertFalse(setNullIntersect.contains(68));
        assertFalse(setNullIntersect.contains(Integer.MAX_VALUE));

        set2.add(50);
        //set2.add(Integer.MAX_VALUE);

        set1.add(1);
        set2.add(1);
        set1.add(63);
        set2.add(63);
        //set1.add(Integer.MAX_VALUE - 1);
        //set2.add(Integer.MAX_VALUE - 1);

        IntBit setIntersection = set1.intersection(set2);

        assertTrue(setIntersection.contains(1));
        assertTrue(setIntersection.contains(63));
        //assertTrue(setIntersection.contains(Integer.MAX_VALUE - 1));

        assertFalse(setIntersection.contains(0));
        assertFalse(setIntersection.contains(50));
        assertFalse(setIntersection.contains(68));
        //assertFalse(setIntersection.contains(Integer.MAX_VALUE));
    }

    @Test
    public void difference() throws Exception {
        IntBit set1 = new IntBit();
        IntBit set2 = new IntBit();

        set1.add(0);
        set1.add(1);
        set1.add(63);
        set1.add(64);
        set1.add(3875311);
        //set1.add(Integer.MAX_VALUE - 1);
        //set1.add(Integer.MAX_VALUE);

        IntBit setNullDifference = set1.difference(set2);
        IntBit nullSetDifference = set2.difference(set1);

        assertTrue(setNullDifference.contains(0));
        assertTrue(setNullDifference.contains(1));
        assertTrue(setNullDifference.contains(63));
        assertTrue(setNullDifference.contains(64));
        assertTrue(setNullDifference.contains(3875311));
        assertFalse(setNullDifference.contains(Integer.MAX_VALUE-1));
        assertFalse(setNullDifference.contains(Integer.MAX_VALUE));

        assertTrue(nullSetDifference.contains(0));
        assertTrue(nullSetDifference.contains(1));
        assertTrue(nullSetDifference.contains(63));
        assertTrue(nullSetDifference.contains(64));
        assertTrue(nullSetDifference.contains(3875311));
        assertFalse(nullSetDifference.contains(Integer.MAX_VALUE-1));
        assertFalse(nullSetDifference.contains(Integer.MAX_VALUE));

        for(int i = 7765; i<7765+65; i++){
            set1.add(i);
            set2.add(i);
        }




        IntBit set1Set2Difference = set1.difference(set2);

        for(int i = 7765; i<7765+65; i++){
            assertFalse(set1Set2Difference.contains(i));
        }

        assertTrue(set1Set2Difference.contains(0));
        assertTrue(set1Set2Difference.contains(1));
        assertTrue(set1Set2Difference.contains(63));
        assertTrue(set1Set2Difference.contains(64));
        assertTrue(set1Set2Difference.contains(3875311));
        assertFalse(set1Set2Difference.contains(Integer.MAX_VALUE-1));
        assertFalse(set1Set2Difference.contains(Integer.MAX_VALUE));

        IntBit set2Set1Difference = set1.difference(set2);

        for(int i = 7765; i<7765+65; i++){
            assertFalse(set2Set1Difference.contains(i));
        }

        assertTrue(set2Set1Difference.contains(0));
        assertTrue(set2Set1Difference.contains(1));
        assertTrue(set2Set1Difference.contains(63));
        assertTrue(set2Set1Difference.contains(64));
        assertTrue(set2Set1Difference.contains(3875311));
        assertFalse(set2Set1Difference.contains(Integer.MAX_VALUE-1));
        assertFalse(set2Set1Difference.contains(Integer.MAX_VALUE));
    }

    @Test
    public void isSubsetOf() throws Exception {
        IntBit set1 = new IntBit();
        IntBit set2 = new IntBit();

        set1.add(0);
        set1.add(1);
        set1.add(63);
        set1.add(64);
        set1.add(3875311);
        set1.add(Integer.MAX_VALUE - 1);
        set1.add(Integer.MAX_VALUE);

        assertFalse(set1.isSubsetOf(set2));
        assertTrue(set2.isSubsetOf(set1));

        for(int i = 7765; i<7765+65; i++){
            set1.add(i);
            set2.add(i);
        }

        assertFalse(set1.isSubsetOf(set2));
        assertTrue(set2.isSubsetOf(set1));

        set2.add(0);
        set2.add(1);
        set2.add(63);
        set2.add(64);
        set2.add(3875311);
        set2.add(Integer.MAX_VALUE - 1);
        set2.add(Integer.MAX_VALUE);

        assertTrue(set1.isSubsetOf(set2));
        assertTrue(set2.isSubsetOf(set1));

        set1.remove(0);

        assertTrue(set1.isSubsetOf(set2));
        assertFalse(set2.isSubsetOf(set1));
    }

}
