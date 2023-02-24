// Dynamic Programming
// Using Optimal solution strategies to solve simple problems
// Written Feb 21, 2023

public class RodCutting {
    // Given a rod of length n inches and an array of prices that includes
    // prices of all pieces of size smaller than n.
    // Determine the maximum value obtainable by cutting up the rod
    // and selling the pieces.

    public static int cutRod(int[] prices, int index, int n) {
        if (index == 0) {
            return n * prices[0];
        }
        int notCut = cutRod(prices, index - 1, n);
        int cut = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= n) {
            cut = prices[index] + cutRod(prices, index, n - rodLength);
        }
        return Math.max(notCut, cut);
    }

    // the algorithm has time complexity of O(n^2)

    // Using dynamic programming, re-computations of the same sub-problems
    // can be avoided by constructing a temporary array in bottom-up manner
    public static int cutRodDynamic(int[] prices, int n) {
        int[] val = new int[n+1];
        val[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[j] + val[i-j-1]);
            }
            val[i] = max;
        }
        return val[n];
    }

    public static void main(String args[]) {
        int[] arr = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRodDynamic(arr, size));
    }

}
