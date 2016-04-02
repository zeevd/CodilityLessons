package main.java.Codility;

public class Lesson4 {

    public int frogRiverOne(int X, int[] A) {
        if (A==null || A.length < 1 || X < 1) return -1;
        boolean[] B = new boolean[X];
        int falseCount = B.length;

        for (int i=0; i<A.length; i++){
            if (B[A[i]-1] == false){
                B[A[i]-1] = true;
                falseCount--;
                if (falseCount == 0) return i;
            }
        }
        return -1;
    }

    public static int permCheck(int[] A) {
        if (A == null || A.length == 0) return 0;

        boolean[] permTracker = new boolean[A.length + 1];
        permTracker[0] = true;

        for (int a : A) {
            if (a > A.length || permTracker[a] == true) return 0;
            permTracker[a] = true;
        }
        for (boolean p : permTracker) {
            if (p == false) return 0;
        }

        return 1;

    }

    public int missingInteger(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();

        int smallest = Integer.MAX_VALUE, largest = 1;

        for (int a : A){
            if (a > 0){
                if (a < smallest) smallest=a;
                if (a > largest) largest=a;
                set.add(a);
            }
        }

        if (smallest > 1){
            for (int i=1; i<smallest; i++)
                if (set.contains(i) == false) return i;
        }
        else{
            if (largest == Integer.MAX_VALUE) largest--;
            for (int i=1; i<=largest+1; i++){
                if (set.contains(i) == false) return i;
            }
        }
        return -1;
    }

    public int[] maxCounters(int N, int[] A) {
        int boost=0, max=0, CTR_MAX = N+1;
        int[] C = new int[N];

        for (int op : A){
            if (op == CTR_MAX){
                boost = max;
            }
            else{
                if (C[op-1] < boost) C[op-1] = boost;
                C[op-1] += 1;
                if (C[op-1] > max) max = C[op-1];
            }
        }
        for (int i=0; i<C.length; i++){
            if (C[i] < boost) C[i] = boost;
        }
        return C;
    }


}
