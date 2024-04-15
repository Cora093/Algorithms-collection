package offer;

import java.util.Arrays;

/**
 * 找出数组中重复的数字
 * 一个长度为n的数组，值的范围在0~n-1内，有一个或多个数字重复，求其中任意一个
 */
public class Offer03 {

    public static void main(String[] args) {
        int[] data = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(getDuplication1(data));
        System.out.println(getDuplication2(data));
        System.out.println(getDuplication3(data));

        int[] data1 = {2, 3, 1, 0, 4, 5, 5};
        System.out.println(getDuplication1(data1));
        System.out.println(getDuplication2(data1));
        System.out.println(getDuplication3(data1));
    }

    // 解法1 排序
    public static int getDuplication1(int[] data) {

        Arrays.sort(data);
        for (int i = 1; i < data.length; i++) {
            if (data[i] == data[i - 1]) {
                return data[i];
            }
        }
        return -1;
    }

    // 解法2 哈希表
    public static int getDuplication2(int[] data) {

        int[] hashTable = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (hashTable[data[i]] == 0) {
                hashTable[data[i]] = 1;
            } else {
                return data[i];
            }
        }
        return -1;
    }

    // 解法3 根据数字特点排序，会修改原始数据
    public static int getDuplication3(int[] data) {
        for (int i = 0; i < data.length; i++) {
            while (data[i] != i) {
                if(data[i] == data[data[i]]) {
                    return data[i];
                } else {
                    data[i] = data[i] ^ data[data[i]];
                    data[data[i]] = data[i] ^ data[data[i]];
                    data[i] = data[i] ^ data[data[i]];
                }
            }
        }
        return -1;
    }
}
