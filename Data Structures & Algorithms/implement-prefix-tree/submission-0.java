class PrefixTree {

    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
            
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
    private static class TrieNode {
        TrieNode [] children = new TrieNode[26];
        boolean endOfWord = false;
    }
}
