class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //First reverse it vertically. First row becomes last and so on...
        for(int i=0;i<n/2;i++) {
            int temp[] = new int[n];
            temp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = temp;
        }

        //Then transpose it
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
