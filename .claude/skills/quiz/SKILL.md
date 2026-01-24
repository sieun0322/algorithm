# Quiz Solver

CS 문제 (5지선다, 단답형, OX 등)를 풀이하고 결과를 저장합니다.

## Usage

```
/quiz [topic]
```

그 후 문제를 붙여넣거나 스크린샷 경로를 제공하세요.

## Example

```
/quiz algorithm
다음 중 시간복잡도가 O(n log n)인 정렬 알고리즘은?
A) Bubble Sort
B) Selection Sort
C) Merge Sort
D) Insertion Sort
E) Counting Sort
```

## Instructions

When the user invokes this skill:

1. **문제 입력 받기**: 사용자가 문제를 텍스트로 붙여넣거나 스크린샷 경로를 제공합니다.

2. **문제 분석**:
   - 문제 유형 파악 (5지선다, 다중선택, 단답형, OX 등)
   - 핵심 개념 파악

3. **정답 도출**:
   - 정답 선택
   - 근거 설명 (왜 이것이 정답인지)
   - 오답 분석 (각 오답이 왜 틀린지 간단히)

4. **결과 저장**: `ai-solutions/quiz/` 폴더에 md 파일로 저장
   - 파일명: `{timestamp}-{topic}.md` (예: `20260124-boolean.md`)
   - topic이 없으면 문제에서 핵심 키워드 추출

5. **출력 형식** (파일 내용):
   ```markdown
   # Quiz: [문제 핵심 주제]

   ## 문제
   [원본 문제]

   ## 정답
   **[정답]**

   ## 근거
   [정답인 이유 설명]

   ## 오답 분석
   - A) [왜 틀린지]
   - B) [왜 틀린지]
   ...

   ## 관련 개념
   - [추가 학습할 개념들]
   ```

## Output Structure

```
ai-solutions/quiz/
 ├── 20260124-boolean-ternary.md
 ├── 20260124-sorting-complexity.md
 └── ...
```

## Supported Question Types

- 5지선다 (Single Choice)
- 다중선택 (Multiple Choice)
- OX 문제 (True/False)
- 단답형 (Short Answer)
- 빈칸 채우기 (Fill in the Blank)

## Topics

- 자료구조 (Data Structures)
- 알고리즘 (Algorithms)
- 운영체제 (Operating Systems)
- 네트워크 (Networking)
- 데이터베이스 (Database)
- 프로그래밍 언어 (Programming Languages)
- 시스템 설계 (System Design)
- 기타 CS 전반
