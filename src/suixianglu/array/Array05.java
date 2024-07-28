package suixianglu.array;

import org.junit.Assert;

/**
 * 209.长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数target。
 * 找出该数组中满足其总和大于等于target的长度最小的子数组,并返回其长度。
 * 如果不存在符合条件的子数组，返回0。
 */
public class Array05 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Assert.assertEquals(2, minSubArrayLen(target, nums));
        target = 4;
        nums = new int[]{1, 4, 4};
        Assert.assertEquals(1, minSubArrayLen(target, nums));
        target = 11;
        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertEquals(0, minSubArrayLen(target, nums));
        target = 6;
        nums = new int[]{10, 2, 3};
        Assert.assertEquals(1, minSubArrayLen(target, nums));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (sum >= target) {
                while (sum - nums[l] >= target) {
                    sum -= nums[l];
                    l++;
                }
                minLen = Math.min(r - l + 1, minLen);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
