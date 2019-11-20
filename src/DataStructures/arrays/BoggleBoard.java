package DataStructures.arrays;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by User on 21-07-2017.
 */
public class BoggleBoard {

    public ArrayList<String> boggleByot(char[][] board, ArrayList<String> dictionary){
        Set<String> result = new TreeSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boggleByotRecursion(result, board, i, j, dictionary, "");
            }
        }
        return new ArrayList<>(result);
    }

    public void boggleByotRecursion(Set<String> result, char[][] board, int r, int c, ArrayList<String> dictionary, String word){
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length -1
                || board[r][c] == '@' || !checkPrefix(dictionary, word)) {
            return;
        }
        char ch = board[r][c];
        word += ch;
        if (dictionary.contains(word)) {
            result.add(word);
        }
        board[r][c] = '@';

        boggleByotRecursion(result, board, r, c + 1, dictionary, word);
        boggleByotRecursion(result, board, r, c - 1, dictionary, word);
        boggleByotRecursion(result, board, r + 1, c, dictionary, word);
        boggleByotRecursion(result, board, r - 1, c, dictionary, word);
        board[r][c] = ch;
    }

    public boolean checkPrefix(ArrayList<String> dict, String prefix) {
        for (String str : dict) {
            if (str.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String a[]) {
        char[][] A = new char[][] {
                {'A', 'O', 'L'},
                {'D', 'E', 'L'},
                {'G', 'H', 'I'}
        };
        ArrayList<String> dict = new ArrayList<>();
        dict.add("TEST");
        dict.add("ADO");
        dict.add("HEOLL");
        dict.add("HELLO");
        dict.add("DEAL");
        dict.add("AOL");
        dict.add("AOLL");
        dict.add("HEAD");

        //new BoggleBoard().boggleByot(A, dict);
    }
}
