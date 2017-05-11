package ds.arrays;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Arrays;

public class FindLargest {

    public ArrayList<String> removeDuplicates(List<String> input) {

        if (input == null || input.size() == 0) return new ArrayList<>();

        if (input.size() == 1) return new ArrayList<>(input);

        ArrayList<String> result = new ArrayList<>();

        Collections.sort(input, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        int s = 1;
        int e = input.size();

        while (s < e) {
            if (input.get(s - 1).equals(input.get(s))) {
                s++;
                continue;
            }

            result.add(input.get(s - 1));
            s++;
        }
        if (e > 1) result.add(input.get(e - 1));
        return result;
    }

    /**
     Given a list of non negative integers, arrange them such that they form the largest number.
     For example:
     Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
     Note: The result may be very large, so you need to return a string instead of an integer.
     */

    public String largestNumber(final List<Integer> a) {
        if (a == null || a.size() == 0) return "";
        String[] str = new String[a.size()];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.size(); i++) {
            str[i]  = String.valueOf(a.get(i));
        }
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                System.out.println("s1 is: " + s1 + "  " + "s2 is: " + s2);
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        Arrays.binarySearch(new int[]{2,4,1,10}, 10);

        for (String s : str) sb.append(s);

        while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String a[]) {
        FindLargest fl = new FindLargest();
        List<Integer> llist = new ArrayList<>();
        llist.add(5);llist.add(7);llist.add(6);llist.add(2);llist.add(9);llist.add(1);
        System.out.print(fl.largestNumber(llist));
        List<String> list = new ArrayList<>();
        list.add("Hi");
        //list.add("Hi");
       /* list.add("Hey");
        list.add("Hi");
        list.add("Hello");
        list.add("Hey");*/
        //fl.removeDuplicates(list);
    }
}
