class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //FIrst find the row ?
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        while(row < matrix.length) {
            if (target > matrix[row][n-1]) {
                row++; //Target is not in this row
            }
            else {
                //Target is in this row. Do binary search
                int left = 0;
                int right = n-1;
                int mid = left + (right-left)/2;
                while(left <= right) {
                    if (matrix[row][mid] == target) {
                        return true;
                    }
                    else if (matrix[row][mid] < target) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                    mid = left + (right - left)/2;
                }
                return false;

            }
        }

        return false;
    }
}
