package ds.tries;

import java.util.HashMap;

class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
    public TrieNode(Character c) {
        this.c = c;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {

        root = new TrieNode();
    }

    public void insertWord(String word) {
        if (word == null || word.length() == 0) return;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
            }
            else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if (i == word.length() - 1) t.isLeaf = true;
        }
    }

    public Boolean searchWord(String word) {
        TrieNode t = search(word);
        if (t != null && t.isLeaf) return true;
        return false;
    }

    public Boolean searchPrefix(String word) {
        return search(word) == null ? false : true;
    }

    public TrieNode search(String word) {
        if (word == null || word.length() == 0) return null;
        TrieNode t = null;
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            }
            else return null;
        }
        return t;
    }

    public static void main(String a[]) {
        Trie trie = new Trie();
        trie.insertWord("senthil");
        trie.insertWord("senthilkumar");
        trie.insertWord("kandasamy");
    }
}