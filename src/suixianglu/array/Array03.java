package suixianglu.array;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。
 * 元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */
public class Array03 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = removeElement(nums, val);
        Assert.assertEquals(2, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        k = removeElement(nums, val);
        Assert.assertEquals(5, k);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        // 在原数组基础上创建新数组
        // right 找到新数组中的数 替换到 left
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            // 如果 right 找到了新数组中的数
            if (nums[right] != val) {
                if (left != right) {
                    nums[left] = nums[right];
                }
                left++;
            }
        }
        return left;
    }
}
