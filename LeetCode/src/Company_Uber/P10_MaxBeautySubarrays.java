package Company_Uber;

public class P10_MaxBeautySubarrays {
    public static void main(String[] args){
     //https://leetcode.com/discuss/interview-question/3922862/Uber-OA
        int[][][] schedules = {
                {{5, 6}, {1, 2}, {3, 4}},
                {{7, 8}, {5, 6}, {6, 7}},
                {{2, 3}, {0, 1}, {4, 5}}
        };
        int k = 4;
        int result = maxBeauty(schedules, k);
        System.out.println(result);
    }
    public static int maxBeauty(int[][][] schedules, int k) {
        int n = schedules.length;
        int[] arr = flattenSchedules(schedules);
        int len = arr.length;
        int[][] dp = new int[k + 1][len + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= len; j++) {
                int sum = 0;
                for (int l = j; l >= i; l--) {
                    sum += arr[l - 1];
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][l - 1] + i * sum);
                }
            }
        }
        return dp[k][len];
    }
    private static int[] flattenSchedules(int[][][] schedules) {
        // Flattening the 3D array into a 1D array
        int len = 0;
        for (int[][] schedule : schedules) {
            len += schedule.length;
        }
        int[] result = new int[len];
        int index = 0;
        for (int[][] schedule : schedules) {
            for (int[] interval : schedule) {
                result[index++] = interval[1] - interval[0];
            }
        }
        return result;
    }
}
