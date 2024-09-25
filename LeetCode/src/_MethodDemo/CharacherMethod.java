package _MethodDemo;

public class CharacherMethod {
    public static void main(String[] args) {
        char ch1 = 'a';
        char ch2 = '1';
        char ch3 = ' ';

        // 判断是否是字母
        System.out.println("Is " + ch1 + " a letter? " + Character.isLetter(ch1)); // true

        // 判断是否是数字
        System.out.println("Is " + ch2 + " a digit? " + Character.isDigit(ch2)); // true

        // 判断是否是字母或数字
        System.out.println("Is " + ch3 + " a letter or digit? " + Character.isLetterOrDigit(ch3)); // false

        // 判断是否是空白字符
        System.out.println("Is " + ch3 + " a whitespace? " + Character.isWhitespace(ch3)); // true

        // 将字符转换为大写
        System.out.println("Uppercase of " + ch1 + ": " + Character.toUpperCase(ch1)); // A

        // 将字符转换为小写
        char ch4 = 'B';
        System.out.println("Lowercase of " + ch4 + ": " + Character.toLowerCase(ch4)); // b

        // 判断是否是大写字母
        System.out.println("Is " + ch4 + " an uppercase letter? " + Character.isUpperCase(ch4)); // true

        // 判断是否是小写字母
        System.out.println("Is " + ch1 + " a lowercase letter? " + Character.isLowerCase(ch1)); // true
    }
}
