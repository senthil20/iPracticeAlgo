package ds.string;

import java.util.*;

public class HotelReview {

    public static void main(String ar[]) {

        /*Scanner sc = new Scanner(System.in);

        String reviews = sc.nextLine();
        int noOfReviews = sc.nextInt();
        Map<Integer, List<String>> map = new HashMap<>();


        for (int i = 0; i < noOfReviews; i++) {
            int hId = sc.nextInt();
            sc.nextLine();
            String hReview = sc.nextLine();
            if (map.containsKey(hId)) {
                map.get(hId).add(hReview);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(hReview);
                map.put(hId, list);
            }
        }*/
        String reviews = "breakfast beach citycenter location metro view staff price";
        String[] reviewArr = reviews.split(" ");
        Set<String> set = new TreeSet<>();

        for (String temp : reviewArr) set.add(temp.toLowerCase());

        Map<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("This hotel has a nice view of the citycenter. The location is perfect.");
        list.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
        list.add("They said I could't take my dog and there were other guests with dogs! That is not fair!");
        map.put(1, list);

        List<String> list2 = new ArrayList<>();
        list2.add("The breakfast is ok. Regarding the location, it is quite far from citycenter but price is cheap so it is worth.");
        list2.add("Very friendly staff and goof cost-benefit ratio. Its location is a bit far from citycenter.");
        map.put(2, list2);

        //String temp = "The breakfast is ok. Regarding the location, it is quite far from citycenter but price is cheap so it is worth in citycenter.";
        /*int count = 0;
        int index = temp.indexOf("citycenter");
        while(index >= 0) {
            index = temp.indexOf("citycenter", index+1);
            count++;
        }*/
        Map<Integer, Integer> result = new TreeMap<>();
        for (Map.Entry entry : map.entrySet()) {
            int count = 0;
            List<String> listStr = (List<String>)entry.getValue();
            for (String strList : listStr) {
                String[] listArr = strList.split(" ");
                for (String str : listArr) {
                    str = str.replaceAll("[$,.!?]", "").toLowerCase();
                    if (set.contains(str)) {
                        count++;
                    }
                }
            }
            result.put((Integer) entry.getKey(), count);
        }

        List<Map.Entry<Integer, Integer>> listToSort = new ArrayList<>(result.entrySet());

        Collections.sort(listToSort, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                else
                    return o2.getValue() - o1.getValue();
            }
        });
         System.out.println(listToSort);
    }
}
