package DataStructures.arrays;


public class PrintTriangle {

    public void printTriangle(int K, int pos, int totSpace, String prev, int count) {
        if (K == 1) {
            System.out.println(prev);
            return;
        }
        print(totSpace, pos, prev);
        count++;
        printTriangle(K - 1, pos - 1, totSpace, count + prev + count, count);
        print(totSpace, pos, prev);
    }

    public void print(int totSpace, int pos, String prev) {
        for (int i = 0; i < totSpace; i++) {
            if (i == pos) {
                System.out.print(prev);
                i = i + prev.length();
                continue;
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String a[]) {
        PrintTriangle pt = new PrintTriangle();
        int K = 9;
        int space = K * 2 - 1;
        int pos = space / 2;
        pt.printTriangle(K, pos, space, "1", 1);
    }
}
