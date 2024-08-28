package _MethodDemo;

public class RegularExpressions {
    public static void main(String[] args){
        //以下是如何在 Java 中使用这个正则表达式来匹配字符串中包含 3 到 10 个连续空格的情况：
        String text1 = "This is   a test.";    // 3 个空格
        String text2 = "Another test      here."; // 6 个空格
        String text3 = "Not matching spaces here."; // 不符合条件

        String regex = " {3,10}";

        System.out.println(text1.matches(".*" + regex + ".*")); // true
        System.out.println(text2.matches(".*" + regex + ".*")); // true
        System.out.println(text3.matches(".*" + regex + ".*")); // false

        //P151
    }
}
