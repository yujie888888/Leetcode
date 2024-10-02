package Topic_Math;

import java.util.ArrayList;
import java.util.List;

public class LC1492_ThekthFactorofn {
    public static void main(String[] args) {

    }

    /**
     * O(n)
     * 简单，找perfect factor，返回第k个
     */
    public int kthFactor(int n, int k) {
        List<Integer> factor = new ArrayList<>();
        for(int i=1; i<=Math.sqrt(n); i++) {
            if (n % i == 0) {
                factor.add(i);
            }
        }
//        for(int i=1; i<=Math.sqrt(n); i++){
//            if(n % i == 0){
//                factor.add(i);
//                if(i != n/i) factor.add(n/i);
//            }
//        }
        if(k > factor.size()) return -1;
        Object[] factors = factor.toArray();
        return (int)factors[k-1];
    }
}
