package Struc_Heap;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {

    }
    // 注意实现字典序和freq排序
    // Beats 99%
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> hashmap = new HashMap<>();
        for(String str : words){
            hashmap.put(str, hashmap.getOrDefault(str, 0)+1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> {
            int order = hashmap.get(b)-(hashmap.get(a));
            if(order == 0) return a.compareTo(b);
            return order;
        }
        );
        maxHeap.addAll(hashmap.keySet());
        List<String> res = new ArrayList<>();
        while(k>0){
            res.add(maxHeap.poll());
            k--;
        }
        return res;
    }
}
