# Step 7: Test Cases (Code Analysis Mode)

## Code Analysis

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

### 코드 특성 분석

1. **k == 1 조기 반환**: 정렬 전에 체크
2. **루프 범위**: `i <= nums.length - k` → off-by-one 검증 필요
3. **인덱스 계산**: `nums[i + k - 1] - nums[i]` → 윈도우 끝점 계산 검증
4. **Integer.MAX_VALUE 초기화**: 항상 갱신되는지 확인

## Test Cases

### [Code] TC11: 최소 배열 (k = 2, n = 2)
- **Input**: nums = [1, 10], k = 2
- **Expected**: 9
- **Reason**: 루프가 정확히 한 번 실행 (i=0), 경계 조건

### [Code] TC12: k = n인 큰 배열
- **Input**: nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 10
- **Expected**: 9
- **Reason**: 루프가 한 번만 실행, i=0일 때 nums[9] - nums[0]

### [Code] TC13: 인덱스 경계 (마지막 윈도우)
- **Input**: nums = [1, 3, 5, 7, 9], k = 2
- **Expected**: 2
- **Reason**: 마지막 윈도우 i=3일 때 nums[4] - nums[3] = 9-7 = 2, 정렬 후 [1,3,5,7,9]

### [Code] TC14: 두 원소 배열
- **Input**: nums = [5, 5], k = 2
- **Expected**: 0
- **Reason**: n = k = 2인 최소 케이스, 동일 값

### [Code] TC15: 정렬 필요 케이스
- **Input**: nums = [9, 1, 5, 3, 7], k = 3
- **Expected**: 4
- **Reason**: 정렬 후 [1,3,5,7,9], 최소 윈도우 [1,3,5] or [3,5,7] or [5,7,9] 모두 차이 4

### [Code] TC16: 0 포함
- **Input**: nums = [0, 1, 2], k = 2
- **Expected**: 1
- **Reason**: 최소값 0 포함, 정렬 후 인접 차이 1

### [Code] TC17: 최대값만 포함
- **Input**: nums = [100000, 99999, 99998], k = 2
- **Expected**: 1
- **Reason**: 최대 범위 근처 값들, 정렬 후 인접 차이 1
