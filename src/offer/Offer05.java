package offer;

/**
 * 替换空格
 * 把传入字符数组中的' '换成'&20',且传入数组保证有足够空间容纳修改后的字符
 */
public class Offer05 {
    public static void main(String[] args) {
        String data = "We are happy.";
        System.out.println(data);
        System.out.println(replaceBlank(data));
    }

    // 双指针从后向前 时间复杂度n
    public static char[] replaceBlank(String data) {
        int newLength = data.replaceAll(" ", "%20").length();
        char[] charArray = data.toCharArray();
        char[] newArray = new char[newLength];
        int i = charArray.length - 1;
        int j = newArray.length - 1;
        while (i >= 0) {
            if (charArray[i] != ' ') {
                newArray[j--] = charArray[i--];
            } else {
                newArray[j--] = '0';
                newArray[j--] = '2';
                newArray[j--] = '%';
                i--;
            }
        }
        return newArray;
    }

}
