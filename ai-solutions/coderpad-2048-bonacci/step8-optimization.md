# Step 8: Optimization Analysis

## 1. Current Approach

- 4x4 고정 보드 → O(1) 시간/공간
- HashSet으로 피보나치 lookup O(1)
- 라인별 처리: compact → merge → pad

## 2. Micro-optimizations

### 피보나치 Set 크기
- 현재: 2^16 미만 피보나치 (~20개)
- 충분히 작음, 최적화 불필요

### ArrayList 대신 배열
```java
int[] compact = new int[4];
int idx = 0;
for (int v : line) if (v != 0) compact[idx++] = v;
```
- 미미한 개선, 가독성 저하

## 3. Recommendation

**현재 구현 유지**

- 4x4 고정이므로 모든 연산 O(1)
- 추가 최적화 ROI 낮음
- 코드 가독성 우선
