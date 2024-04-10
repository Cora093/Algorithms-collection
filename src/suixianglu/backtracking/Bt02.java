package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */
public class Bt02 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void clearResult() {
        result = new ArrayList<>();
    }

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return result;
    }

    void backtracking(int startIndex, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 剪枝，减少递归次数
        // 如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(i + 1, n, k);
            path.removeLast();
        }
    }
}
