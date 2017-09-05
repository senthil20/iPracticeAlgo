package ds.arrays;

import java.util.*;

/**
 * Created by User on 29-07-2017.
 */
public class Nooffloors extends Properties{

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        if (M < 1) return 0;
        int start = 0;
        int end = A.length - 1;
        Set<Integer> floors = new HashSet<>();
        int count = 1;
        int total = 0;
        int noofstops = 0;

        while (start <= end) {
            if (A[start] > Y) {
                start++;
                continue;
            }
            total += A[start];
            if (total > Y || count > X) {
                noofstops += floors.size() + 1;
                total = 0;
                count = 1;
                floors = new HashSet<>();
            }
            else {
                floors.add(B[start]);
                count++;
                start++;
            }
        }
        if (floors.size() != 0) {
            noofstops += floors.size() + 1;
        }
        return noofstops;
    }

    public static String shipShink(int N, String S, String T) {

        if (S == null || S.length() == 0 || T == null || T.length() == 0) return "0,0";
        String[] ships = S.split(",");
        String[] hits = T.split(",");
        List<Set<String>> list = new ArrayList<>();

        for (String ship : ships) {
            ship = ship.trim().toUpperCase();
            Set<String> cells = new HashSet<>();
            String[] shipPos = ship.split(" ");
            String startPos = shipPos[0];
            String endPos = shipPos[1];

            int start = Character.getNumericValue(startPos.charAt(0));
            int end = Character.getNumericValue(endPos.charAt(0));
            char chstart = startPos.charAt(1);
            char chend = endPos.charAt(1);

            for (int i = start; i <= end; i++) {
                for (char ch = chstart; ch <= chend; ch++) {
                    cells.add(String.valueOf(i).concat(ch+""));
                }
            }
            list.add(cells);
        }

        int shiphit = 0;
        int shiphitpartial = 0;

        for (Set<String> set : list) {
            int size = set.size();
            String[] hit = T.split(" ");
            for (String val : hit) {
                if (set.contains(val)) {
                    set.remove(val);
                }
            }
            if (set.isEmpty()) {
                shiphit++;
            }
            else if (set.size() != size) {
                shiphitpartial++;
            }
        }
        return shiphit + "," + shiphitpartial;
    }


    public static String solution(int N, String S, String T) {

        if (S == null || S.length() == 0 || T == null || T.length() == 0) return "0,0";
        String[] ships = S.split(",");
        String[] hits = T.split(",");
        List<Set<String>> list = new ArrayList<>();

        for (String ship : ships) {
            ship = ship.trim().toUpperCase();
            Set<String> cells = new HashSet<>();
            String[] shipPos = ship.split(" ");
            String startPos = shipPos[0];
            String endPos = shipPos[1];

            int start = Integer.parseInt(startPos.substring(0, startPos.length() - 1));
            int end = Integer.parseInt(endPos.substring(0, endPos.length() - 1));
            char chstart = startPos.charAt(startPos.length() - 1);
            char chend = endPos.charAt(endPos.length() - 1);

            for (int i = start; i <= end; i++) {
                for (char ch = chstart; ch <= chend; ch++) {
                    cells.add(String.valueOf(i).concat(ch+""));
                }
            }
            list.add(cells);
        }

        int shiphit = 0;
        int shiphitpartial = 0;

        for (Set<String> set : list) {
            int size = set.size();
            String[] hit = T.split(" ");

            for (String val : hit) {
                if (set.contains(val)) {
                    set.remove(val);
                }
            }
            if (set.isEmpty()) {
                shiphit++;
            }
            else if (size != set.size()) {
                shiphitpartial++;
            }
        }
        return shiphit + "," + shiphitpartial;
    }

    public static void main(String ar[]) {

        Properties prop = new Properties(System.getProperties());

        System.getProperties().put("Hello", "Hello");

        System.out.println(prop.get("Hello"));

        System.getProperties().put("Test", "Test");

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input.add(s.nextInt());
        }
        int start = 0;
        int end = input.get(0);
        int max = input.get(1);

        List<List<Double>> pairs = new ArrayList<>();
        int total = 0;
        for (int i = 0; i <= end; i++) {
            for (int j = 0; j <= max; j++) {
                List<Double> list = new ArrayList<>();
                list.add((double)i);
                list.add((double)j);
                pairs.add(list);
            }
        }

        for (int i = 0; i < pairs.size(); i++) {
            for (int j = 0; j < pairs.size(); j++) {
                List<Double> pair1 = pairs.get(i);
                List<Double> pair2 = pairs.get(j);
                List<Double> temp = new ArrayList<>();
                temp.add((double)(pair1.get(0) + pair2.get(0)) / 2);
                temp.add((double)(pair1.get(1) + pair2.get(1)) / 2);

                if (pairs.contains(temp)) {
                    total += 1 % (Math.pow(10.0, 9.0) + 1);
                }
            }
        }
        System.out.println(total);
        //Nooffloors.shipShink(4, "1A 1B, 2C 2C", "1B");
        //Nooffloors.shipShink(4, "1B 2C, 2D 4D", "2B 2D 3D 4D 4A");
        //Nooffloors.solution(4, "1B 2C, 2D 4D", "2B 2D 3D 4D 4A");
        //Nooffloors.solution(12, "1A 2A,12A 12A", "12A");

        /*int[] A = new int[]{0, 0, 0};
        int[] B = new int[]{0, 0, 0};
        int M = 5;
        int X = 2 ;
        int Y = 200;
        Nooffloors.solution(A, B, M, X, Y);*/
    }
}
