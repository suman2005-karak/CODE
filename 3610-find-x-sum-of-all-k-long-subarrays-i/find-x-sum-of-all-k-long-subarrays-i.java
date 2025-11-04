import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            // Frequency map for subarray nums[i..i+k-1]
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Convert map entries to list and sort
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }

            // Sort by: frequency descending, then value descending
            Collections.sort(list, (a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            // Take top x most frequent and sum them (by expanding occurrences)
            Set<Integer> top = new HashSet<>();
            for (int t = 0; t < Math.min(x, list.size()); t++) {
                top.add(list.get(t)[0]);
            }

            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (top.contains(nums[j])) sum += nums[j];
            }

            ans[i] = sum;
        }

        return ans;
    }
}
