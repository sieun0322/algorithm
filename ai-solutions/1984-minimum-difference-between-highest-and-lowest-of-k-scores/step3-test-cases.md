# Step 3: Test Cases (Blind Mode)

## Test Case Analysis

문제의 제약조건과 경계 조건을 분석하여 테스트 케이스 도출

### 경계 조건
- k = 1 (단일 선택)
- k = n (전체 선택)
- 모든 원소가 동일
- 이미 정렬된 배열
- 역순 정렬된 배열

## Test Cases

### [Blind] TC1: 기본 예제 1
- **Input**: nums = [90], k = 1
- **Expected**: 0
- **Reason**: 단일 원소, k = 1인 최소 케이스

### [Blind] TC2: 기본 예제 2
- **Input**: nums = [9,4,1,7], k = 2
- **Expected**: 2
- **Reason**: 문제에서 제공된 예제 (정렬 후 [1,4,7,9], 7-9 선택 시 차이 2)

### [Blind] TC3: k = 1
- **Input**: nums = [5,3,8,1,9], k = 1
- **Expected**: 0
- **Reason**: k = 1이면 항상 차이는 0

### [Blind] TC4: k = n (전체 선택)
- **Input**: nums = [10,20,30], k = 3
- **Expected**: 20
- **Reason**: 전체 선택 시 max - min = 30 - 10

### [Blind] TC5: 모든 원소 동일
- **Input**: nums = [5,5,5,5], k = 2
- **Expected**: 0
- **Reason**: 모든 원소가 같으면 어떻게 선택해도 차이는 0

### [Blind] TC6: 연속된 숫자
- **Input**: nums = [1,2,3,4,5], k = 3
- **Expected**: 2
- **Reason**: 이미 정렬됨, 연속 3개 선택 시 최소 차이 2

### [Blind] TC7: 역순 배열
- **Input**: nums = [100,80,60,40,20], k = 2
- **Expected**: 20
- **Reason**: 역순이어도 정렬 후 [20,40,60,80,100], 인접 원소 차이 20

### [Blind] TC8: 중복 포함
- **Input**: nums = [1,1,3,3,5,5], k = 4
- **Expected**: 2
- **Reason**: 중복 포함 시 [1,1,3,3] 선택하면 차이 2

### [Blind] TC9: 큰 범위의 숫자
- **Input**: nums = [0,100000], k = 2
- **Expected**: 100000
- **Reason**: 최대 범위 테스트 (0 ~ 10^5)

### [Blind] TC10: k가 n-1인 경우
- **Input**: nums = [1,5,9,13], k = 3
- **Expected**: 8
- **Reason**: [1,5,9] 또는 [5,9,13] 중 하나 선택, 차이는 8
