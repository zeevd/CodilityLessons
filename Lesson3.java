package main.java.Codility;

public class Lesson3 {

    public int frogJmp(int X, int Y, int D) {
        if (X<1 || Y<1 || D<1 || X>Y) return -1;
        double gap = (double) Y-X;
        int jumps =(int) (Math.ceil(gap/D));
        return jumps;
    }

    public int tapeEquilibrium(int[] A) {
        if (A == null || A.length < 2) return -1;
        int left = A[0], right = 0;
        for (int a : A) right += a;
        right -= A[0];
        int minDiff = Math.abs(left - right), diff;


        for (int i = 1; i < A.length; i++) {
            diff = Math.abs(left - right);
            if (diff < minDiff) minDiff = diff;
            if (minDiff == 0) return minDiff;
            left += A[i];
            right -= A[i];
        }
        return minDiff;
    }

    public int permMissingElem(int[] A) {
        long N = A.length;
        long expectedSum = (N+1)*(N+2)/2;
        long sum = 0;
        for (int a : A) sum+=a;
        return (int)(expectedSum-sum);
    }


}
