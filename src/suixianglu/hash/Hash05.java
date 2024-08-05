package suixianglu.hash;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Hash05 {
    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target)[0] + " " + twoSum(nums, target)[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
