// Dynamic Programming
// Using Optimal solution strategies to solve simple problems
// Written Feb 23, 2023

import java.util.Arrays;

public class MatrixChainMultiplication {
    // Given the dimension of a sequence of matrices in an array arr[],
    // where the dimension of the ith matrix is (arr[i-1] * arr[i]),
    // the task is to find the most efficient way to multiply these
    // matrices together such that the total number of element
    // multiplications is minimum.

    //  Input: arr[] = {1, 2, 3, 4, 3}
    //  Output: 30
    //  Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3.
    //  Let the input 4 matrices be A, B, C and D.
    //  The minimum number of multiplications are obtained by
    //  putting parenthesis in following way ((AB)C)D.
    //  The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30

    public static int matrixChain(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        // Place parenthesis at different places between first and last matrix,
        // recursively calculate count of multiplications for each parenthesis
        // placement and return the minimum count
        for (int k = i; k < j; k++) {
            int count = matrixChain(p, i, k) + matrixChain(p, k+1, j) + p[i-1] * p[k] * p[j];
            if (count < min) {
                min = count;
            }
        }
        return min;
    }
    // the algorithm has an exponential time complexity

    //Re-computations of same sub-problems can be avoided by constructing a temporary
    // array dp[][] in a bottom-up fashion
    public static int[][] dp = new int[100][100];
    public static int matrixChainMemoised(int[] p, int i, int j){
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], matrixChainMemoised(p, i, k)
                            + matrixChainMemoised(p, k + 1, j)
                            + p[i - 1] * p[k] * p[j]);
        }
        return dp[i][j];
    }

    public static int dynamicMatrixChain(int[] p, int n) {
        int i = 1, j = n-1;
        return matrixChainMemoised(p, i, j);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println("Minimum number of multiplications is " + matrixChain(arr, 1, n - 1));

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("Minimum number of multiplications is " + dynamicMatrixChain(arr, n));
    }
}
