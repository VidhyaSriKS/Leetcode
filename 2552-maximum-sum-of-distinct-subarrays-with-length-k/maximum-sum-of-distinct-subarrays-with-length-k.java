import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long maxRes = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // If window size exceeds k, shrink from the left
            if (r - l + 1 > k) {
                int leftVal = nums[l];
                sum -= leftVal;
                map.put(leftVal, map.get(leftVal) - 1);
                if (map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }
                l++;
            }

            // If window size is exactly k and all elements are distinct
            if (r - l + 1 == k && map.size() == k) {
                maxRes = Math.max(maxRes, sum);
            }
        }

        return maxRes;
    }
}