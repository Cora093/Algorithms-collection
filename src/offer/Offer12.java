package offer;

public class Offer12 {
    public static void main(String[] args) {
        char[][] data = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(new Offer12Solution().hasPath(data, "bfce"));
        System.out.println(new Offer12Solution().hasPath(data, "cfcd"));
        System.out.println(new Offer12Solution().hasPath(data, "abfcjde"));
        System.out.println(new Offer12Solution().hasPath(data, ""));
        System.out.println(new Offer12Solution().hasPath(data, "a"));
        System.out.println(new Offer12Solution().hasPath(data, "abfb"));
        System.out.println(new Offer12Solution().hasPath(data, "abtgscfcjdeh"));
    }

}

class Offer12Solution {
    StringBuilder path = new StringBuilder();

    // 判断矩阵中是否含有路径str
    public boolean hasPath(char[][] data, String str) {
        // 判空
        if (data == null || data.length == 0 || data[0].length == 0 || str.isEmpty() ||
                str.length() > data.length * data[0].length) {
            return false;
        }
        boolean[][] isVisited = new boolean[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (backtracking(data, str, i, j, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] data, String str, int i, int j, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= data.length || j >= data[0].length) {
            return false;
        }
        if (str.contentEquals(path)) {
            return true;
        }
        if (path.length() > data.length * data[0].length) {
            return false;
        }
        boolean res = false;
        if (!isVisited[i][j] && data[i][j] == str.charAt(path.length())) {
            path.append(data[i][j]);
            isVisited[i][j] = true;
            res = (backtracking(data, str, i - 1, j, isVisited) ||
                    backtracking(data, str, i + 1, j, isVisited) ||
                    backtracking(data, str, i, j - 1, isVisited) ||
                    backtracking(data, str, i, j + 1, isVisited));

            if (!res) {
                path.deleteCharAt(path.length() - 1);
                isVisited[i][j] = false;
            }
        }
        return res;
    }
}
