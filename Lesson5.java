package main.java.Codility;

public class Lesson5 {

    public int passingCars(int[] A) {
        if (A==null || A.length < 1) return -1;

        int zeroCount=0, pairCount=0;

        for (int num : A){
            if (num == 0) zeroCount++;
            else if (num == 1){
                pairCount += zeroCount;
                if (pairCount > Math.pow(10,9)) return -1;
            }
            else return -1;
        }
        return pairCount;
    }

    public int countDiv(int A, int B, int K) {
        if (A<0 || B<0 || K<1) return -1;
        int result = (B/K) - (A/K);
        if (A%K == 0) result++;

        return result;
    }

    public int[] genomicRangeQuery(String S, int[] P, int[] Q) {
        if (S==null || S.length() < 1 || P == null || Q==null || P.length != Q.length) return null;
        int[] result = new int[P.length];
        int[][] count = new int[S.length()+1][4];
        for (int i=0; i<S.length(); i++){
            int addToIndex=-1;
            if (S.charAt(i) == 'A') addToIndex=0;
            if (S.charAt(i) == 'C') addToIndex=1;
            if (S.charAt(i) == 'G') addToIndex=2;
            if (S.charAt(i) == 'T') addToIndex=3;
            for (int j=0; j<4; j++){
                count[i+1][j] = count[i][j];
                if (j == addToIndex) count[i+1][j] += 1;
            }
        }

        for (int i=0; i<P.length; i++){
            int iStart = P[i];
            int iEnd = Q[i];
            for (int j=0; j<4; j++){
                if (count[iEnd+1][j] - count[iStart][j] > 0){
                    result[i] = j+1;
                    break;
                }
            }
        }
        return result;
    }

    public int minAvgTwoSlice(int[] A) {
        int iMin = -1;
        double minAvg = Integer.MAX_VALUE;

        for (int i=0; i<A.length-2; i++){
            double twoSliceAvg = (double) (A[i] + A[i+1]) / 2;
            double threeSliceAvg = (double) (A[i] + A[i+1] + A[i+2]) / 3;
            if (twoSliceAvg < minAvg || threeSliceAvg < minAvg){
                minAvg = Math.min(twoSliceAvg, threeSliceAvg);
                iMin = i;
            }
        }
        int twoSliceLast = A[A.length-2] + A[A.length-1];
        double twoSliceAvg = (double)twoSliceLast / 2;
        if (twoSliceAvg < minAvg){
            minAvg = twoSliceAvg;
            iMin = A.length-2;
        }
        return iMin;
    }

}
