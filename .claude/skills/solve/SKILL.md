# Solve Problem

LeetCode 문제를 8단계 AI 파이프라인으로 풀이합니다.

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

3. **8단계 파이프라인 실행**:

   ```
   problem → interpreter ─┬→ strategy → implementation ─┬→ optimizer
                          │                             │
                          ↓                             ↓
                    [tester:blind]               [tester:code]
                          ↓                             ↓
                    [test-coder]                 [test-coder]
                          ↓                             ↓
                    step5-test.java    ────────→  step7-test.java
   ```

   - **Step 1 (Interpreter)**: `agents/interpreter.md` 역할로 문제를 해석하고 `step1-interpretation.md` 저장
   - **Step 2 (Strategy)**: `agents/strategy.md` 역할로 전략을 수립하고 `step2-strategy.md` 저장
   - **Step 3 (Tester:Blind)**: `agents/tester.md` 역할로 블라인드 테스트 케이스 분석하고 `step3-test-cases.md` 저장
   - **Step 4 (Implementation)**: `agents/implementation.md` 역할로 Java 코드를 작성하고 `step4-solution.java` 저장
   - **Step 5 (Test-Coder:Blind)**: `agents/test-coder.md` 역할로 블라인드 테스트 코드 작성하고 `step5-test.java` 저장
   - **Step 6 (Tester:Code)**: `agents/tester.md` 역할로 코드 분석 테스트 케이스 추가하고 `step6-test-cases.md` 저장
   - **Step 7 (Test-Coder:Final)**: `agents/test-coder.md` 역할로 최종 테스트 코드 작성하고 `step7-test.java` 저장
   - **Step 8 (Optimizer)**: `agents/optimizer.md` 역할로 최적화 분석하고 `step8-optimization.md` 저장

4. **결과 출력**: 각 단계의 결과를 사용자에게 보여주고 파일로 저장합니다.

## Output Structure

```
ai-solutions/{problem_number}-{problem_name}/
 ├── problem.txt
 ├── step1-interpretation.md
 ├── step2-strategy.md
 ├── step3-test-cases.md      ← 블라인드 테스트 케이스 분석
 ├── step4-solution.java
 ├── step5-test.java          ← 블라인드 테스트 코드
 ├── step6-test-cases.md      ← 코드 분석 테스트 케이스
 ├── step7-test.java          ← 최종 테스트 코드
 └── step8-optimization.md
```

## Agents

- `tester.md` - 테스트 케이스 분석 (Blind/Code 모드)
- `test-coder.md` - 테스트 코드 작성

## Notes

- Step 3 (Tester:Blind)는 Step 2와 병렬로 실행 가능
- step7-test.java가 최종 테스트 파일 (블라인드 + 코드분석)
