class TrieNode {
    TrieNode children[];
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
    }

    public boolean search(String word) {
        return searchNode(word, root, 0);
    }

    public boolean searchNode(String word, TrieNode current, int wordIndex) {
        if (wordIndex == word.length()) return current.isEndOfWord;

        char ch = word.charAt(wordIndex);

        if (ch == '.') {
            for(int i=0;i<26;i++) {
                if (current.children[i] != null) {
                    if (searchNode(word, current.children[i], wordIndex + 1)) return true;
                }
            }
            return false;
        }

        else {
            if (current.children[ch - 'a'] == null) return false;
            return searchNode(word, current.children[ch - 'a'], wordIndex + 1);
        }


    }
}
