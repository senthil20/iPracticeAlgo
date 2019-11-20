package Java;

import java.util.StringTokenizer;

class IntegerNode {
    int id;
    IntegerNode(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerNode that = (IntegerNode) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 1;
        // return id;
    }
}

public class OnlineTest /*implements Runnable*/{
    /*int x;
    int y;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++)
            synchronized (this) {
                x = 12;
                y = 12;
            }
        System.out.print(x + " : " + y);
    }*/



    //group on
    static int count = 0;
    public static void getSum(int A[], int key, int sum, int index) {
        if (index > A.length - 1) {
            if (sum >= key) {
                count++;
            }
            return;
        }
        getSum(A, key, sum + A[index], index + 1);
        getSum(A, key, sum , index + 1);
    }

    public static void findTargetSumSubsets(int[] input, int target, String ramp, int index) {

        if(index > (input.length - 1)) {
            if(getSum(ramp) >= target) {
                System.out.print("Im in");
            }
            return;
        }
        //First recursive call going ahead selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp + input[index] + token, index + 1);
        //Second recursive call going ahead WITHOUT selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp, index + 1);
    }
    private static final String token = " ";

    private static int getSum(String intString) {
        int sum = 0;
        StringTokenizer sTokens = new StringTokenizer(intString, token);
        while (sTokens.hasMoreElements()) {
            sum += Integer.parseInt((String) sTokens.nextElement());
        }
        return sum;
    }


    public static void main(String a[]) {
        int [] n =  {1, 5, 9, 2, 3};
        OnlineTest.findTargetSumSubsets(n, 16, "", 0);
        OnlineTest.getSum(new int[]{1, 5, 9, 2, 3}, 16, 0, 0);
        System.out.print(count);

        IntegerNode i1 = new IntegerNode(3);
        IntegerNode i2 = new IntegerNode(3);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        /*OnlineTest test = new OnlineTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
*/
    }
}
