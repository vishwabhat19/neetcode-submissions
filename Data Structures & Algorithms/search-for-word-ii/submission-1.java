class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board, trie.root, i, j, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, TrieNode current, int i, int j, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char ch = board[i][j];

        if (ch == '#' || current.children[ch - 'a'] == null) return;

        current = current.children[ch - 'a'];

        if (current.word != null) {
            result.add(current.word);
            current.word = null;
        }

        board[i][j] = '#';

        dfs(board, current, i+1, j, result);
        dfs(board, current,  i-1, j, result);
        dfs(board, current, i, j+1, result);
        dfs(board, current, i, j-1, result);

        board[i][j] = ch;
    }
}

class TrieNode {
    TrieNode []children;
    boolean isEndOfWord;
    String word = null;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
        current.word = word;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    
}
