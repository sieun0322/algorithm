# Step 9: Optimization Analysis

## 1. Current Approach Analysis

```java
public int minimumDifference(int[] nums, int k) {
    if (k == 1) return 0;
    Arrays.sort(nums);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i <= nums.length - k; i++) {
        minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
    }
    return minDiff;
}
```

### 현재 복잡도
- **Time**: O(n log n) - Arrays.sort() 지배
- **Space**: O(log n) ~ O(n) - Tim Sort의 merge 연산용

### 병목 지점
- 정렬이 전체 시간의 대부분을 차지
- 슬라이딩 윈도우 탐색은 O(n)으로 효율적

## 2. Alternative Approaches

### Approach A: Partial Sort (QuickSelect 변형)
최소 차이만 구하면 되므로 전체 정렬 대신 부분 정렬 고려

- **아이디어**: k개 크기의 윈도우 중 최소 범위만 찾으면 됨
- **실현 가능성**: 낮음 - 어떤 k개가 최소인지 미리 알 수 없음
- **결론**: 전체 정렬이 필요

### Approach B: Counting Sort
값 범위가 0 ~ 10^5로 제한됨

```java
public int minimumDifference(int[] nums, int k) {
    if (k == 1) return 0;
    int[] count = new int[100001];
    for (int num : nums) count[num]++;

    int minDiff = Integer.MAX_VALUE;
    int windowStart = -1, windowCount = 0;

    for (int i = 0; i <= 100000; i++) {
        if (count[i] == 0) continue;
        // ... sliding window on counting array
    }
    return minDiff;
}
```

- **Time**: O(n + V) where V = 100001
- **Space**: O(V) = O(100001)
- **Trade-off**: n <= 1000이므로 V > n, 오히려 느림

### Approach C: 현재 접근법 유지

제약조건 `n <= 1000`에서 O(n log n)은 최적에 가까움

## 3. Micro-optimizations

### 3.1 Early Termination
```java
// 차이가 0이면 더 작아질 수 없음
if (minDiff == 0) break;
```

### 3.2 루프 변수 캐싱
```java
int len = nums.length;
int end = len - k;
for (int i = 0; i <= end; i++) { ... }
```

### 3.3 불필요한 조건 제거
k == 1 체크는 유지 (정렬 비용 절약)

## 4. Comparison Table

| Approach | Time | Space | 적합성 (n≤1000) |
|----------|------|-------|----------------|
| Sort + Sliding | O(n log n) | O(log n) | ✅ 최적 |
| Counting Sort | O(n + V) | O(V) | ❌ V가 n보다 큼 |
| Partial Sort | O(n log n) | O(log n) | ❌ 불가능 |

## 5. Recommendation

**현재 접근법 유지**

이유:
1. n <= 1000에서 O(n log n)은 충분히 빠름 (~10,000 연산)
2. Counting Sort는 V = 100001 > n = 1000으로 비효율
3. 코드가 간결하고 가독성 좋음
4. Java의 Arrays.sort()는 고도로 최적화된 Tim Sort 사용

### 최종 최적화 코드 (선택적)

```java
public int minimumDifference(int[] nums, int k) {
    if (k == 1) return 0;
    Arrays.sort(nums);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0, end = nums.length - k; i <= end && minDiff > 0; i++) {
        minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
    }
    return minDiff;
}
```

추가된 최적화:
- `minDiff > 0` 조건으로 0이 되면 조기 종료
- 실제 성능 향상은 미미 (이미 충분히 빠름)
