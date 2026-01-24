# Solve Problem

LeetCode 문제를 6단계 AI 파이프라인으로 풀이합니다.

## Usage

```
/solve <problem_number> <problem_name>
```

## Example

```
/solve 1877 minimize-maximum-pair-sum-in-array
```

## Instructions

When the user invokes this skill:

1. **폴더 생성**: `ai-solutions/{problem_number}-{problem_name}/` 폴더를 생성합니다.

2. **problem.txt 확인**: 해당 폴더에 problem.txt가 있는지 확인합니다.
   - 없으면: 사용자에게 문제 내용을 요청하고 problem.txt를 생성합니다.
   - 있으면: 다음 단계로 진행합니다.

3. **6단계 파이프라인 실행**:

   ```
   problem → interpreter ─┬→ strategy → implementation → optimizer
                          │                    │
                          │                    ↓
                          │            [tester-code]
                          │
                          └→ [tester-blind]
   ```

   - **Step 1 (Interpreter)**: `agents/interpreter.txt` 역할로 문제를 해석하고 `step1-interpretation.txt` 저장
   - **Step 2 (Strategy)**: `agents/strategy.txt` 역할로 전략을 수립하고 `step2-strategy.txt` 저장
   - **Step 3 (Tester-Blind)**: `agents/tester-blind.txt` 역할로 솔루션 없이 테스트 케이스 생성하고 `step3-test-blind.txt` 저장
   - **Step 4 (Implementation)**: `agents/implementation.txt` 역할로 Java 코드를 작성하고 `step4-solution.java` 저장
   - **Step 5 (Tester-Code)**: `agents/tester-code.txt` 역할로 코드 분석 후 결함 탐지하고 `step5-test-code.txt` 저장
   - **Step 6 (Optimizer)**: `agents/optimizer.txt` 역할로 최적화 분석하고 `step6-optimization.txt` 저장

4. **결과 출력**: 각 단계의 결과를 사용자에게 보여주고 파일로 저장합니다.

## Output Structure

```
ai-solutions/{problem_number}-{problem_name}/
 ├── problem.txt
 ├── step1-interpretation.txt
 ├── step2-strategy.txt
 ├── step3-test-blind.txt      ← 솔루션 모르고 생성한 테스트
 ├── step4-solution.java
 ├── step5-test-code.txt       ← 코드 분석 기반 테스트
 └── step6-optimization.txt
```

## Notes

- Step 3 (Blind Tester)는 Step 2와 병렬로 실행 가능 (솔루션에 의존하지 않음)
- 두 테스터의 결과를 비교하여 더 완벽한 검증 가능
- 최적화 단계에서 대안적 접근법이 발견되면 사용자에게 알려줍니다
