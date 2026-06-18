class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(int i=0;i<strs.size();i++) {
            String tempString = strs.get(i);
            int length = tempString.length();
            encodedString = encodedString + length + "#" + tempString;
        }
        return encodedString;

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
        int index = 0;
        while(index < str.length()) {
            if (str.charAt(index) >= '0' || str.charAt(index) <= '9') {
                //Its a number. So increment till you find #
                int originalIndex = index;
                while(str.charAt(index)!='#') {
                    index++;
                }
                int length = Integer.parseInt(str.substring(originalIndex, index));
                result.add(str.substring(index+1, index+length+1));
                index = index + length + 1;
            }
        }
        return result;
    }
}
