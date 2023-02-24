// Dynamic Programming
// Using Optimal solution strategies to solve simple problems
// Written Feb 18, 2023

public class Fibonacci {
    /**
     * @method fib(n) return the fibonacci value of integer n
     * @param n: integer number which we are to calculate
     */
    public static int fib(int n) {
        // Algorithm has an exponential time complexity,
        // as every functions that calls two other functions
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
//                          fib(5)
//                     /                \
//              fib(4)                fib(3)
//            /        \              /       \
//         fib(3)      fib(2)         fib(2)   fib(1)
//            /    \       /    \        /      \
//      fib(2)   fib(1)  fib(1) fib(0) fib(1)   fib(0)
//            /     \
//      fib(1)      fib(0)

    // Using Dynamic programming to avoid teh repeated work done
    // by storing Fibonacci numbers calculated so far
    public static int dynamicFib(int n) {
        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
