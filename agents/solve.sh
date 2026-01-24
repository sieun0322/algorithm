#!/bin/bash

# Usage: ./solve.sh <problem_number> <problem_name>
# Example: ./solve.sh 1877 minimize-maximum-pair-sum-in-array

if [ $# -lt 2 ]; then
    echo "Usage: ./solve.sh <problem_number> <problem_name>"
    echo "Example: ./solve.sh 1877 minimize-maximum-pair-sum-in-array"
    exit 1
fi

PROBLEM_NUM=$1
PROBLEM_NAME=$2
FOLDER_NAME="${PROBLEM_NUM}-${PROBLEM_NAME}"
BASE_DIR="$(dirname "$0")/.."
SOLUTIONS_DIR="${BASE_DIR}/ai-solutions/${FOLDER_NAME}"
AGENTS_DIR="${BASE_DIR}/agents"

# Create folder
mkdir -p "${SOLUTIONS_DIR}"

echo "=== AI Problem Solving Pipeline ==="
echo "Problem: ${FOLDER_NAME}"
echo ""

# Check if problem.txt exists
if [ ! -f "${SOLUTIONS_DIR}/problem.txt" ]; then
    echo "[!] problem.txt not found in ${SOLUTIONS_DIR}"
    echo "[!] Please create problem.txt first, then run this script again."
    exit 1
fi

echo "[Step 1/8] Running Interpreter Agent..."
claude --print "$(cat ${AGENTS_DIR}/interpreter.md)

$(cat ${SOLUTIONS_DIR}/problem.txt)" > "${SOLUTIONS_DIR}/step1-interpretation.md"
echo "  -> step1-interpretation.md"

echo "[Step 2/8] Running Strategy Agent..."
claude --print "$(cat ${AGENTS_DIR}/strategy.md)

$(cat ${SOLUTIONS_DIR}/step1-interpretation.md)" > "${SOLUTIONS_DIR}/step2-strategy.md"
echo "  -> step2-strategy.md"

echo "[Step 3/8] Running Tester Agent (Blind Mode, parallel)..."
claude --print "$(cat ${AGENTS_DIR}/tester.md)

Problem (No solution code - Blind Mode):
$(cat ${SOLUTIONS_DIR}/step1-interpretation.md)" > "${SOLUTIONS_DIR}/step3-test-cases.md" &
BLIND_PID=$!

echo "[Step 4/8] Running Implementation Agent..."
claude --print "$(cat ${AGENTS_DIR}/implementation.md)

$(cat ${SOLUTIONS_DIR}/step2-strategy.md)" > "${SOLUTIONS_DIR}/step4-solution.java"
echo "  -> step4-solution.java"

# Wait for blind tester
wait $BLIND_PID
echo "  -> step3-test-cases.md"

echo "[Step 5/8] Running Test Coder Agent (Blind Tests)..."
claude --print "$(cat ${AGENTS_DIR}/test-coder.md)

Test Case Analysis:
$(cat ${SOLUTIONS_DIR}/step3-test-cases.md)" > "${SOLUTIONS_DIR}/step5-test.java"
echo "  -> step5-test.java"

echo "[Step 6/8] Running Tester Agent (Code Analysis Mode)..."
claude --print "$(cat ${AGENTS_DIR}/tester.md)

Problem:
$(cat ${SOLUTIONS_DIR}/problem.txt)

Solution:
$(cat ${SOLUTIONS_DIR}/step4-solution.java)" > "${SOLUTIONS_DIR}/step6-test-cases.md"
echo "  -> step6-test-cases.md"

echo "[Step 7/8] Running Test Coder Agent (Add Code Analysis Tests)..."
claude --print "$(cat ${AGENTS_DIR}/test-coder.md)

Additional Test Case Analysis:
$(cat ${SOLUTIONS_DIR}/step6-test-cases.md)

Existing Test Code (add new tests to this, preserve all existing tests):
$(cat ${SOLUTIONS_DIR}/step5-test.java)" > "${SOLUTIONS_DIR}/step7-test.java"
echo "  -> step7-test.java"

echo "[Step 8/8] Running Optimizer Agent..."
claude --print "$(cat ${AGENTS_DIR}/optimizer.md)

Problem:
$(cat ${SOLUTIONS_DIR}/problem.txt)

Solution:
$(cat ${SOLUTIONS_DIR}/step4-solution.java)" > "${SOLUTIONS_DIR}/step8-optimization.md"
echo "  -> step8-optimization.md"

echo ""
echo "=== Pipeline Complete ==="
echo "Output: ${SOLUTIONS_DIR}/"
ls -la "${SOLUTIONS_DIR}/"
