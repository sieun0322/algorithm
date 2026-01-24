# LeetCode 1877 - Minimize Maximum Pair Sum in Array

## 1. Key Observations

1. **Greedy Pairing Insight**: To minimize the maximum pair sum, we should avoid pairing two large numbers together. If we pair the two largest numbers, their sum would be unnecessarily large.

2. **Balance Strategy**: The optimal approach is to "balance" each pair by combining a large number with a small number. This prevents any single pair from having an excessively large sum.

3. **Sorted Array Property**: If we sort the array, pairing the smallest with the largest, second smallest with second largest, etc., achieves this balance optimally.

4. **Proof of Optimality**: Consider sorted array [a, b, c, d] where a <= b <= c <= d.
   - Pairing (a,d) and (b,c) gives max of {a+d, b+c}
   - Any other pairing like (a,b) and (c,d) gives max of {a+b, c+d} = c+d, which is >= a+d and >= b+c
   - The greedy approach ensures no pair is "overloaded" with two large values

5. **Single Pass After Sort**: Once sorted, we only need to check pairs at indices (0, n-1), (1, n-2), etc., and track the maximum sum among these pairs.

## 2. Algorithm Choice

**Algorithm: Sorting + Two-Pointer Greedy**

**Approach:**
1. Sort the array in ascending order
2. Use two pointers: one at the start (left) and one at the end (right)
3. Pair elements at left and right pointers, compute their sum
4. Track the maximum pair sum encountered
5. Move left pointer forward and right pointer backward
6. Continue until all pairs are processed

**Justification based on constraints:**
- **n <= 10^5**: Sorting with O(n log n) is well within acceptable limits
- **Simple implementation**: Two-pointer technique after sorting is straightforward and efficient
- **No extra data structures needed**: Only need to track the running maximum
- **Greedy correctness**: Mathematical proof shows this pairing strategy is optimal

## 3. Time & Space Complexity

| Metric | Complexity | Justification |
|--------|------------|---------------|
| **Time** | O(n log n) | Dominated by sorting; the two-pointer traversal is O(n) |
| **Space** | O(1) or O(log n) | O(1) extra space for the algorithm itself; O(log n) for typical in-place sorting recursion stack |

**Constraint Validation:**
- With n = 10^5, we have approximately 10^5 × 17 ≈ 1.7 × 10^6 operations for sorting
- This easily completes within typical time limits (< 100ms)
- Memory usage is minimal, well under any reasonable limit
