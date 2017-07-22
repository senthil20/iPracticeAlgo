package ds.string;

import java.util.*;


public class HotelReview {

    public static void main(String ar[]) {


        Set<String> set = new TreeSet<>();
        Map<Integer, Integer> result = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String reviews = sc.nextLine();
        String[] reviewArr = reviews.split(" ");
        for (String str : reviewArr) set.add(str.toLowerCase());

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int hotelId = sc.nextInt();
            sc.nextLine();
            String hotelReview = sc.nextLine();
            String[] review = hotelReview.split(" ");

            if (!result.containsKey(hotelId)) {
                result.put(hotelId, 0);
            }


            for (String rev : review) {
                rev = rev.replaceAll("[$.,?]", "").toLowerCase();
                if (set.contains(rev)) {
                    int temp = result.get(hotelId);
                    result.put(hotelId, temp + 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(result.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println(list);
    }
}
