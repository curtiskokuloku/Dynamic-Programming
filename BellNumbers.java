// Dynamic Programming
// Using Optimal solution strategies to solve simple problems
// Written Feb 19, 2023

public class BellNumbers {
    // given a set of n elements, we can find the number of ways of partitioning it
    // example:
    //    Input:  n = 2
    //    Output: Number of ways = 2
    //    Explanation: Let the set be {1, 2}
    //    { {1}, {2} }
    //    { {1, 2} }

    public static int partition(int n) {
        int[][] set = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i < j) {
                    set[i][j] = 0;
                } else if (i == j) {
                    set[i][j] = 1;
                } else if (i == 0 || j == 0) {
                    set[i][j] = 0;
                } else {
                    set[i][j] = j * set[i - 1][j] + set[i - 1][j - 1];
                }
            }
        }

        int ans = 0;
        for (int k = 0; k < n + 1; k++) {
            ans += set[n][k];
        }
        return ans;
    }
    // The algorithm has a time and space complexity of O(n^2)
    // A better method is to use Bell Triangle:
    //        1
    //        1 2
    //        2 3 5
    //        5 7 10 15
    //        15 20 27 37 52

    public static int bellNumbers(int n) {
        int[][] tri = new int[n+1][n+1];
        tri[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            tri[i][0] = tri[i-1][i-1];
            for (int j = 1; j <= i; j++)
                tri[i][j] = tri[i-1][j-1] + tri[i][j-1];
        }
        return tri[n][0];
    }
    // The algorithm has also a time and space complexity of O(n^2)

    public static void main(String[] args) {
        int count = -1;
        for (int n=0; n<=2; n++) {
            System.out.println("Bell Number " + n + " is " + bellNumbers(n));
            count++;
        }
        System.out.println("Total number of ways to partition " + count);
    }
}
