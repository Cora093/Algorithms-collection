package offer;

/**
 * leetcode 153
 */
public class Offer11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.findMin(new int[]{11, 13, 15, 17}));
        System.out.println(solution.findMin(new int[]{2, 1}));
    }
}

/**
 * 要求时间复杂度O(logn)  类二分法求解  互不相同 (如果存在重复元素，则有特殊情况
 * * 所有整数)
 */
class Solution {
    public int findMin(int[] nums) {
        // 判空
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        int mid = 0;
        while (left < right) {
            mid = (right + left) / 2;
            if (nums[right] > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

