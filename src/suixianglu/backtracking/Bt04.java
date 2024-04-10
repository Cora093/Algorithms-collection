package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Bt04 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void clearRes() {
        res = new ArrayList<>();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    void backtracking(int k, int targetSum, int startIndex) {
        if (getSum() > targetSum) {
            return;
        }
        if (path.size() == k) {
            if (getSum() == targetSum) {
                res.add(new ArrayList<>(path));
                return;
            }
        }

        for (int i = startIndex; i <= 9 + 1 - (k - path.size()); i++) {
            path.add(i);
            backtracking(k, targetSum, i + 1);
            path.removeLast();
        }

    }

    int getSum() {
        return path.stream().mapToInt(Integer::intValue).sum();
    }

}
