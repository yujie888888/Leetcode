package DataStruc_StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class LC950_RevealCardsInIncreasingOrder {
    public static void main(String[] args) {


    }

    /**Queue
     * O(nlogn)
     * O(n)
     * Ideas:
     * 看着很麻烦，但其实只要模拟过程就行了
     *  将输入的牌组 deck 按递增顺序排序。
     *  创建一个队列来保存结果数组的索引顺序。
     *  按顺序取出 deck 中的牌，并按队列中的索引放置在结果数组中。
     *  每放置一张牌后，将队列的下一个索引移到队列末尾，模拟揭示一张牌后将下一张牌放到底部的过程。
     *  重复直到所有牌都被放置在结果数组中。
     */
    public static int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = deck.length;
        for(int i=0; i<n; i++){
            queue.add(i);
        }

        Arrays.sort(deck);
        int[] res = new int[n];

        int i=0;
        while(!queue.isEmpty()){
            res[queue.poll()] = deck[i];
            i++;
            if(!queue.isEmpty()){
                int temp = queue.poll();
                queue.add(temp);
            }
        }
        // System.out.println(Arrays.toString(res));
        return res;
    }

}
