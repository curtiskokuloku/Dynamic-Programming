// Dynamic Programming
// Using Optimal solution strategies to solve simple problems
// Written Feb 20, 2023

import java.util.Arrays;

public class CoinChange {
    // Given an integer array of coins of size n representing different types
    // of currency and an integer sum:
    // the task is to find the number of ways to make sum by using different
    // combinations from coins
    // Input: sum = 4, coins[] = {1,2,3},
    // Output: 4
    // Explanation: there are four solutions:
    //              {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.
    public static int count(int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;   // there is only one solution
        }

        if (sum < 0) {
            return 0;   // there is no solution
        }

        if (n <= 0) {
            return 0;   // there is no coins
        }

        return count(coins, n - 1, sum) + count(coins, n, sum - coins[n - 1]);
    }
    // algorithm has a time complexity of O(2^sum)
    // and a space complexity of O(target)

    // Since the same sub-problems are called again,
    // this problem has the Overlapping Sub-problems property.
    // Re-computations of the same sub-problems can be avoided by
    // constructing a temporary array table[][] in a bottom-up manner

    // Using Dynamic Programming
    // The Idea to Solve this Problem is by using the Bottom Up(Tabulation).
    // By using the linear array for space optimization.

    public static long countWays(int[] coins, int n, int sum) {
        // algorithm has a time complexity of O(n^sum) and space complexity of O(sum)

        long[] table = new long[sum + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                table[j] += table[j - coins[i]];
            }
        }

        return table[sum];
    }
}
