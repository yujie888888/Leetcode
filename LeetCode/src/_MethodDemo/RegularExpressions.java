package _MethodDemo;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args){
        /* 验证字符串格式 如验证电子邮件地址、电话号码、IPv4 地址等是否有效 */
        // 普通字符：直接表示它们本身，例如正则表达式 abc 匹配字符串 "abc"。
        // 特殊字符：具有特殊含义的字符。常用的特殊字符如下：
            // .（点）：表示任意‘一个’字符（除了换行符）。
                // 例子：正则表达式 a.b 可以匹配 "acb"、"a1b"，但不能匹配 "ab" 或 "a\nb"。
            // ^（脱字符）：表示字符串的开始。
                // 例子：^abc 表示字符串必须以 "abc" 开头。
            // $（美元符号）：表示字符串的结尾。
                // 例子：abc$ 表示字符串必须以 "abc" 结尾。
            // \（反斜杠）：用于转义特殊字符，使其‘失去’特殊意义。
                // 例子：\. 匹配实际的点字符 .
                // 如果你想在字符串中表示一个反斜杠，你需要使用 \\
        // 字符集：字符集用方括号 [] 表示，表示匹配其中的任意一个字符。
            // [abc]：表示匹配 "a"、"b" 或 "c"。
                // 例子：[abc] 可以匹配 "a"、"b" 或 "c"
            // [a-z]：表示匹配小写字母的任意一个。
                //例子：[a-z] 可以匹配 "a"、"b"、... "z"
            // [0-9]：表示匹配任意一个数字。
                // 例子：[0-9] 可以匹配 "0"、"1"、... "9"
            //  [A-Za-z0-9]：匹配大小写字母和数字
        // 预定义字符集：正则表达式中提供了一些预定义的字符集，简化书写：
            // \d：表示任意‘一个’数字，等价于 [0-9]。
            // \D：表示非数字字符，等价于 [^0-9]。
            // \w：表示字母、数字或下划线，等价于 [A-Za-z0-9_]。
            // \W：表示非字母、数字或下划线的字符。
            // \s：表示任意空白字符（空格、制表符、换行符等）。
            // \S：表示非空白字符。
        // 量词：量词用来指定前面的元素可以出现多少次。
            // *：匹配 前面的元素 0次或 多次。
                // 例子：a* 可以匹配 空字符串、"a"、"aa"、"aaa" 等。
            // +：匹配 前面的元素 1次或 多次。
                // 例子：a+ 可以匹配 "a"、"aa"、"aaa"，但不能匹配空字符串。
            // ?：匹配 前面的元素 0 次或 1 次。
                // 例子：a? 可以匹配空字符串或 "a"。
            // {n}：匹配前面的元素恰好 n 次。
                // 例子：a{3} 匹配 "aaa"。
            // {n,}：匹配前面的元素至少 n 次。
                // 例子：a{2,} 匹配 "aa"、"aaa"、"aaaa" 等。
            // {n,m}：匹配前面的元素至少 n 次，至多 m 次。
                // 例子：a{2,3} 匹配 "aa" 或 "aaa"。
        // 分组和捕获：使用圆括号 () 可以将多个字符组合为一个组，正则表达式可以对组进行操作。
            // ()：用于分组匹配，可以作为整体进行匹配。
                // 例子：(abc)+ 表示 "abc" 这个模式至少出现一次，可以匹配 "abc"、"abcabc" 等。

        // Pattern类常用方法，Pattern用于编译正则表达式
        System.out.println("Pattern常用方法: ");
        // 1.编译给定的正则表达式 Pattern.compile(String regex)
        Pattern pattern1 = Pattern.compile("\\d+"); // 匹配一个或多个数字

        // 2.编译给定的正则表达式，并且可以指定匹配的标志（如忽略大小写等）Pattern.compile(String regex, int flags)
            // Pattern.CASE_INSENSITIVE：忽略大小写
            // Pattern.MULTILINE：启用多行模式
                // 在启用多行模式时，正则表达式的 ^ 和 $ 的行为会有所变化：
                    // ^（行首匹配符）：在多行模式下，^ 会匹配字符串的开头和每一行的开头。
                    // $（行尾匹配符）：在多行模式下，$ 会匹配字符串的结尾和每一行的结尾。
            // Pattern.DOTALL：使 . 能够匹配所有字符，包括换行符
        Pattern pattern2 = Pattern.compile("abc", Pattern.CASE_INSENSITIVE);

        // 3.Pattern.matches(String regex, CharSequence input) 匹配整个输入字符串是否符合给定的正则表达式，返回的是一个 boolean 值
        boolean matches1 = Pattern.matches("\\d+", "12345"); // 返回 true
        System.out.println(matches1);

        // 4.根据正则表达式分割字符串，返回一个字符串数组 Pattern.split(CharSequence input)
        Pattern pattern3 = Pattern.compile("\\s+"); // 以一个或多个空格分割String
        String[] words = pattern3.split("Hello world Java"); // 输出结果：["Hello", "world", "Java"]
        System.out.println(Arrays.toString(words));
        System.out.println("-------------------------------------");


        // Matcher 用于执行匹配操作
        System.out.println("Matcher常用方法: ");
        // 1.Matcher.matches() 检查整个输入字符串是否完全匹配正则表达式
        Pattern pattern4 = Pattern.compile("\\d{5}");
        Matcher matcher2 = pattern4.matcher("12345");
        boolean isMatch = matcher2.matches(); // 返回 true
        System.out.println(isMatch);

        // 2.Matcher.find() 查找输入字符串中是否有符合正则表达式的子字符串，每次调用会找到下一个匹配项
        Pattern pattern5 = Pattern.compile("\\d+");
        Matcher matcher3 = pattern5.matcher("abc123def456");
        while (matcher3.find()) {
            System.out.println(matcher3.group()); // 输出 123 和 456
        }

        // 3.Mather.matches() 和Pattern.matches()方法差不多，用于检查整个输入字符串是否完全匹配正则表达式
        Pattern pattern6 = Pattern.compile("\\d+");
        Matcher matcher4 = pattern6.matcher("123");
        if (matcher4.matches()) {
            System.out.println("Match");
        } else {
            System.out.println("Not Match");
        }

        // 4.Matcher.group() 用于获取匹配到的子字符串（即正则表达式与输入字符串匹配的部分）
            // 当只定义了简单的正则表达式时，group() 会返回匹配的整个子字符串
            // group(int group) 可以用来获取特定组匹配的内容
            Pattern pattern7 = Pattern.compile("(\\d+)-(\\w+)");
            Matcher matcher5 = pattern7.matcher("123-abc");
            if (matcher5.find()) {
                System.out.println(matcher5.group(0));  // 输出 123-abc，整个匹配
                System.out.println(matcher5.group(1));  // 输出 123，第一个捕获组
                System.out.println(matcher5.group(2));  // 输出 abc，第二个捕获组
            }
            // groupCount() 返回正则表达式中的捕获组数量，不包括组 0（整个匹配）
            Pattern pattern8 = Pattern.compile("(\\d+)-(\\w+)");
            Matcher matcher6 = pattern8.matcher("123-abc");
            if (matcher6.find()) {
                System.out.println("捕获组数量: " + matcher6.groupCount());  // 输出 捕获组数量: 2
            }

        // 5.Matcher.replaceAll(String replacement) 将所有匹配的子字符串替换为指定的字符串
        Pattern pattern9 = Pattern.compile("\\d+");
        Matcher matcher7 = pattern9.matcher("abc123def456");
        String result = matcher7.replaceAll("#"); // 结果为 "abc#def#"
        System.out.println(result);

        // 6.Matcher.replaceFirst(String replacement) 将第一个匹配的子字符串替换为指定的字符串

        // 7.Matcher.start() 返回最近一次匹配的子字符串的起始索引

        // 8.Matcher.end() 返回最近一次匹配的子字符串的结束索引

        // 9.Matcher.lookingAt() 检查输入字符串从头开始是否符合正则表达式（不要求整个字符串匹配）
        Pattern pattern10 = Pattern.compile("\\d+");
        Matcher matcher8 = pattern10.matcher("123abc456");
        boolean isLookingAt = matcher8.lookingAt(); // 返回 true
        System.out.println(isLookingAt);

        // 10.Matcher.reset() 重置 Matcher，使其可以从头开始重新匹配
        Pattern pattern11 = Pattern.compile("\\d+");
        Matcher matcher9 = pattern11.matcher("123abc456");
        matcher9.find(); // 找到第一个匹配 "123"
        System.out.println(matcher9.group());
        matcher9.reset(); // 重置 matcher
        matcher9.find(); // 重新查找，依然找到 "123"
        System.out.println(matcher9.group());
        System.out.println("-------------------------------------");


        System.out.println("验证字符串格式: ");
        //判断是不是合法的ipv4地址
        String pattern = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$"; //这里没写0-255的范围
        String ip = "222.222.222.222";
        if (pattern.matches(ip)) {
            System.out.println("Valid IPv4");
        }
        System.out.println("-------------------------------------");


        /* 匹配Character */
        // P151用正则表达式来检查字符串中是否存在3到10个连续的空格
        System.out.println("检查字符串中是否存在3到10个连续的空格: ");
        String text1 = "This is   a test.";    // 3 个空格
        String text2 = "Another test      here."; // 6 个空格
        String text3 = "Not matching spaces here."; // 不符合条件
        String regex = " {3,10}";
        System.out.println(text1.matches(".*" + regex + ".*")); // true
        System.out.println(text2.matches(".*" + regex + ".*")); // true
        System.out.println(text3.matches(".*" + regex + ".*")); // false
        System.out.println("-------------------------------------");


        /* 自定义排序，更多例子见sort.java */
        System.out.println("自定义排序: ");
        // 使用 Lambda 表达式升序排序
        List<Integer> numbers = Arrays.asList(3, 2, 1, 4, 5);
        numbers.sort((a, b) -> a - b);
        // 使用 Lambda 表达式降序排序
        numbers.sort((a, b) -> b - a);
        // 按对象的某个属性升序排序
        List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 35));
        people.sort((p1, p2) -> (p1.getAge() - p2.getAge()));
        //Lambda Expression 的 forEach自定义
        //List,Set 可以用 forEach
        people.forEach(Person -> System.out.println(Person.getName()));
    }
}

//内部类不用加public or private
class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
}