package suixianglu.hash;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Hash06 {
    @Test
    public void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        int i = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(i);
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum2 = nums1[i] + nums2[j];
                if (map.containsKey(sum2)) {
                    map.put(sum2, map.get(sum2) + 1);
                } else {
                    map.put(sum2, 1);
                }
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum2 = nums3[i] + nums4[j];
                if (map.containsKey(-sum2)) {
                    res += map.get(-sum2);
                }
            }
        }
        return res;
    }
}
