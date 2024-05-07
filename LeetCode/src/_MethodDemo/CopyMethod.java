package _MethodDemo;
import java.util.Arrays;

public class CopyMethod {
    public static void main(String[] args) {
        //复制数组的部分或全部内容
        //1.System.arraycopy() 它是本地实现的，因此速度比纯Java代码快很多;适合于大量数据的快速复制;本方法没有返回值;
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[3];
        // 参数依次为：源数组，源数组中的起始位置，目标数组，目标数组中的起始位置，要复制的数组元素的数量。
        System.arraycopy(src, 2, dest, 0, 3);
        //printArray(dest);

        //2.Arrays.copyOf() 从头复制数组的指定长度;同时它可以处理类型转换(例如从 int 到 Integer)；它返回一个新的数组对象;
        int[] original1 = {1, 2, 3, 4, 5};
        int[] copied1 = Arrays.copyOf(original1, 3);
        //printArray(copied1);

        //3.Arrays.copyOfRange() 复制数组的一部分，包括起始索引，不包括结束索引
        int[] original2 = {1, 2, 3, 4, 5};
        int[] rangeCopied = Arrays.copyOfRange(original2, 2, 5);
        //printArray(rangeCopied);

        //4.clone() 创建一个新的数组副本
        int[] original = {1, 2, 3, 4, 5};
        int[] cloned = original.clone();
    }
    public static void printArray(int[] array){
        int i=0;
        System.out.print("[");
        while(i<array.length){
            System.out.print(i==array.length-1 ? array[i] : array[i]+",");
            i++;
        }
        System.out.print("]");
    }
}
