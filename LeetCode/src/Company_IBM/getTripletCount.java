package Company_IBM;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 * 给你一个arr表示每天股票价格的数组。
 * 一位投资者想要购买三只股票，使得选定三天的成本总和可以被给定的整数整除d。
 * 您需要找出不同三元组的数量，(i, j, k)使得 的i < j < k和arr[i] + arr[j] + arr[k]可以被 整除d。
 * 例子：
 * 给定arr = [3, 3, 4, 7, 8]和d = 5，以下三元组有一个可被整除的和5：
 * 带索引的三元组(0, 1, 2)→ 和 = 3 + 3 + 4 = 10（可被 5 整除）
 * 带索引的三元组(0, 2, 4)→ 和 = 3 + 4 + 8 = 15（可被 5 整除）
 * 带索引的三元组(1, 2, 4)→ 和 = 3 + 4 + 8 = 15（可被 5 整除）
 * 因此答案是 3。
 * 功能描述：
 * 完成功能getTripletCount。
 * 此函数必须返回一个整数，表示不同三元组的总数，其中和可以被 整除d。
 */
public class getTripletCount {
    public static void main(String[] args) {
//        int[]arr = new int[]{3, 3, 4, 7, 8};
//        int d = 5;
//        int[]arr = new int[]{1, 2, 3, 4, 5, 6};
//        int d = 5;

        int[]arr = new int[]{6, 2, 8, 4, 10};
        int d = 6;

        //res = 0;
        res.clear();
        backtracking(arr,d,0,0,0);
        System.out.println(res);
    }
    //static int res = 0;
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> resL = new ArrayList<>();
    private static void backtracking(int[]arr, int d, int sum, int l, int start){
        if(l == 3){
            if(sum % d == 0){
                res.add(new ArrayList<>(resL));
                return;
            }
            return;
        }

        for(int i=start; i<arr.length; i++){
            resL.add(arr[i]);
            backtracking(arr,d,sum+arr[i], l+1,i+1);
            resL.remove(resL.size()-1);
        }
    }
}
