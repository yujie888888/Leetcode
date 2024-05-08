package _MethodDemo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintDemo {
    public static void main(String[] args) {
        //1.基本数据类型+String,直接输出
        int i = 0;
        System.out.print(i);
        System.out.println("----------------------");

        //2.Array
        //2.1.循环输出数组元素
        int[] arr1 = {1,2,3};
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        //2.2.转换成list直接输出list
        Integer[] integerArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.asList(integerArray));
        System.out.println("----------------------");

        //3.集合,直接输出,适用类型:List, Set, Map
        Map<String, Integer> map = new HashMap<>();
        map.put("a",11);
        map.put("b",22);
        map.put("c",33);
        System.out.println(map);
    }
}
