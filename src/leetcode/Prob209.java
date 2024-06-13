package leetcode;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class Prob209 {
    public static void main(String[] args) {
        System.out.println(new Prob209().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLen = nums.length + 1;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= target && left < right) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left++];
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
