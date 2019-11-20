package DataStructures.string;

/**
 Edit distance is a classic algorithm that is used in many applications,
 including Spell Correction, DNA Sequencing and Natural Language Processing.
 Given two Strings, a and b, write a method - editDistance that returns the minimum
 number of operations needed to transform a into b. The following character operations are allowed :
 a) Replace character
 b) Insert character
 c) Delete character

 Examples :
 editDistance("sale", "sales") => 1

 Operations :
 1) Insert "s"

 editDistance("sale", "sold") => 2

 Operations :
 1) Replace "a" with "o"
 2) Replace "e" with "d"

 editDistance("sa", "s") => 1

 Operations :
 1) Delete "a"
 */

//INCOMPLETE
public class WordSimilarityEditDistance {

    public static int editDistance(String a, String b){
        int lenA = a.length(), lenB = b.length();
        int[][] memo = new int[lenA+1][lenB+1];
        // Prefill first row and column
        for(int i = 1; i <= lenA; i++) memo[i][0] = i;
        for(int j = 1; j <= lenB; j++) memo[0][j] = j;
        // Traverse and fill cells
        for(int i = 1; i <= lenA; i++){
            char cA = a.charAt(i-1);
            for(int j = 1; j <= lenB; j++){
                char cB = b.charAt(j-1);
                if(cA == cB){
                    memo[i][j] = memo[i-1][j-1];
                }
                else {
                    int replaceDist = 1 + memo[i-1][j-1];
                    int insertDist = 1 + memo[i][j-1];
                    int deleteDist = 1 + memo[i-1][j];
                    int minDist = Math.min(replaceDist,Math.min(insertDist, deleteDist));
                    memo[i][j] = minDist;
                }
            }
        }
        return memo[lenA][lenB];
    }

    public static int editDistance1(String a, String b) {
        if(a == null) return 0;
        if (a != null && (b == null || b.length() == 0)) return a.length();
        int aStart = 0;
        int aEnd = a.length();
        int bStart = 0;
        int bEnd = b.length();
        int distance = 0;
        while (aStart < aEnd && bStart < bEnd) {
            if (a.charAt(aStart) != b.charAt(bStart)) {
                if (a.length() > b.length()) {
                    StringBuffer sb = new StringBuffer(a);
                    sb.deleteCharAt(aStart);
                    a = sb.toString();
                    aEnd = a.length();
                    distance++;
                    continue;
                } else {
                    distance++;
                }
            }
            aStart++;
            bStart++;
        }
        while (aStart < aEnd) {
            distance++;
            aStart++;
        }
        while (bStart < bEnd) {
            distance++;
            bStart++;
        }
        return distance;
    }

    public static void main(String a[]) {
        //System.out.println(WordSimilarityEditDistance.editDistance("saturday", "sunday"));
        System.out.println(WordSimilarityEditDistance.editDistance("ATGCATGGCCAAAATTTTAAAAATAGAGAGATTTCCCAATTGCCAAT", "ATCGATCGATCGAATTA"));
    }
}
