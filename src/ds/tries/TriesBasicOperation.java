package ds.tries;

class TrieNode {

    TrieNode parent;
    TrieNode[] children;
    boolean isLeaf;
    boolean isWord;
    char chr;

    TrieNode(){
        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
    }

    TrieNode(char c){
        this();
        this.chr = c;
    }

    public void addWords(String s) {

        if (s == null || s.length() == 0) return;
        int c = s.charAt(0) - 'a';
        if (children[c] == null) {
            children[c] = new TrieNode(s.charAt(0));
            children[c].parent = this;
        }
        if (s.length() > 1) {
            children[c].addWords(s.substring(1));
        }
        else {
            children[c].isWord = true;
        }
    }

    public boolean isWordAvailable(String s, TrieNode[] nextNode) {
        int c = s.charAt(0) - 'a';
        if (children[c] == null) return false;
        //if (s.length() > 1) isWordAvailable(s.substring(1), children[c].children[0]);
        return true;
    }
}

public class TriesBasicOperation {
    private static TrieNode tn = new TrieNode();

    public static void main(String a[]) {
        String firstName = null;
        firstName = firstName == null ? "" : firstName.trim().toUpperCase();
        System.out.println(firstName);
        /*TriesBasicOperation tb = new TriesBasicOperation();
        tn.addWords("senthil");
        tn.addWords("kumar");
        //tn.addWords("kandasamy");
        tn.addWords("kumarkumar");
        System.out.println(tn.isWordAvailable("senthil", tn));*/
        //System.out.println(tn);
    }
}
