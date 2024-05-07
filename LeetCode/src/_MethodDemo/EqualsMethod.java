package _MethodDemo;
import java.util.ArrayList;
import java.util.Arrays;

public class EqualsMethod {
    public static void main(String[] args) {
        // equals() 方法是 Object 类的一个方法，用于判断两个对象是否“等价”
        // 不同的数据类型或类可以根据自己的需求重写 equals() 方法，来实现特定的等价逻辑

        /**1.Basic data types
         * 如int,char,double
         * 要比较"值"，直接使用==.
         */
        int num1 = 1;
        int num2 = 2;
        System.out.println(num1 == num2);
        System.out.println("===============");

        /**2.Wrapper Classes
         * 如Integer,Character,Double
         * equals()方法被重写,以提供"值"的比较而不是引用的比较
         */
        //Integer x = new Integer(5);
        //Integer y = new Integer(5);
        //System.out.println(x.equals(y));  // 输出 true，因为值相同
        //System.out.println("===============");

        /**3.String 类
         * String的'=='比较"引用"
         * String 类的equals()比较两个字符串对象的"内容"是否相同。
         */
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("===============");

        /**4.Array数组
         * 数组使用'=='比较"引用"
         * 数组使用Object的默认'equals()'方法比较"引用"
         * 使用'Arrays.equals()'比较数组"内容"
         */
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        System.out.println(array1 == array2);
        System.out.println(array1.equals(array2));
        System.out.println(Arrays.equals(array1,array2));
        System.out.println("===============");

        /**5.Collection Classes
         * 如ArrayList, LinkedList, HashSet, HashMap
         * equals() 方法提供集合"内容"的比较(相同的元素和相同的顺序)
         */
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(list1 == list2);
        System.out.println(list1.equals(list2));
        System.out.println("===============");
    }
}
