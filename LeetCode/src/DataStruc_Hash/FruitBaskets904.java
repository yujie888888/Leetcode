package DataStruc_Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * Example 1:
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * Constraints:
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 */
public class FruitBaskets904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the tree array:");
        String inputLine = sc.nextLine();
        String[] line = inputLine.split(",");
        int[] treeArray = new int[line.length];
        for (int i = 0; i < treeArray.length; i++) {
            treeArray[i] = Integer.parseInt(line[i]);
        }

        System.out.println(searchMax(treeArray));
    }

    /**滑动窗口+HashMap
     * 这道题用HashMap简直是天才，可以简化很多
     */
    /*
    hashmap basket //存储水果种类和数量，每次basket添加pair默认包含了对length的操作
    max-len = 0;
    while(right<lenth){
        //add value, 这一步很关键，对于每棵新树，right把它放进basket中，这时如果这棵树不存在键值对，那么默认这个种类的水果数量为0+1；如果存在就是在现在的值上+1
        basket.add(tree[right], basket.getOrDefault(tree[right],0)+1);
        //right加完新树之后，不知道是不是新种类还是旧种类
        //直接判断busket的size，因为每次添加新的树的时候，就已经进行了逻辑判断：是新种类，添加键值对；旧的种类，该水果数量+1
        while(basket.size()>2){
            //很关键的步骤
            //当basket数量不够的时候，left就要缩小窗口了,left++。但是同时也代表着left指向的这个种类的水果必须从basket中删除，所以要对basket进行操作后，才满足left++的条件
            //要将left指向的这种水果从basket中删除，不能直接remove，必须将left指针移动到不再指向这种水果为止，这时left指针的位置是对的，再remove掉这种水果
            //left移动之前，将原来的left对应的水果数量-1，之后left才可以移动
            basket.put(tree[left],basket.get(tree[left])-1);
            //在left移动之前，还要判断，这个时候left指向的水果数量是否为0了，也就是不存在这种水果了，也就是left指针的位置到了正确的位置上了，这时就可以remove这个left对应的键值对了
            if(basket.get(tree[left] == 0)  basket.remove(tree[left]);
            //left++这句话不能放在判断条件之前，因为需要left指向的位置，不然会出错
            left++;
            }
        //这一步比较大小必须放在right++之前，因为不知道right++之后basket是不是还满足条件了
        max_len = max_len>(right-left+1) ? max_len : (right-left+1);
        right++;
     */
    private static int searchMax(int[] tree) {
        int left = 0;
        int right = 0;
        int max_len = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        while (right < tree.length) {
            basket.put(tree[right], basket.getOrDefault(tree[right],0)+1);

            while(basket.size()>2){
                basket.put(tree[left],basket.get(tree[left])-1);
                if(basket.get(tree[left]) == 0) basket.remove(tree[left]);
                left ++;
            }

            max_len = max_len>(right-left+1) ? max_len : (right-left+1);
            right++;
        }
        return max_len;
    }








}
