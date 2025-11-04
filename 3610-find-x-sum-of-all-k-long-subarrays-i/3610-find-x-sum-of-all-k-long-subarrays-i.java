class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[Math.max(0, n - k + 1)];
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < k; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        ans[0] = computeXSum(count, x);

        for (int i = k; i < n; i++) {
            int add = nums[i];
            int rem = nums[i - k];

            count.put(add, count.getOrDefault(add, 0)+1);
            int fr = count.get(rem) - 1;
            if (fr == 0) count.remove(rem);
            else count.put(rem, fr);

            ans[i - k + 1] = computeXSum(count, x);
        }

        return ans;
    }

    private int computeXSum(Map<Integer, Integer> freq, int x) {
        List<int[]> items = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            items.add(new int[]{e.getKey(), e.getValue()});
        }
        items.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        });
        long sum = 0;
        int take = Math.min(x, items.size());
        for (int i = 0; i < take; i++) {
            sum += 1L * items.get(i)[0] * items.get(i)[1];
        }
        return (int) sum;
    }
}