package ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.StrictMath.min;

class Node implements Comparable<Node>{

    int index;
    int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(value, node.value);
    }
}

public class FlipGame {

    public boolean canWin(String s) {
        if(s==null||s.length()==0){
            return false;
        }

        return canWinHelper(s.toCharArray());
    }

    public boolean canWinHelper(char[] arr){
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]=='+'&&arr[i+1]=='+'){
                arr[i]='-';
                arr[i+1]='-';

                boolean win = canWinHelper(arr);

                arr[i]='+';
                arr[i+1]='+';

                //if there is a flip which makes the other player lose, the first play wins
                if(!win){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String a[]) {
        FlipGame fg = new FlipGame();
        //System.out.println(fg.canWin("++++"));
        //System.out.println(fg.power(2, 5));
        //fg.rearrange(new int[]{1,3,5,2,4,6});
    }
}

