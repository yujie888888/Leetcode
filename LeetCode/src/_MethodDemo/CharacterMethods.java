package _MethodDemo;
public class CharacterMethods {
    public static void main(String[] args) {
        //isLetter(char ch)：检查指定的字符是否是字母。
        boolean result1 = Character.isLetter('a'); // true

        //isDigit(char ch)：检查指定的字符是否是数字。
        boolean result2 = Character.isDigit('1'); // true

        //isLetterOrDigit(char ch)：检查指定的字符是否是字母或数字。
        boolean result3 = Character.isLetterOrDigit('a'); // true
        boolean result4 = Character.isLetterOrDigit('1'); // true

        //isAlphabetic(int codePoint)：检查指定的字符（Unicode代码点）是否是字母。
        boolean result7 = Character.isAlphabetic('a'); // true

        //isWhitespace(char ch)：检查指定的字符是否是空白字符（如空格、制表符等）
        boolean result5 = Character.isWhitespace(' '); // true

        //toUpperCase(char ch)：将指定的字符转换为大写形式。
        char upper = Character.toUpperCase('a'); // 'A'

        //toLowerCase(char ch)：将指定的字符转换为小写形式。
        char lower = Character.toLowerCase('A'); // 'a'

        //isUpperCase(char ch)：检查指定的字符是否是大写字母。
        boolean result = Character.isUpperCase('A'); // true

        //isLowerCase(char ch)：检查指定的字符是否是小写字母。
        boolean result6 = Character.isLowerCase('a'); // true

        //isSpaceChar(char ch)：检查指定的字符是否是空格字符。
        boolean result8 = Character.isSpaceChar(' '); // true

        //codePointAt(CharSequence seq, int index)：返回指定索引处的字符（Unicode代码点）。
        int codePoint = Character.codePointAt("hello", 1); // 'e' -> 101

        //isTitleCase(char ch)：检查指定的字符是否是标题大小写字符。
        boolean result9 = Character.isTitleCase('ǅ'); // true

        //isDefined(char ch)：检查指定的字符是否在Unicode标准中定义。
        boolean result10 = Character.isDefined('a'); // true

        //isSurrogate(char ch)：检查指定的字符是否是Unicode代理字符。
        boolean result11 = Character.isSurrogate('\uD800'); // true

        //charCount(int codePoint)：返回用于表示指定的Unicode代码点的字符数（1或2）。
        int count = Character.charCount(0x1F600); // 2
    }
}
