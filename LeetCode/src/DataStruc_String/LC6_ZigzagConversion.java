package DataStruc_String;

public class LC6_ZigzagConversion {
    public static void main(String[] args) {

    }

    /**Mock Process
     * O(n)
     * O(n)
     * Ideas:
     * 初始化：创建 numRows 个 StringBuilder 对象的数组，用于存储变换后的每一行。
     * 主循环：遍历输入字符串 s，使用 index 追踪当前字符位置。
     *      向下遍历：
     *          从上到下遍历 numRows 行，将字符依次添加到对应的 StringBuilder 中。
     *          这形成了 "Z" 字形的竖直部分。
     *      斜向上遍历：
     *          从倒数第二行开始，向上遍历到第二行，将字符添加到对应的 StringBuilder 中。
     *          这形成了 "Z" 字形的斜线部分。
     *      重复步骤 3 和 4，直到处理完所有字符。
     * 合并结果：将所有 StringBuilder 中的内容合并成一个字符串。
     */
    public static String convert(String s, int numRows) {
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) res[i] = new StringBuilder();
        int n = s.length();

        int index = 0;
        while (index < n) {
            for (int i = 0; i < numRows && index < n; i++) {
                res[i].append(s.charAt(index));
                index++;
            }
            for (int j = numRows - 2; j > 0 && index < n; j--) {
                res[j].append(s.charAt(index));
                index++;
            }
        }

        StringBuilder res1 = new StringBuilder();
        for(StringBuilder sb : res){
            res1.append(sb);
        }
        return res1.toString();
    }
}
