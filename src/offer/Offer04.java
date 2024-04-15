package offer;

/**
 * 二维数组，从左到右递增，从上到下递增，输入一个整数，判断数组中是否含有
 */
public class Offer04 {
    public static void main(String[] args) {
        int[][] data = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        System.out.println(findInPartiallySortedMatrix(data, 10));
        System.out.println(findInPartiallySortedMatrix(data, 5));
        System.out.println(findInPartiallySortedMatrix(data, 15));
    }


    // 与右上角的数对比排除（也可以左下角）
    public static boolean findInPartiallySortedMatrix(int[][] data, int target) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return false;
        }
        int row = 0;
        int column = data[0].length - 1;
        while (row < data.length && column >= 0) {
            if (data[row][column] == target) {
                return true;
            } else if (data[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
