package _MethodDemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonConversion {
    public static void main(String[] args) {
        /* Basic data types */
        /** Basic data Capacity sorting
         *     boolean: 表示真值true或false。
         *     byte: 8位，有符号，范围从-128到127。
         *     short: 16位，有符号，范围从-32,768到32,767。
         *     char: 16位，无符号，范围从0到65,535（用于存储字符）。
         *     int: 32位，有符号，范围从-2^31到2^31-1。
         *     float: 32位，IEEE 754浮点数。
         *     long: 64位，有符号，范围从-2^63到2^63-1。
         *     double: 64位，IEEE 754浮点数。
         */
        //1.自动类型转换;小容量类型可以自动转换为大容量类型(大容量自动容纳小容量)
        int i1 = 100;
        long l1 = i1;
        double d1 = l1;
        float f1 = 1.2f; //float后要加f
        double d2 = f1;
        System.out.println(d2);
        System.out.println("-----------------");
        //2.强制类型转换;大容量类型转换为小容量类型时，需要显式转换，可能导致精度丢失或溢出。
        double d3 = 100.04536254236;
        float f2 = (float) d3;
        System.out.println(f2);
        int i2 = (int) f2;
        System.out.println(i2);
        System.out.println("-----------------");

        /* Reference Types */

        // 1.String<->原始数据类型
        // 1.1.String->原始数据类型
        // 使用每个包装类的parseXXX方法或valueOf方法
        // 1.1.1.String -> int
        String s1 = "12";
        int n1 = Integer.parseInt(s1);
        System.out.println(n1);
        // 1.1.2.String -> double
        String s2 = "123.456789012345";
        double d4 = Double.parseDouble(s2);
        System.out.println(d4);
        System.out.println("-----------------");
        // 1.2.原始数据类型->String
        String s3 = String.valueOf(d3); //方法1
        String s4 = d3 + "";  //方法2 当一个数和一个字符串通过+运算符连接时，数会先被转换成字符串，然后两个字符串会被拼接在一起
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("-----------------");

        // 2.String <-> array
        // 2.1.String -> char[]
        String s5 = "hello";
        char[] chars1 = s5.toCharArray();
        // 2.2.array -> String
        // 2.2.1.new String(chars)  这个方法对于char[]是可以用的，但是对于int[]不可以
        char[] chars2 = {'H', 'e', 'l', 'l', 'o'};
        String s6 = new String(chars2);
        System.out.println(s6);
        // 2.2.2.valueOf()方法 只能是char[],其他是地址
        String s7 = String.valueOf(chars2);
        System.out.println(s7);
        // 2.2.3.Arrays.toString()：返回数组内容的字符串表示形式,没什么编程价值，比较适合调试用
        int[] arr1 = {1, 2, 3};
        String s8 = Arrays.toString(arr1); // 返回"[1, 2, 3]"
        System.out.println(s8);
        //2.2.4 String[]->String
        String[] strs = {"11","aa"};
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        System.out.println(sb);
        System.out.println("-----------------");

        //3.String <-> List<Character>
        //3.1.String -> List<Character>
        //3.1.1.手动遍历，字符串的每个字符并添加到List中。
        String s9 = "hello";
        List<Character> list1 = new ArrayList<>();
        for(char c : s9.toCharArray()) {
            list1.add(c);
        }
        //3.1.2.分割，使用String类的split()方法和Arrays.asList()
        String s10 = "a,b,c";
        List<String> list2 = Arrays.asList(s10.split(","));

        //3.2.List<Character> -> String
        List<Character> charList = new ArrayList<>();
        charList.add('H');
        charList.add('e');
        //3.2.1. 遍历拼接
        StringBuilder sb1 = new StringBuilder();
        for (char ch : charList) {
            sb1.append(ch);
        }
        String s11 = "";
        for (char ch : charList) {
            s11 += ch;
        }
        System.out.println("-----------------");

        //4.array <-> List
        //4.1.array -> List
        //4.1.1.遍历数组并添加到集合
        //4.1.2.Arrays.asList()
        String[] array = new String[]{"a", "b", "c"};
        List<String> list = Arrays.asList(array);
        //4.2.List -> array
        //4.2.1.toArray() String
        String[] array2 = list.toArray(new String[0]);
        //new String[0]是创建了一个长度为0的String数组实例。
        //这个空数组作为toArray方法的参数，其目的是指示toArray方法返回一个String类型的数组。
        //4.2.1.toArray() int
        //直接赋值
        System.out.println("-----------------");

        //5.Array <-> Array
        //5.1.int[] -> String[]
        int[] nums = {10,22,39,455,1115};
        String[] strNums = new String[nums.length];
        for(int i3=0; i3<nums.length; i3++){
            strNums[i3] = String.valueOf(nums[i3]);
        }
    }
}
