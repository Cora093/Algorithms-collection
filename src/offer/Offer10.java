package offer;

/**
 * 斐波那契数列
 */
public class Offer10 {
    public static void main(String[] args) {
        System.out.println(fib_01(3) + " " + fib_01(4) + " " + fib_01(5) + " " + fib_01(6) + " ");
        System.out.println(fib_02(3) + " " + fib_02(4) + " " + fib_02(5) + " " + fib_02(6) + " ");
    }


    // 递归 效率较低
    public static int fib_01(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fib_01(n - 1) + fib_01(n - 2);
    }

    // dp 动态规划 避免重复计算
    public static int fib_02(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
