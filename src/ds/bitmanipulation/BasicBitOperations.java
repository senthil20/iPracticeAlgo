package ds.bitmanipulation;

/**
 * Created by senthil on 17/9/16.
 */
public class BasicBitOperations {

    //check kth bit is set or not
    public boolean isKthBitSet(int n, int k) {

        if(n < 1) return false;

        return (n & (1 << k-1)) > 0;
    }

    public int setBit(int n, int k) {

        return n | 1 << k - 1;

    }

    public int clearBit(int n, int k) {

        int t = 5;
        int mask = ~t;
        n = n & mask;
        return n;
    }




    public static void main(String a[]) {
        BasicBitOperations bo = new BasicBitOperations();
        //System.out.println(bo.isKthBitSet(5, 2));
        //bo.setBit(0, 6);
        //bo.clearBit(240, 5);
        System.out.println(Integer.toBinaryString(43261596));
    }
}
