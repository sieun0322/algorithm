# Step 2: Strategy

## 1. Key Observations

1. **피보나치 연속 판별**: a와 b가 연속 피보나치인지 확인 → a+b가 피보나치이면 연속
2. **방향별 처리**: 각 행/열을 1D 배열로 추출해서 처리 후 다시 배치
3. **합침 순서**: 밀리는 방향 끝에서부터 처리 (two-pointer or sequential)

## 2. Algorithm Choice

**Line-by-line Simulation**

1. 방향에 따라 행 또는 열 추출
2. 각 라인을 1D로 처리:
   - 0 제거 (압축)
   - 앞/뒤에서부터 연속 피보나치 합침 (방향에 따라)
   - 합쳐진 칸 표시 (재합침 방지)
3. 결과를 다시 2D 보드에 배치

### 피보나치 연속 체크

```
isFib(n): n이 피보나치인지
isConsecutiveFib(a, b): a+b가 피보나치이고, a와 b 모두 피보나치
```

## 3. Time & Space Complexity

- **Time**: O(1) - 4x4 고정 보드
- **Space**: O(1) - 상수 크기
