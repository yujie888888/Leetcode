package Company_IBM;

public class FlippedtoMakeElementsEqual {
    public static void main(String[] args) {

    }
    static int makeEqual(int arr[], int n)
    {
        // 存1的数量
        int fre0[] = new int[33];

        // 存2的数量
        int fre1[] = new int[33];

        // Traverse the array
        for(int i = 0; i < n; i++){
            int x = arr[i];
            // Traverse the bit of arr[i]
            for(int j = 0; j < 33; j++){
                // If current bit is set
                if ((x & 1) != 0){
                    // Increment fre1[j]
                    fre1[j] += 1;
                }
                else{
                    // Increment fre0[j]
                    fre0[j] += 1;
                }
                // Right shift x by 1
                x = x >> 1;
            }
        }
        // Stores the count of total moves
        int ans = 0;

        // Traverse the range [0, 32]
        for(int i = 0; i < 33; i++){
            // Update the value of ans
            ans += Math.min(fre0[i], fre1[i]);
        }
        // Return the minimum number of
        // flips required
        return ans;
    }
}
