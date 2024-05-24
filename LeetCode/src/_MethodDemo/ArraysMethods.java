package _MethodDemo;
import java.util.Arrays;
import java.util.List;

public class ArraysMethods {
    public static void main(String[] args) {
        // 对数组进行升序排序
        int[] numbers = {3, 1, 4, 1, 5, 9};
        Arrays.sort(numbers); // 排序后： [1, 1, 3, 4, 5, 9]
        //System.out.println("排序后: " + Arrays.toString(numbers));

        // 使用二分搜索法在「数组」中查找指定值
        int index = Arrays.binarySearch(numbers, 4); // 找到索引：3
        //System.out.println("值 4 的索引: " + index);

        // 复制指定数组，并截取或填充到指定长度
        int[] copy = Arrays.copyOf(numbers, 5); // 复制后的数组：[1, 1, 3, 4, 5]
        //System.out.println("复制后的数组: " + Arrays.toString(copy));

        // 复制数组的指定范围
        int[] rangeCopy = Arrays.copyOfRange(numbers, 1, 4); // 复制范围后的数组：[1, 3, 4]
        //System.out.println("复制范围后的数组: " + Arrays.toString(rangeCopy));

        // 比较两个数组是否相等
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        boolean isEqual = Arrays.equals(a, b); // true
        //System.out.println("数组 a 和 b 是否相等: " + isEqual);

        // 用指定值填充数组
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 42); // 填充后的数组：[42, 42, 42, 42, 42]
        //System.out.println("填充后的数组: " + Arrays.toString(fillArray));

        // 返回数组内容的字符串表示形式
        String arrayString = Arrays.toString(a); // "[1, 2, 3]"
        System.out.println(arrayString);

        // 将数组转换为 List
        String[] names = {"Alice", "Bob", "Charlie"};
        List<String> nameList = Arrays.asList(names); // ["Alice", "Bob", "Charlie"]
        //System.out.println("数组转换为 List: " + nameList);

        // 深度比较两个数组是否相等（适用于多维数组）
        Integer[][] deepArray1 = {{1, 2}, {3, 4}};
        Integer[][] deepArray2 = {{1, 2}, {3, 4}};
        boolean isDeepEqual = Arrays.deepEquals(deepArray1, deepArray2); // true
        //System.out.println("多维数组 deepArray1 和 deepArray2 是否深度相等: " + isDeepEqual);

        // 返回多维数组内容的字符串表示形式
        String deepArrayString = Arrays.deepToString(deepArray1); // "[[1, 2], [3, 4]]"
        //System.out.println("多维数组 deepArray1 的字符串表示形式: " + deepArrayString);

        // 使用并行排序算法对数组进行排序
        int[] parallelNumbers = {3, 1, 4, 1, 5, 9};
        Arrays.parallelSort(parallelNumbers); // 排序后：[1, 1, 3, 4, 5, 9]
        //System.out.println("并行排序后: " + Arrays.toString(parallelNumbers));

        // 找到两个数组不匹配的第一个索引
        int[] mismatchArray1 = {1, 2, 3};
        int[] mismatchArray2 = {1, 2, 4};
        int mismatchIndex = Arrays.mismatch(mismatchArray1, mismatchArray2); // 2
        //System.out.println("数组 mismatchArray1 和 mismatchArray2 的第一个不匹配索引: " + mismatchIndex);
    }
}
