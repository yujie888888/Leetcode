package ALG_Greedy;

public class LC556_NextGreaterElementIII {
    public static void main(String[] args) {

    }

    /**Greedy
     * O(n^2)
     * O(n)
     * Ideas:
     * 和P31思路是一样的，处理上麻烦点
     *  计算输入整数n的位数（len）
     *  将整数n转换为数字数组digits，每个元素代表n的一位数字。
     *  从右向左遍历digits数组，寻找第一个比右边数字小的位置i：
     *      如果找到
     *          从右向左查找第一个大于digits[i]的数字，将其与digits[i]交换。
     *          将i+1到数组末尾的部分反转，使其变为升序。
     *      如果没找到，说明整个数组是降序的，无法得到更大的数，直接返回-1。
     *  将修改后的digits数组转换回整数。
     *  如果得到的数大于原数n，则返回这个数；否则返回-1。
     * 这个算法的核心思想是找到可以增大的最右边的位置，然后将其与右边刚好大于它的数字交换，
     * 最后将右边部分重新排序为最小的排列。这样可以保证得到的数是大于n的最小数
     */
    public int nextGreaterElement(int n) {
        int len = 0;
        int temp = n;
        while (temp > 0) {
            temp /= 10;
            len++;
        }
        int[] digits = new int[len];
        int temp1 = n;
        for (int i = len-1; i >= 0; i--) {
            digits[i] = temp1 % 10;
            temp1 /= 10;
        }
        // System.out.println(Arrays.toString(digits));

        for (int i = len-2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                for (int j = len-1; j >= 0; j--) {
                    if (digits[j] > digits[i]) {
                        int temp2 = digits[i];
                        digits[i] = digits[j];
                        digits[j] = temp2;
                        break;
                    }
                }
                if (i + 1 < len) {
                    int left = i + 1;
                    int right = len - 1;
                    while (left < right) {
                        int temp2 = digits[left];
                        digits[left] = digits[right];
                        digits[right] = temp2;
                        left++;
                        right--;
                    }
                }
                break;
            }
        }
        // System.out.println(Arrays.toString(digits));

        int res = 0;
        int time = 1;
        for (int i = len - 1; i >= 0; i--) {
            res += digits[i] * time;
            time *= 10;
        }
        if(res > n) return res;
        return -1;
    }
}
