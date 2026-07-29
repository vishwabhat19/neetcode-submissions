class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String str : strs) {
            result = result + str.length() + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        int index = 0;
        List<String> result = new ArrayList<>();
        while(index < str.length()) {
            int originalIndex = index;
            while(str.charAt(index) != '#') {
                index++;
            }
            int length = Integer.parseInt(str.substring(originalIndex, index));
            //Right now index is at #.
            //The string is now from the index+1 to index+1+length position
            String substr = str.substring(index+1, index+1+length);
            result.add(substr);
            index = index + 1 + length;
        }
        return result;
    }
}
