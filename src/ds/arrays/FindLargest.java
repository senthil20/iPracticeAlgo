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

    public int findLargest(int a[]) {

        if(a == null || a.length == 0) return 0;
        String[] s = new String[a.length];
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < a.length; i++) {
            s[i] = String.valueOf(a[i]);
        }

        Arrays.sort(s, new Comparator<String>(){
            public int compare(String s1, String s2) {
                System.out.println("S1 is " + s1 + "..." + " S2 is" + s2);
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for(String str : s) {
            sb.append(str);
        }

        while(sb.charAt(0) =='0' && sb.length() > 1)
            sb.deleteCharAt(0);

        return Integer.parseInt(sb.toString());
    }

    private static String getOnDemandFromDate(int monthOffSet) {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            if (monthOffSet > 0){
                cal.add(Calendar.MONTH,-monthOffSet);
            } else {
                cal.add(Calendar.MONTH,-24);
            }
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
            String onDemandDefaultFromDate = dateFormatter.format(cal.getTime());
            return onDemandDefaultFromDate;

        } catch (Exception e) {

        }
        return "";
    }

    public static void main(String a[]) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
        String onDemandToDate = dateFormatter.format(new java.util.Date());


        System.out.println(FindLargest.getOnDemandFromDate(24));
        FindLargest fl = new FindLargest();
        //fl.findLargest(new int[]{3, 30, 34, 5, 9});
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
