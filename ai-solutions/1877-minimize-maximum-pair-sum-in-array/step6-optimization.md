# Code Optimization Analysis

## 1. Current Approach Analysis

The solution uses a **Greedy + Two-Pointer** approach:

1. **Sort** the array in ascending order - O(n log n)
2. **Pair smallest with largest** using two pointers - O(n)
3. **Track maximum pair sum** during iteration

**Why this works:** To minimize the maximum pair sum, we should balance the pairs by combining the smallest available element with the largest available element. This prevents large elements from being paired together.

**Current Complexity:**
- **Time:** O(n log n) - dominated by sorting
- **Space:** O(1) or O(log n) - depending on sort implementation (Java's dual-pivot quicksort uses O(log n) stack space)

---

## 2. Alternative Approaches

### Approach A: Counting Sort (for constrained input)

Since `nums[i] <= 10^5`, we can use counting sort to achieve O(n + k) time where k = 10^5.

```java
class Solution {
    public int minPairSum(int[] nums) {
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }

        // Rebuild sorted array
        int idx = 0;
        for (int i = 1; i <= 100000; i++) {
            while (count[i]-- > 0) {
                nums[idx++] = i;
            }
        }

        int max = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            max = Math.max(max, nums[l++] + nums[r--]);
        }
        return max;
    }
}
```

### Approach B: Counting Sort without Rebuilding Array

```java
class Solution {
    public int minPairSum(int[] nums) {
        int[] count = new int[100001];
        int minVal = Integer.MAX_VALUE, maxVal = 0;

        for (int num : nums) {
            count[num]++;
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        int max = 0;
        int l = minVal, r = maxVal;
        int leftCount = 0, rightCount = 0;

        while (l <= r) {
            // Move left pointer to next available element
            while (l <= r && count[l] == 0) l++;
            // Move right pointer to next available element
            while (l <= r && count[r] == 0) r--;

            if (l > r) break;

            max = Math.max(max, l + r);
            count[l]--;
            count[r]--;
        }
        return max;
    }
}
```

---

## 3. Micro-Optimizations for Current Solution

```java
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int n = nums.length;
        // Micro-opt 1: Cache array length
        // Micro-opt 2: Use n/2 iterations instead of pointer comparison
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int sum = nums[i] + nums[j];
            if (sum > max) max = sum;  // Micro-opt 3: Avoid method call overhead
        }
        return max;
    }
}
```

**Optimizations applied:**
1. Cache `nums.length` to avoid repeated field access
2. Replace `Math.max()` with direct comparison (JIT usually inlines this, but helps in some cases)
3. Use `for` loop for cleaner iteration

---

## 4. Comparison Table

| Approach | Time Complexity | Space Complexity | Best When |
|----------|-----------------|------------------|-----------|
| **Current (Arrays.sort)** | O(n log n) | O(log n) | General purpose, small k |
| **Counting Sort + Rebuild** | O(n + k) | O(k) | n >> log(k), k = 10^5 |
| **Counting Sort (no rebuild)** | O(n + k) | O(k) | Large n, bounded values |

**Practical Performance (n = 10^5, k = 10^5):**

| Approach | Estimated Operations | Memory |
|----------|---------------------|--------|
| Arrays.sort | ~1.7M comparisons | ~400 KB |
| Counting Sort | ~200K operations | ~400 KB |

---

## 5. Recommendation

**For this specific problem:** The **current solution is optimal** for practical purposes.

**Reasoning:**
1. **n and k are comparable** (both up to 10^5), so O(n log n) vs O(n + k) difference is marginal
2. `Arrays.sort()` uses highly optimized dual-pivot quicksort with excellent cache locality
3. Counting sort has a larger constant factor and uses more memory
4. The current solution is cleaner and more maintainable

**When to switch to Counting Sort:**
- If n >> k (e.g., n = 10^7 with k = 10^5)
- If the constraint on `nums[i]` is much smaller (e.g., k = 1000)

**Final verdict:** Keep the current implementation. It achieves the theoretical optimum for comparison-based sorting while being concise and readable. The only micro-optimization worth considering is the direct comparison instead of `Math.max()`, but JIT compilation typically handles this automatically.
