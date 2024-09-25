package _MethodDemo;

public class StringBuilderMethod {
    /**StringBuilder
     * StringBuilder是Java中非常常用的一种数据格式，特别是在需要频繁修改字符串内容的场景中
     * StringBuilder是Java中一个可变的字符序列，用于高效地构建字符串。
     * 相比于使用不可变的String类进行连续的字符串连接操作，StringBuilder可以显著提高性能，因为它避免了创建多个临时字符串实例
     */
    public static void main(String[] args) {
         // 创建StringBuilder实例
         StringBuilder sb = new StringBuilder();

         // 指定初始容量
         StringBuilder sbWithCapacity = new StringBuilder(100);

         // 用String初始化
         StringBuilder sbWithString = new StringBuilder("InitialContent");

         //添加内容
         sb.append("Hello");
         sb.append(" ");
         sb.append("World");

         // 连续调用
         sb.append(" ").append(2021);

         // 插入内容到指定位置
         sb.insert(0, "Start");

         // 替换StringBuilder中指定位置的字符串
         System.out.println(sb);
         sb.replace(0, 6, "Finish"); //不包含index end
         System.out.println(sb);

         // set StringBuilder中指定位置的字符
         sb.setCharAt(1, '*');

         // 删除指定位置的字符或子字符串 O(n) coz needs to move other elements
         sb.delete(0, 6);

         // 删除指定位置的字符
         sb.deleteCharAt(0);

         // 翻转字符串
         sb.reverse();

         // 返回StringBuilder中当前字符的数量
         int length = sb.length();

         // 返回其当前的总容量
         int capacity = sb.capacity();

         // 转换成String格式
         String result = sb.toString();
    }
}
