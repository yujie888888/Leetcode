package _MethodDemo;

public class StringMethod {
    public static void main(String[] args) {
        // 1. .indexOf() 查找子字符串或字符在字符串中第一次出现位置的方法
        // indexOf(char ch) 查找字符 ch 在字符串中第一次出现的位置，返回对应的索引 O(n)
        String str = "hello world";
        int index1 = str.indexOf('o'); // 返回 4，'o' 第一次出现的位置

        // indexOf(char ch, int fromIndex) 从指定位置 fromIndex 开始查找字符 ch，返回第一次出现的位置 O(n - fromIndex)
        int index2 = str.indexOf('o', 5); // 返回 7，从索引 5 开始查找

        // indexOf(String str) 查找子字符串 str 在当前字符串中第一次出现的位置，返回其开始索引 O(n * m)
        int index3 = str.indexOf("world"); // 返回 6，'world' 子字符串第一次出现的位置

        // indexOf(String str, int fromIndex) 从指定位置 fromIndex 开始查找子字符串 str，返回第一次出现的位置 O((n - fromIndex) * m)
        int index4 = str.indexOf("world", 7); // 返回 -1，因为从索引 7 开始没有找到 'world'


        // 2. .lastIndexOf(String str) / lastIndexOf(String str, int fromIndex)
        // 返回子字符串 str 在字符串中最后一次出现的位置，或从指定位置 fromIndex 开始向前查找。如果未找到，返回 -1
        String str2 = "hello world";
        int index = str2.indexOf("world"); // 返回 6


        // 3. .valueOf() 将不同类型的数据转换为字符串
            // String.valueOf() 支持以下数据类型的转换：
            // 基本数据类型：int、long、float、double、char、boolean
            // 对象类型：Object（通过调用 toString() 方法）
            // 字符串类型：String（直接返回引用，null 返回 "null"）
            // 字符数组：char[]

        // for null
        String nullStr = null;
        String result2 = String.valueOf(nullStr); // 返回 "null" 字符串

        // 将整数转换为字符串 "123"
        int num = 123;
        String numStr = String.valueOf(num);

        // 4. .toLowerCase() / toUpperCase() 将字符串转换为小写或大写形式
        String lower = str.toLowerCase(); // 返回 "hello world"
        String upper = str.toUpperCase(); // 返回 "HELLO WORLD"

        // 5. .trim()去除字符串首尾的空白字符（包括空格、制表符等）
        String trimmed = str.trim(); // 返回 "hello world"

        // 6. .replace(char oldChar, char newChar) / replace(String target, String replacement)
        // 替换字符串中的所有指定字符或子字符串
        String str4 = "hello";
        String replaced1 = str4.replace('l', 'p'); // 返回 "heppo"
        String replaced2 = str4.replace("ll", "rr"); // 返回 "herro"

        // 7. .split(String regex) / split(String regex, int limit)
        //根据正则表达式将字符串分割为子字符串数组。limit 参数用于限制分割的次数

        // 8. .equals(Object obj) / .equalsIgnoreCase(String anotherString)
        // equals() 比较两个字符串的内容是否相等。equalsIgnoreCase() 忽略大小写进行比较

        // 9. .startsWith(String prefix) / endsWith(String suffix)
        // 判断字符串是否以指定前缀 prefix 开头或以指定后缀 suffix 结尾

        // 10. .isEmpty() / isBlank()
        // isEmpty() 判断字符串是否为空（即长度为 0）。isBlank() 判断字符串是否为空或只包含空白字符

        // 11. .join(CharSequence delimiter, CharSequence... elements)
        // 使用指定的分隔符 delimiter 连接多个字符串，返回连接后的结果
        String joined = String.join(", ", "apple", "banana", "orange"); // 返回 "apple, banana, orange"

        // 12. .matches(String regex)
        // 判断字符串是否匹配给定的正则表达式 regex
        String str5 = "hello123";
        boolean matches = str5.matches("\\w+"); // 返回 true，\\w+ 匹配字母数字字符

        // 13. .compareTo(String anotherString) / compareToIgnoreCase(String str)
        // 按字典顺序比较两个字符串。compareToIgnoreCase() 忽略大小写进行比较

        //14. concatenation
        String x = "10";
        int y = 20;
        String z = x + y;// "1020"

        //15. special charactres
        String txt = "Hel\blo World!";
        System.out.println(txt);
    }
}
