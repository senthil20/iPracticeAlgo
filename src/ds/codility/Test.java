package ds.codility;

public class Test {

    public int solution(int[] A) {
        int minAverage = Integer.MAX_VALUE;
        int index = 0;
        int avg = 0;
        for (int i = 0; i < A.length - 1; i++) {
            avg = (A[i] + A[i + 1]) / 2 ;
            if (avg < minAverage) {
                minAverage = avg;
                index = i;
            }
        }
        for (int i = 0; i < A.length - 2; i++) {
            avg = (A[i] + A[i + 1] + A[i + 2]) / 3 ;
            if (avg < minAverage) {
                minAverage = avg;
                index = i;
            }
        }
        return index;
    }

    public static void main(String a[]) {
        Test t = new Test();
        System.out.println(t.solution(new int[]{4,2,2,5,1,5,8}));
    }
}
