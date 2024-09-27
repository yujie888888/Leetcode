package DataStruc_String;
import java.util.HashMap;

public class LC12_IntegertoRoman {
    public static void main(String[] args) {

    }
    /**Greedy
     * O(n)
     * o(1)
     * Ideas:
     * 对于每个值，尽可能多次使用它，直到不能再使用为止。
     * 使用 HashMap 存储所有可能的罗马数字符号及其对应的整数值。
     * 创建一个 values 数组，包含所有可能的整数值，从大到小排序。
     * 遍历：
     *      从最大的值开始，逐个遍历 values 数组。
     *      对于每个值，重复执行以下步骤，直到输入的数字小于当前值：
     *          a. 将对应的罗马数字符号添加到结果字符串中。
     *          b. 从输入数字中减去当前值。
     * 特殊情况处理：
     * 通过在 HashMap 和 values 数组中包含特殊情况（如 900、400 等），巧妙地处理了罗马数字中的减法规则。
     * 结果构建：
     * 使用 StringBuilder 高效地构建最终的罗马数字字符串。
     * 终止条件：
     * 当输入数字变为 0 时，算法自然结束。
     */
    public static String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5, "V");
        map.put(9,"IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500,"D");
        map.put(900, "CM");
        map.put(1000, "M");

        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder res = new StringBuilder();
        for(int value : values){
            //System.out.println(value);
            while(num >= value){
                res.append(map.get(value));
                num -= value;
                // System.out.println(num);
                // System.out.println(res);
                // System.out.println("--------");
            }
        }
        return res.toString();
    }
}
