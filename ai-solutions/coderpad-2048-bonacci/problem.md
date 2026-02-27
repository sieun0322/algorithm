# 2048-bonacci

## Problem

2048-bonacci plays on a 4x4 square. Each square is either empty or contains a number of the Fibonacci sequence.

You are given an initial board situation (a 2D array of integers) and a pushing direction (up, left, down, or right). Then, you must compute the board contents after the push and return an updated 2D array of integers.

## Rules

**Rule 1**: Numbers move as far as possible in the pushing direction.

**Rule 2**: When two consecutive numbers in the Fibonacci sequence are pushed one on another, they fuse into the next number.

**Rule 3**: Fusing orders are resolved in the backward direction of the push. A fused number can not be fused once again in the same turn.

**Rule 4**: Numbers can move to a square that a fusing has just emptied.

## Constraints

- Board size: 4x4
- Values are Fibonacci numbers < 2^16
- 0 means empty square
- Direction: "up", "down", "left", "right"

## Fibonacci Sequence

1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, ...
