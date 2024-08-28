/**
 * 处理一系列操作，这些操作会在一个整数数组上执行。具体的操作有两种类型：
 * +X 操作：将整数 X 添加到数组 numbers 中。数组 numbers 可能包含多个相同的整数。
 * -X 操作：从数组 numbers 中移除所有的整数 X。
 * 在每次操作之后，你需要计算数组 numbers 中满足以下条件的三元组 (x, y, z) 的数量：
 * x - y = diff
 * y - z = diff
 * 即，对于每个三元组 (x, y, z)，满足 x 减去 y 等于 diff，并且 y 减去 z 也等于 diff。
 * 这些三元组中的元素可以重新排列，以满足上述条件。
 * 最后，程序应输出在每次操作后的三元组数量结果，结果应该是一个数组，其中每个元素对应处理完每个查询后的三元组数量
 * Ex:
 * queries = ["+1", "+2", "+3", "-2"]
 * diff = 1
 * 执行过程如下：
 * +1 后，numbers = [1]。没有三元组，输出 0。
 * +2 后，numbers = [1, 2]。没有三元组，输出 0。
 * +3 后，numbers = [1, 2, 3]。满足条件的三元组 (3, 2, 1)，输出 1。
 * -2 后，numbers = [1, 3]。没有三元组，输出 0。
 * 最终输出的结果数组为 [0, 0, 1, 0]
 */
package Company_Databricks;
import java.util.*;

public class P12 {
    /**
     * O(n*m)
     * O(m)
     */
    public static void main(String[] args){
        //String[] queries = new String[]{"+4", "+5", "+6", "+4", "+3", "-4"};
        String[] queries = new String[]{"+1", "+2", "+3", "-2"};
        int diff = 1;
        System.out.println(Arrays.toString(M2(queries,diff)));
    }
    private static int[] M2(String[] queries, int diff){
        Map<Integer, Integer> count = new HashMap<>(); // Frequency of each element
        Map<Integer, Integer> pairCount = new HashMap<>(); // Frequency of pairs (y, z) where y - z = diff
        int totalTriples = 0;
        int[] result = new int[queries.length]; // Result array to store the count of valid triples

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            char op = query.charAt(0);
            int x = Integer.parseInt(query.substring(1));
            if (op == '+') {
                totalTriples += pairCount.getOrDefault(x-2*diff, 0);
                //System.out.println(totalTriples);
                totalTriples += pairCount.getOrDefault(x+diff, 0);
                //System.out.println(totalTriples);
                totalTriples += Math.min(pairCount.getOrDefault(x-diff, 0),pairCount.getOrDefault(x, 0));
                //System.out.println(totalTriples);

                count.put(x, count.getOrDefault(x, 0) + 1);
                System.out.println("count.get(x) is : "+count.get(x));
                pairCount.put(x, count.getOrDefault(x,0) * count.getOrDefault(x+diff, 0));
                System.out.println("pairCount.get(x) is: "+pairCount.get(x));
                pairCount.put(x-diff, count.getOrDefault(x-diff, 0) * count.getOrDefault(x, 0));
            }
            else if (op == '-') {
                totalTriples -= pairCount.getOrDefault(x, 0);
                System.out.println("pre: "+pairCount.get(x));
                totalTriples -= pairCount.getOrDefault(x-2*diff, 0);
                System.out.println("post: "+pairCount.get(x-2*diff));
                totalTriples -= Math.min(pairCount.getOrDefault(x-diff, 0),pairCount.getOrDefault(x, 0));
                System.out.println("mid: "+Math.min(pairCount.getOrDefault(x-diff, 0),pairCount.getOrDefault(x, 0)));
                count.put(x, 0);
                pairCount.put(x, 0);
                pairCount.put(x-diff, 0);
            }
            result[i] = totalTriples;
        }
        return result;
    }
}
