# Problem Interpretation: LeetCode 1877 - Minimize Maximum Pair Sum in Array

## 1. Problem Restatement

You are given an array of integers with an **even number of elements**. Your task is to pair up all the elements into groups of two, where:
- Every element must be used exactly once
- Every element belongs to exactly one pair
- You end up with exactly n/2 pairs (where n is the array length)

Each pair has a "pair sum" (the sum of its two elements). Among all the pairs you create, there will be a maximum pair sum. Your goal is to find a way to pair the elements such that this maximum pair sum is **as small as possible**.

You need to return what that minimized maximum pair sum is.

## 2. Input Format

- **nums**: An integer array of even length n
- Example: `[3, 5, 2, 3]`

## 3. Output Format

- A single integer representing the minimized maximum pair sum
- Example: `7` (if pairs are (2,5) and (3,3), the maximum pair sum is max(7, 6) = 7)

## 4. Constraints

- `n == nums.length`
- `2 <= n <= 10^5` (array length between 2 and 100,000)
- `n` is **even** (guaranteed)
- `1 <= nums[i] <= 10^5` (each element is between 1 and 100,000)

## 5. Pitfalls

1. **Optimization goal clarity**: You are minimizing the MAXIMUM pair sum, not the total sum of all pairs or the average. This is a minimax problem.

2. **All elements must be paired**: You cannot leave any element unpaired or use any element more than once.

3. **Large input size**: With n up to 10^5, a brute-force approach trying all possible pairings would be computationally infeasible.

4. **Greedy intuition needed**: The problem requires finding an optimal pairing strategy, not just any valid pairing.

5. **Distinguishing from similar problems**: This is NOT about finding the minimum pair sum or minimizing total sum - it specifically asks for minimizing the worst-case (maximum) pair sum.

6. **Example walkthrough**: For `[3, 5, 2, 3]`:
   - One pairing: (3,5) and (2,3) → max(8, 5) = 8
   - Another pairing: (3,2) and (5,3) → max(5, 8) = 8
   - Another pairing: (3,3) and (5,2) → max(6, 7) = 7
   - The answer is 7 (the best possible maximum)
