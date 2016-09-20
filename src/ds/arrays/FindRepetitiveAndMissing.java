package ds.arrays;


public class FindRepetitiveAndMissing {

    public static void findRepetitiveAndMissing(int a[]) {

        if(a == null || a.length == 0) return;
        int s = 0;
        int e = a.length;

        while(s < e) {
            if(a[Math.abs(a[s])-1] > 0) {
                a[Math.abs(a[s])-1] = -a[Math.abs(a[s])-1];
            }
            else {
                System.out.println("Repeating element is " + Math.abs(a[s]));
            }
            s++;
        }
        s = 0;
        while(s < e) {
            if(a[s] > 0) {
                System.out.println("Missing element is " + (s+1));
                break;
            }
            s++;
        }
    }

    public static void main(String a[]) {
        FindRepetitiveAndMissing fm = new FindRepetitiveAndMissing();
        fm.findRepetitiveAndMissing(new int[]{1,2,3,5,5});
    }

}
