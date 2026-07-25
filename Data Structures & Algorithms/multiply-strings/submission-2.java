class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length()];
        Arrays.fill(result, 0);
        for(int i=num1.length() - 1;i>=0;i--) {
            for(int j=num2.length() - 1;j>=0;j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sP = i+j+1;
                int cP = i+j;
                int sum = mul + result[sP];
                result[sP] = sum % 10;
                result[cP] = result[cP] + sum / 10; //carry
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<result.length;i++) {
            if (sb.length() == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
