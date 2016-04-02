package main.java.Codility;

public class Lesson2 {

    public int[] cyclicRotation(int[] A, int K) {
        if (A==null || A.length<2 || K<1) return A;
        int N = A.length;
        K = K%N;

        rotate(A,0,(N-1-K));
        rotate(A,(N-K),(N-1));
        rotate(A,0,(N-1));
        return A;
    }
    static void rotate(int[] A, int iStart, int iEnd){
        while (iStart < iEnd){
            int temp = A[iStart];
            A[iStart] = A[iEnd];
            A[iEnd] = temp;
            iStart++; iEnd--;
        }
    }


    public int oddOccurencesInArray(int[] A) {
        if (A == null || A.length < 1) return -1;
        int result = 0;

        for (int a : A) {
            result ^= a;
        }

        return result;
    }
}
