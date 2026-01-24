# Solve Problem

LeetCode 문제를 AI 파이프라인으로 풀이합니다. 테스트 실패 시 자동 수정 기능 포함.

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

3. **파이프라인 실행**:

   ```
   problem → interpreter → strategy → implementation
                ↓                          ↓
          [tester:blind]            [test-runner]
                                         ↓
                                   FAIL? → [fixer] → [test-runner] (최대 3회)
                                         ↓
                                      PASS!
                                         ↓
          [test-coder:blind] → [tester:code] → [test-coder:final] → [optimizer]
   ```

   - **Step 1 (Interpreter)**: 문제 해석 → `step1-interpretation.md`
   - **Step 2 (Strategy)**: 전략 수립 → `step2-strategy.md`
   - **Step 3 (Tester:Blind)**: 블라인드 테스트 케이스 → `step3-test-cases.md`
   - **Step 4 (Implementation)**: 코드 구현 → `step4-solution.java`
   - **Step 5 (Test & Fix Loop)**: 테스트 실행 및 수정 (최대 3회) → `step5-test-result.md`
   - **Step 6 (Test-Coder:Blind)**: 블라인드 테스트 코드 → `step6-test.java`
   - **Step 7 (Tester:Code)**: 코드 분석 테스트 케이스 → `step7-test-cases.md`
   - **Step 8 (Test-Coder:Final)**: 최종 테스트 코드 → `step8-test.java`
   - **Step 9 (Optimizer)**: 최적화 분석 → `step9-optimization.md`

## Output Structure

```
ai-solutions/{problem_number}-{problem_name}/
 ├── problem.txt
 ├── step1-interpretation.md
 ├── step2-strategy.md
 ├── step3-test-cases.md      ← 블라인드 테스트 케이스
 ├── step4-solution.java      ← 최종 솔루션 (수정 반영)
 ├── step5-test-result.md     ← 테스트 실행 결과
 ├── step6-test.java          ← 블라인드 테스트 코드
 ├── step7-test-cases.md      ← 코드 분석 테스트 케이스
 ├── step8-test.java          ← 최종 테스트 코드
 └── step9-optimization.md
```

## Agents

- `interpreter.md` - 문제 해석
- `strategy.md` - 전략 수립
- `tester.md` - 테스트 케이스 분석 (Blind/Code 모드)
- `implementation.md` - 코드 구현
- `test-runner.md` - 테스트 실행 및 결과 분석
- `fixer.md` - 실패 케이스 기반 코드 수정
- `test-coder.md` - 테스트 코드 작성
- `optimizer.md` - 최적화 분석

## Notes

- Step 5에서 테스트 실패 시 최대 3회까지 자동 수정 시도
- step8-test.java가 최종 테스트 파일 (블라인드 + 코드분석)
