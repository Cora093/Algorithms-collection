package suixianglu.array;

import org.junit.Assert;

/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Array02 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        Assert.assertEquals(4, search(nums, 9));
        nums = new int[]{-1, 0, 3, 5, 9, 12};
        Assert.assertEquals(-1, search(nums, 2));
    }


    // 二分查找
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (true) {
            if (left > right) {
                break;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
