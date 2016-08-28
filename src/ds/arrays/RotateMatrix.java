package ds.arrays;

/**
 * Created by senthil on 24/8/16.
 */
public class RotateMatrix {

    public static void rotateMatrix90(int a[][]) {
        if(a == null || a.length == 0) return;

        int rL= a.length;
        int cL = a[0].length;

        //transpose
        for(int i=0; i < rL; i++) {
            for(int j = i+1; j < cL; j++) {
                int t = a[j][i];
                a[j][i] = a[i][j];
                a[i][j] = t;
            }
        }
        //swap columns
        for(int j=0; j < cL/2; j++) {
            for(int i = 0; i < rL; i++) {
                int t = a[i][j];
                a[i][j] = a[i][cL-j-1];
                a[i][cL-j-1] = t;
            }
        }
    }

    public static void rotateOneElement(int a[][]) {
        if(a == null || a.length == 0) return;

        int rL = a.length;
        int cL = a[0].length;
        int T = 0;
        int R = cL - 1;
        int B = rL - 1;
        int L = 0;
        int next = 0;
        int temp = 0;

        while(T <= B && L <= R) {
            if(next == 0) {
                temp = a[T+1][T];
                for(int i = L; i <= R; i++) {
                    int t = a[T][i];
                    a[T][i] = temp;
                    temp = t;
                }
                T++;
            }
            else if(next == 1) {
                for(int i = T; i <= B; i++) {
                    int t = a[i][R];
                    a[i][R] = temp;
                    temp = t;
                }
                R--;
            }
            else if(next == 2) {
                for(int i = R; i >= L; i--) {
                    int t = a[B][i];
                    a[B][i] = temp;
                    temp = t;
                }
                B--;
            }
            else if(next == 3) {
                for(int i = B; i >= T; i--) {
                    int t = a[i][L];
                    a[i][L] = temp;
                    temp = t;
                }
                L++;
            }
            next = (next + 1) % 4;

            int e = T;

            if((T == e) && ( B == e) && (L == e) && (R == e)) break;
        }
        System.out.println(a);
    }


    public static void main(String ar[]) {
        int a[][] = {
                {2,8,5,1,7},
                {9,12,10,11,6},
                {5,4,3,2,1},
                {8,1,2,10,9},
                {0,5,6,2,3}
        };
        //RotateMatrix.rotateMatrix90(a);
        RotateMatrix.rotateOneElement(a);
    }
}
