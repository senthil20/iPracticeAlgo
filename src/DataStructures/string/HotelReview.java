package DataStructures.string;

import java.util.*;


public class HotelReview {

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || A.length() == 0 || B == null || B.size() == 0) return result;

        Set<String> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        String[] input = A.split("_");
        for (String val : input) set.add(val);

        for (int i = 0; i < B.size(); i++) {
            String[] reviews = B.get(i).split("_");

            if (!map.containsKey(i)) map.put(i, 0);

            for (String review : reviews) {
                if (set.contains(review)) {
                    int temp = map.get(i);
                    map.put(i, temp + 1);
                }
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : list) {
            result.add(entry.getKey());
        }
        return result;
    }

    public static void main(String ar[]) {

        String s = "cool_ice_wifi";
        ArrayList<String> input = new ArrayList<>();
        input.add("water_is_cool");
        input.add("cold_ice_drink");
        input.add("cool_wifi_speed");
        new HotelReview().solve(s, input);

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
