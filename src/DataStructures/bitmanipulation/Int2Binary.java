package DataStructures.bitmanipulation;

/**
 * Created by senthil on 12/9/16.
 */
public class Int2Binary {

    public String bitManipulation(int a, String res) {

        if(a == 1) return String.valueOf(a);

        int rem = a % 2;
        int quo = a / 2;

        res = bitManipulation(quo, res);
        res += rem;
        return res;
    }
    public static void main(String a[]) {

        Int2Binary i2b = new Int2Binary();
        System.out.println(i2b.bitManipulation(43261596, new String()));
    }
}