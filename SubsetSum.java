// Dynamic Programming
// Using Optimal solution strategies to solve simple problems
// Written Feb 21, 2023

public class SubsetSum {
    // given a set of non-negative integers, and a value sum, determine if there
    // is a subset of the given set with sum equal to given sum
    //  Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    //  Output: True
    //  There is a subset (4, 5) with sum 9.

    public static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (set[n-1] > sum) {   // last element is greater than sum (ignore it)
            return isSubsetSum(set, n-1, sum);
        }
        return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum - set[n-1]);
    }
    // The time complexity of the above code is exponential - O(2^n)

    // Using dynamic programming
    // creating a 2D array of type boolean
    public static boolean isSubsetSum2(int[] set, int n, int sum) {
        boolean[][] subset = new boolean[sum+1][n+1];
        for (int i = 0; i <= n; i++) {
            // if sum is 0, then answer is true
            subset[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            // sum is not o, and set is empty
            subset[i][0] = false;
        }
        // bottom-up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1]) {
                    subset[i][j] = subset[i][j] || subset[i-set[j-1]][j-1];
                }
            }
        }
        return subset[sum][n];
    }

    public static void main(String[] args) {
        int[] set = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        System.out.println("Subset found with given sum?\n" + isSubsetSum(set, n, sum));
        System.out.println("Subset found with given sum?\n" + isSubsetSum2(set, n, sum));
    }
}
