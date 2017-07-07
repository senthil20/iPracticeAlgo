package ds.tries;

class TNode {

    TNode parent;
    TNode[] children;
    boolean isLeaf;
    boolean isWord;
    char chr;

    TNode(){
        children = new TNode[26];
        isLeaf = true;
        isWord = false;
    }

    TNode(char c){
        this();
        this.chr = c;
    }

    public void addWords(String s) {

        if (s == null || s.length() == 0) return;
        int c = s.charAt(0) - 'a';
        if (children[c] == null) {
            children[c] = new TNode(s.charAt(0));
            children[c].parent = this;
        }
        if (s.length() > 1) {
            children[c].addWords(s.substring(1));
        }
        else {
            children[c].isWord = true;
        }
    }

    public boolean isWordAvailable(String s, TNode[] nextNode) {
        int c = s.charAt(0) - 'a';
        if (children[c] == null) return false;
        //if (s.length() > 1) isWordAvailable(s.substring(1), children[c].children[0]);
        return true;
    }
}

public class TriesBasicOperation {
    private static TNode tn = new TNode();

    public static void main(String a[]) {
        String firstName = null;
        firstName = firstName == null ? "" : firstName.trim().toUpperCase();
        System.out.println(firstName);
        tn.addWords("senthil");
        tn.addWords("kumar");
        //tn.addWords("kandasamy");
        tn.addWords("kumarkumar");
        System.out.println(tn.isWordAvailable("senthil", tn.children));
        //System.out.println(tn);
    }
}
