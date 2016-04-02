package main.java.Codility;

public class Lesson1 {

    public int binaryGap(int N) {
        int count=0, maxCount=0;
        while (N>0 && N%2==0) N/=2;

        while (N>0){
            int current = N%2==0?0:1;
            N/=2;

            if (current == 0){
                count++;
            }
            else{
                maxCount = Math.max(count, maxCount);
                count=0;
            }
        }
        return maxCount;
    }
}
