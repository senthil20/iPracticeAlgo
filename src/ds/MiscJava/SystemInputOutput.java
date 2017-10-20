package ds.MiscJava;

import java.util.*;

/**
 * Created by User on 02-07-2017.
 */
public class SystemInputOutput {

    public static void main(String a[]) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String line = br.readLine();
        //int N = Integer.parseInt(line);
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String A = in.nextLine();
            String[] str = A.split(" ");
            int cities = Integer.parseInt(str[0]);
            int maxDeveloped = Integer.parseInt(str[1]);
            Map<Integer, List<Integer>> cityMap = new HashMap<>();
            for (int j = 0; j < cities; j++) {
                String cityAndPopulation = in.nextLine();
                String[] cityPopulation = cityAndPopulation.split(" ");
                int key = Integer.valueOf(cityPopulation[0]);
                int value = Integer.valueOf(cityPopulation[1]);

                if (cityMap.containsKey(key)) {
                    cityMap.get(key).add(value);
                } else {
                    List<Integer> cityAndPopulationList = new ArrayList<>();
                    cityAndPopulationList.add(value);
                    cityMap.put(key, cityAndPopulationList);
                }
            }
            int maxVotes = 0;
            int minVotes = 0;
            for (Map.Entry<Integer, List<Integer>> mapEntry : cityMap.entrySet()) {
                Integer key = mapEntry.getKey();
                List<Integer> value = mapEntry.getValue();
                if (key == 0) {
                    for (int val : value) maxVotes += val;
                }
                if (key == 1) {
                    Collections.sort(value);
                    for (int k = value.size() - 1; k >= 0; k--) {
                        if (maxDeveloped == 0) {
                            minVotes += value.get(k);
                        }
                        else {
                            maxVotes += value.get(k);
                            maxDeveloped--;
                        }
                    }
                }
             }
             System.out.println(maxVotes + " " + minVotes);
        }
    }
}
