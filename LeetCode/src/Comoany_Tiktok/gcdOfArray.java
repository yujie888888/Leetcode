package Comoany_Tiktok;

public class gcdOfArray {
    /**求一个array的公约数
     * O(n*loga)
     * 先找一个gcd出来，再将这个结果与下一个num找gcd
     */
    public static void main(String[] args){
        int[] nums = new int[]{3,9,6,36};
        int res = nums[0];
        if(nums.length==1){
            System.out.println(nums[0]);
            return;
        }
        for(int i=1; i<nums.length; i++){
            res = gcd(res,nums[i]);
            if(res == 1) break;
        }
        System.out.println(res);
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
