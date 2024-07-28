package suixianglu.array;

import java.util.Scanner;

/**
 * 区间和
 * 题目描述
 * 给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
 * 输入描述
 * 第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间，直至文件结束。
 * 输出描述
 * 输出每个指定区间内元素的总和。
 * 输入示例
 * 5  1 2 3 4 5  0 1  1 3
 * 输出示例
 * 3
 * 9
 */
public class Array07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] sumArr = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = scanner.nextInt();
            arr[i] = curr;
            if (i == 0) {
                sumArr[i] = curr;
            } else {
                sumArr[i] = curr + sumArr[i - 1];
            }
        }
        while (scanner.hasNextInt()) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if (left == 0) {
                System.out.println(sumArr[right]);
            } else {
                System.out.println(sumArr[right] - sumArr[left - 1]);
            }
        }
    }
}
