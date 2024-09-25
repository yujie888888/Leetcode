package Topic_Others;

public class LC136_SingleNumber {
    public static void main(String[] args) {

    }

    /**
     * 好有意思的题，用XOR
     * XOR：
     * 交换律：A ^ B = B ^ A
     * 结合律：(A ^ B) ^ C = A ^ (B ^ C)
     * 恒等性：A ^ 0 = A  任何数与 0 异或都等于它自己。
     * 自反性：A ^ A = 0  任何数与自己异或都等于 0。
     * 自消性：(A ^ B) ^ B = A 连续异或同一个值两次，会抵消这个操作。
     * 补码关系：A ^ 1111...1 = ~A  与全 1 异或相当于取反。
     * 交换变量值：可以用来在不使用临时变量的情况下交换两个变量的值。
     * 序列异或：如果一个序列中每个元素都出现偶数次，那么整个序列的异或结果为 0。
     * 与加法的关系：对于单个位，A ^ B = (A + B) % 2 异或可以看作是不进位的加法。
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res = res^num;
        }
        return res;
    }
}
