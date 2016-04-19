package main.java.Codility;

import java.util.Arrays;
import java.util.HashSet;

public class Lesson6 {

    public int distinct(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int a : A) set.add(a);
        return set.size();
    }

    public int triangle(int[] A) {
        if (A==null || A.length < 3) return 0;
        Arrays.sort(A);

        for (int i=0; i<A.length-2; i++){
            if ((long)A[i] + (long)A[i+1] > A[i+2] && (long)A[i] + (long)A[i+2] > A[i+1]) return 1;
        }
        return 0;
    }

    public int maxProductOfThree(int[] A) {
        if (A==null || A.length < 3) return -1;
        Arrays.sort(A);
        int optionNeg = A[0]*A[1]*A[A.length-1];
        int optionPos = A[A.length-3]*A[A.length-2]*A[A.length-1];
        return Math.max(optionNeg, optionPos);
    }

    //TODO: NumberOfDiscIntersections
}
