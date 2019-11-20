package DataStructures.dp;

public class Staircase {

    static int stepPerms(int n) {
        if (n < 0) return 0;
        return stepPerms(n, new int[n + 1]);
    }

    static int stepPerms(int n, int[] mem) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (mem[n] == 0) {
            mem[n] = stepPerms(n - 1, mem) + stepPerms(n - 2, mem) + stepPerms(n - 3, mem);
        }
        return mem[n];
    }

    public static void main(String a[]) {
        int steps = stepPerms(3);
        System.out.println(steps);
    }
}
