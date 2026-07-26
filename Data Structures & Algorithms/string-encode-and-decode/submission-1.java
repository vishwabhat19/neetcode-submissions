class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String str : strs) {
            result += str.length() + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i <str.length()) {
            int originalIndex = i;
            while(str.charAt(i)!='#') {
                i++;
            }
            int length = Integer.parseInt(str.substring(originalIndex, i));
            result.add(str.substring(i+1, i+length+1));
            i = i + length + 1;
        }
        return result;
    }
}
