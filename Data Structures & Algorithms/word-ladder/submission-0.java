class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int count = 1;
        Set<String> words = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String current = q.poll();
                char[] charArray = current.toCharArray();
                for(int j=0;j<charArray.length;j++) {
                    char originalChar = charArray[j];
                    for(char c='a';c<='z';c++) {
                        if (c==originalChar) continue;
                        charArray[j] = c;
                        if (words.contains(new String(charArray))) {
                            q.offer(new String(charArray));
                            words.remove(new String(charArray));
                            if (endWord.equals(new String(charArray))) {
                                count++;
                                return count;
                            }
                        }
                    }
                    charArray[j] = originalChar;
                }

            }
            count++;

        }
        return 0;
    }
}
