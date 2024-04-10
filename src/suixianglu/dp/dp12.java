package suixianglu.dp;

/**
 * 一维数组解01背包
 */
public class dp12 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;

        yiweidp(weight, value, bagSize);
    }

    private static void yiweidp(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            // 注意遍历顺序
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(dp[bagSize]);
    }
}
