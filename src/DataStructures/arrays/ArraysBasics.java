package DataStructures.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by senthil on 10/8/16.
 */
public class ArraysBasics {

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {

        long maxTotal = 0;
        long newTotal = 0;
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();

        for(int i =0; i < a.size(); i++) {

            if(a.get(i) >=0) {
                newTotal = newTotal + a.get(i);
                newList.add(a.get(i));
            }
            else {
                if(maxTotal < newTotal || ((maxTotal == newTotal) && newList.size() > maxList.size())) {
                    maxTotal = newTotal;
                    maxList = newList;
                }
                newTotal = 0;
                newList = new ArrayList<>();
            }
        }
        return maxList;
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

        int totalStep = 0;
        int currentX = X.get(0);
        int currentY = Y.get(0);
        for (int i = 0 ; i < X.size(); i++) {
            totalStep += Math.max(Math.abs(currentX - X.get(i) ), Math.abs(currentY - Y.get(i)));
            currentX = X.get(i);
            currentY = Y.get(i);
        }
        return totalStep;
    }

    public int[] plusOne(int[] digits) {

        int s = 0;
        int e = digits.length - 1;
        int r = 1;
        int t = 0;
        while(s <= e) {
            t = digits[e] + r;
            if(t < 10) {
                digits[e] = t;
                r = 0;
            }
            else {
                digits[e] = t % 10;
                r = t / 10;
            }
            e--;
        }
        if(t > 9) {
            digits = java.util.Arrays.copyOf(digits, digits.length + 1);
            System.arraycopy(digits, 0, digits, 1, digits.length -1);
            digits[s] = t/10;
        }

        return digits;
    }


    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        if(a == null || a.size() == 0) return new ArrayList<Integer>(0);

        int s = 0;
        int e = a.size() - 1;
        int r = 1;
        int t = 0;
        while(s <= e) {
            t = a.get(e) + r;

            if(t < 10) {
                a.set(e, t);
                r = 0;
            }
            else {
                a.set(e, t % 10);
                r = t/10;
            }
            e--;
        }
        if(t > 9) {
            a.add(s, t/10);
        }
        int st = 0;
        int en = a.size();
        while(st < en) {
            if(a.get(s) == 0) {
                a.remove(s);
            }
            else
                break;
            en--;
        }
        return a;
    }

    public int maxContiguousArray(int a[]) {
        if(a == null || a.length == 0) return -1;
        int sum = a[0];
        int max = a[0];

        int s = 1;
        int e = a.length;

        while(s < e) {
            sum = Math.max(sum+ a[s], a[s]);
            max = Math.max(max, sum);
            s++;
        }
        return max;
    }

    int addOne(int x)
    {
        return (-(~x));
    }

    public ArrayList<Integer> waveArray(ArrayList<Integer> a) {

        Collections.sort(a);
        int s = 1;
        int e = a.size();
        while(s < e) {
            swap(a, s, s-1);
            s = s + 2;
        }
        /*for (int i = 1; i < a.size(); i++) {
            if ((i % 2 == 1 && a.get(i) < a.get(i - 1)) ||
                    (i % 2 == 0 && a.get(i) > a.get(i - 1))) {
                swap(a, i, i-1);
            }
        }*/
        return a;
    }

    private void swap(ArrayList<Integer> a, int s, int t) {
        int temp = a.get(s);
        a.set(s, a.get(t));
        a.set(t, temp);
    }

    //solution is not ok
    private void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");
        for(i = 0; i < size; i++) {
            if(arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    public void shuffle(int a[], int s, int e) {

        if(e <= s)
            return;
        int m = (s + (e-s))/2;
        shuffle(a, s, m-1);
        shuffle(a, m+1, e);
        swap(a, s, e);
    }

    public void swap(int a[], int s, int e){
        int temp = a[s];
        a[s] = a[s];
        a[e] = temp;
    }

    public static void main(String args[]) {
        ArraysBasics a = new ArraysBasics();
        ArrayList<Integer> a1 = new ArrayList<>(0);
        /*ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        a1.add(1);a1.add(2);a1.add(4);a2.add(1);a2.add(3);a2.add(5);
        System.out.println(a.coverPoints(a1, a2));*/
       /* ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(756898537);
        a1.add(-1973594324);
        a1.add(-2038664370);
        a1.add(-184803526);
        a1.add(1424268980);
        a.maxset(a1);*/
        //a.plusOne(new int[]{9,9,9});

       /* a1.add(0);a1.add(0);a1.add(4);a1.add(4);a1.add(6);a1.add(0);a1.add(9);a1.add(6);a1.add(5);a1.add(1);*/
        /*a1.add(0);
        a1.add(9);
        a1.add(9);*/
        //0, 0, 4, 4, 6, 0, 9, 6, 5, 1
        //a.plusOne(a1);
        /*int a1[] = new int[]{1,2,3};
        a1 = java.util.ArraysBasics.copyOf(a1, a1.length+1);
        System.out.println(a1);
        System.arraycopy(a1, 0, a1, 1, a1.length-1);*/
        //a.maxContiguousArray(new int[]{-2,-5,6,-2,-3,1,5,-6});
        //System.out.println(a.addOne(199));
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);

        for(int val : a.waveArray(list)){
            System.out.print(val + " ");
        }*/
        //a.printRepeating(new int[]{1,2,3,6,2,1,3}, 7);
        a.shuffle(new int[]{5,2,3,4,7,1,10,12}, 0, 8);
        System.out.println(a);
    }
}
