/*
Key Observations:

The matrix is sorted row-wise and column-wise.
If we start from the top-right corner:
If the target is smaller than the current element, it cannot be in the current column, so we move left.
If the target is larger than the current element, it cannot be in the current row, so we move down.
Algorithm:

Start at the top-right corner of the matrix, i.e., matrix[0][n-1].
Use two pointers: row (starting from 0) and col (starting from n-1).
While the indices are valid:
If the current element matches the target, return true.
If the target is smaller, move left (col--).
If the target is larger, move down (row++).
If we exit the loop, the target is not in the matrix.
Time Complexity:

O(m + n): We process at most m rows and n columns.*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int row=0;
        int col=m-1; //Start at the top-right corner
        while(row<n && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                row++; //Move down
            }else{
                col--; //move left
            }

        }
        return false;
    }
}
