package DataStructures.arrays;

import java.util.ArrayList;

/**
 * Created by sydgsk9 on 4/5/2017.
 */

/*class Pair {
    int left;
    int right;
    Pair(int i, int j) {
        this.left = i;
        this.right = j;
    }
}*/

public class Flip {

    public ArrayList<Integer> flip(String A) {
        if (A == null || A.length() == 0) return new ArrayList<>();
        int max = 0;
        int zeroCount = 0;
        int startIndex = 0;
        int endIndex = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '0') {
                zeroCount++;
                if (max < zeroCount) {
                    max = zeroCount;
                    endIndex = i;
                    result.clear();
                    result.add(startIndex + 1);
                    result.add(endIndex + 1);
                }
            }
            else {
                if (zeroCount == 0) {
                    startIndex++;
                }
                else zeroCount--;
            }
        }
        return result;
    }

    public ArrayList flip1(String A) {
        int zero_minus_one = 0;
        int max_zero_minus_one = 0;
        int start_index = 0;
        int end_index = 0;

        ArrayList result_list = new ArrayList();
        for (int i = 0; i < A.length(); i++) {
            int digit_at_i = A.charAt(i) - '0';
            if (digit_at_i == 0) {
                zero_minus_one++;
                if (max_zero_minus_one < zero_minus_one) {
                    // there is a new max, adjust end to here
                    // and record the window. The check above
                    // is less_than, and not less_than_equal
                    // this guarantees lexical ordering
                    max_zero_minus_one = zero_minus_one;
                    end_index = i;
                    result_list.clear();
                    result_list.add(0, start_index + 1);
                    result_list.add(1, end_index + 1);
                }
            } else { // digit == 1
                if (zero_minus_one == 0) {
                    // equal number of 0s and 1s
                    // so start from next digit
                    // to see if we can find max there
                    start_index = i + 1;
                } else {
                    zero_minus_one--;
                }
            }
        }
        return result_list;
    }
    /*public ArrayList<Integer> flip(String A) {
        ArrayList<Pair> list = new ArrayList<>();
        int total = numberOfOnes(A);
        if (A.length() == total) return new ArrayList<>();
        int sum = total;
        int max = 0;
        Pair temp = null;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length() - 1; j++) {
                int s = i;
                int e = j;
                while (s <= e) {
                    if (A.charAt(s) == '1') {
                        sum--;
                    }
                    else {
                        sum++;
                    }
                    s++;
                }
                if (sum > max) {
                    list = new ArrayList<>();
                    list.add(new Pair(i, j));
                    max = sum;
                }
                else if (sum == max) {
                    list.add(new Pair(i, j));
                }
                sum = total;
            }
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.left - o2.left;
            }
        });
        ArrayList<Integer> result = new ArrayList<>();
        result.add(list.get(0).left);
        result.add(list.get(0).right);
        return result;
    }

    public int numberOfOnes(String A) {
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1') count++;
        }
        return count;
    }*/

    public static void main(String a[]) {
        Flip flip = new Flip();
        //flip.flip("010");
        //flip.flip("0100011");
        //flip.flip("00");
        //flip.flip("1101");
        flip.flip1("0111000100010");
    }
}
