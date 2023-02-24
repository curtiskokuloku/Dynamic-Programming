// Dynamic Programming
// Using Optimal solution strategies to solve simple problems
// Written Feb 19, 2023

public class LongestCommonSubsequence {
    // Given two sequences, find the length of the longest subsequence present
    // in both of them.
    // A subsequence is a sequence that appears in the same relative order
    // but is not necessarily contiguous

    // simple recursive implementation of the lCS problem
    public static int lcs(char[] x, char[] y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (x[m-1] == y[n-1]) {
            return 1 + lcs(x, y, m-1, n-1);
        } else {
            return Math.max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
        }
    }
    // the algorithm has a time complexity of O(2^n) in the worst case
    // worst-case happens when all the characters of x and y mismatch

//    public static void main(String[] args) {
//        String s1 = "AGGTAB";
//        String s2 = "GXTXAYB";
//
//        char[] X = s1.toCharArray();
//        char[] Y = s2.toCharArray();
//        int m = X.length;
//        int n = Y.length;
//        System.out.println("Length of LCS is" + " " + lcs( X, Y, m, n ) );
//    }
//                         lcs("AXYT", "AYZX")
//                       /                     \
//              lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
//            /                              /
//    lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")

    // re-computation of same sub-problems can be avoided b y either using
    // Memoization or Tabulation
    public static int memoizedLcs(String x, String y, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (x.charAt(m-1) == y.charAt(n-1)) {
            dp[m][n] = 1 + memoizedLcs(x, y, m-1, n-1, dp);
            return dp[m][n];
        }
        dp[m][n] = Math.max(memoizedLcs(x, y, m, n-1, dp), memoizedLcs(x, y, m-1, n, dp));
        return dp[m][n];
    }

    public static void fill(int a, int b, int[][] arr) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                arr[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        fill(m, n, dp);
        System.out.println("Length of LCS is "+ memoizedLcs(X, Y, m, n, dp));
    }
}
