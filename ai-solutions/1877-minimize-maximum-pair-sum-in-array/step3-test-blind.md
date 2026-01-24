# Blind Test Cases: LeetCode 1877 - Minimize Maximum Pair Sum in Array

## Problem Analysis

- We have an array of even length `n`
- We need to pair all elements into `n/2` pairs
- Goal: minimize the maximum pair sum among all pairs
- Each element must be in exactly one pair

---

## 1. Boundary Cases (Min/Max Values)

### Case 1.1: Minimum array size (n = 2)
```
Input: nums = [1, 1]
Expected Output: 2
Reason: Only one pair possible: (1,1), sum = 2
```

### Case 1.2: Minimum array size with different values
```
Input: nums = [1, 100000]
Expected Output: 100001
Reason: Only one pair possible: (1, 100000), sum = 100001
```

### Case 1.3: Minimum element values
```
Input: nums = [1, 1, 1, 1]
Expected Output: 2
Reason: All elements are minimum (1), any pairing gives sum = 2
```

### Case 1.4: Maximum element values
```
Input: nums = [100000, 100000, 100000, 100000]
Expected Output: 200000
Reason: All elements are maximum, any pairing gives sum = 200000
```

### Case 1.5: Mix of min and max values
```
Input: nums = [1, 100000, 1, 100000]
Expected Output: 100001
Reason: Best pairing would pair 1 with 100000 twice
```

---

## 2. Special Cases

### Case 2.1: All elements identical
```
Input: nums = [5, 5, 5, 5, 5, 5]
Expected Output: 10
Reason: All pairs will have sum = 10
```

### Case 2.2: Two distinct values only
```
Input: nums = [1, 1, 1, 10, 10, 10]
Expected Output: 11
Reason: Pair each 1 with a 10
```

### Case 2.3: Consecutive integers
```
Input: nums = [1, 2, 3, 4]
Expected Output: 5
Reason: Optimal pairing: (1,4)=5, (2,3)=5
```

### Case 2.4: Array already sorted ascending
```
Input: nums = [1, 2, 3, 4, 5, 6]
Expected Output: 7
Reason: Optimal: (1,6)=7, (2,5)=7, (3,4)=7
```

### Case 2.5: Array sorted descending
```
Input: nums = [6, 5, 4, 3, 2, 1]
Expected Output: 7
Reason: Same as above, order doesn't matter
```

### Case 2.6: Duplicates with varied values
```
Input: nums = [1, 1, 2, 2, 3, 3]
Expected Output: 4
Reason: Optimal: (1,3)=4, (1,3)=4, (2,2)=4
```

### Case 2.7: Single pair of duplicates among unique values
```
Input: nums = [1, 2, 3, 3, 4, 5]
Expected Output: 6
Reason: Optimal: (1,5)=6, (2,4)=6, (3,3)=6
```

### Case 2.8: Extreme skew (many small, few large)
```
Input: nums = [1, 1, 1, 1, 100, 100]
Expected Output: 101
Reason: Two large must pair with two small: (1,100), (1,100), (1,1)
```

---

## 3. Stress Cases (Large Input)

### Case 3.1: Maximum size with identical elements
```
Input: nums = [50000] * 100000 (100000 elements, all 50000)
Expected Output: 100000
```

### Case 3.2: Maximum size alternating min/max
```
Input: nums = [1, 100000] * 50000 (alternating 1 and 100000)
Expected Output: 100001
```

### Case 3.3: Maximum size with sequential values
```
Input: nums = [1, 2, 3, ..., 100000]
Expected Output: 100001
Reason: Pair 1 with 100000, 2 with 99999, etc. All sums = 100001
```

### Case 3.4: Maximum size, all minimum value
```
Input: nums = [1] * 100000
Expected Output: 2
```

### Case 3.5: Maximum size, all maximum value
```
Input: nums = [100000] * 100000
Expected Output: 200000
```

---

## Summary Table

| Case | Input Size | Key Characteristic | Expected Output |
|------|------------|-------------------|-----------------|
| 1.1 | 2 | Min size, same values | 2 |
| 1.2 | 2 | Min size, extreme range | 100001 |
| 1.5 | 4 | Min/max alternating | 100001 |
| 2.3 | 4 | Consecutive integers | 5 |
| 2.4 | 6 | Sorted ascending | 7 |
| 2.6 | 6 | All duplicates | 4 |
| 3.3 | 100000 | Sequential 1 to n | 100001 |
