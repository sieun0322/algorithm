# Quiz: Boolean Ternary Operator

## 문제

For any boolean b:

```java
boolean c = b ? !b : b;
```

What is the value of c?
- true
- false
- true or false

## 정답

**false**

## 근거

삼항 연산자 `b ? !b : b`를 분석하면:

| b | 조건 | 결과 |
|---|------|------|
| `true` | `true ? !true : true` | `!true` = **false** |
| `false` | `false ? !false : false` | `false` = **false** |

- `b = true`일 때: 조건이 참이므로 `!b` = `!true` = `false`
- `b = false`일 때: 조건이 거짓이므로 `b` = `false`

**어떤 경우든 c는 항상 `false`입니다.**

## 오답 분석

- `true` - b가 true일 때 !b가 반환되므로 false가 됨
- `true or false` - 두 경우 모두 false이므로 결과는 항상 동일함

## 관련 개념

- 삼항 연산자 (Ternary Operator): `조건 ? 참일때 : 거짓일때`
- Boolean 논리 연산
- 조건식 평가 (Short-circuit evaluation)
