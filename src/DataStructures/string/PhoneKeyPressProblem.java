package DataStructures.string;

import java.util.*;

/**
 Given a String that represents the digits pressed on a classic cell phone keypad -
 return all possible letter combinations that the numbers could represent in an ArrayList of Strings.
 Check out the keypad and mapping below for reference.

 Note:
 a) You can assume that the input String contains only numbers between 2 and 9.
 b) The order of the combinations in the output does not matter.

 Mapping:
 2 -> "abc"
 3 -> "def"
 4 -> "ghi"
 5 -> "jkl"
 6 -> "mno"
 7 -> "pqrs"
 8 -> "tuv"
 9 -> "wxyz"

 Example:
 Input  : "34"
 Output : [dg, dh, di, eg, eh, ei, fg, fh, fi]
 */

public class PhoneKeyPressProblem {
    //firecode solution!
    public static ArrayList<String> getStringsFromNums(String digits){
        // Create the Phone Key-Mapping
        HashMap<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        // Declare a local Phone Node class
        class PhoneNode{
            String word;
            int digitCount;
            PhoneNode(String w, int c){
                word = w;
                digitCount = c;
            }
        }

        // Create the stack
        ArrayList<String> out = new ArrayList<>();
        Deque<PhoneNode> stack = new LinkedList<>();
        int len = digits.length();

        // Push the first nodes onto the stack
        for(Character c: mapping.get(digits.charAt(0)).toCharArray()){
            stack.addFirst(new PhoneNode(String.valueOf(c), 1));
        }

        // Classic DFS
        while(!stack.isEmpty()){
            PhoneNode node = stack.removeFirst();
            if(node.digitCount == len) out.add(node.word);
            else {
                for(Character ch: mapping.get(digits.charAt(node.digitCount)).toCharArray()){
                    stack.addFirst(new PhoneNode(node.word + ch, node.digitCount+1));
                }
            }
        }
        return out;
    }

    //I tried!
    public static ArrayList<String> getStringsFromNums1(String digits){
        // Create the Phone Key-Mapping
        HashMap<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        class PhoneNode {
            String word;
            int count;
            PhoneNode(String word, int count) {
                this.word = word;
                this.count = count;
            }
        }
        Queue<PhoneNode> queue = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        int len = digits.length();


        for (Character ch : mapping.get(digits.charAt(0)).toCharArray()) {
            queue.add(new PhoneNode(String.valueOf(ch), 1));
        }
        while (!queue.isEmpty()) {
            PhoneNode node = queue.poll();
            if (node.count == len) result.add(node.word);
            else {
                for (Character ch : mapping.get(digits.charAt(node.count)).toCharArray()) {
                    queue.add(new PhoneNode(node.word + ch, node.count + 1));
                }
            }
        }
        return result;
    }

    public static void main(String a[]) {
        System.out.println(PhoneKeyPressProblem.getStringsFromNums1("345"));
    }
}
