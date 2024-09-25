package ALG_DynamicProgramming;

public class LC1011_CapacityToShipPackages {
    public static void main(String[] args) {

    }
    public int shipWithinDays(int[] weights, int days) {
        // binary search + 模拟过程
        int max = 0;
        int sum = 0;
        for(int num : weights){
            max = Math.max(num,max);
            sum += num;
        }
        int left = max;
        int right = sum;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;
            int daysNeed = 1;
            int curWeight = 0;
            for(int num : weights){
                if(curWeight + num > mid){
                    daysNeed ++;
                    curWeight = 0;
                }
                curWeight += num;
            }
            if(daysNeed > days){
                left = mid+1;
            }
            else{
                right = mid-1;
                res = Math.min(res,mid);
            }
        }
        return res;
    }
}
