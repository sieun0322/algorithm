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

echo "[Step 1/6] Running Interpreter Agent..."
claude --print "$(cat ${AGENTS_DIR}/interpreter.txt)

$(cat ${SOLUTIONS_DIR}/problem.txt)" > "${SOLUTIONS_DIR}/step1-interpretation.txt"
echo "  -> step1-interpretation.txt"

echo "[Step 2/6] Running Strategy Agent..."
claude --print "$(cat ${AGENTS_DIR}/strategy.txt)

$(cat ${SOLUTIONS_DIR}/step1-interpretation.txt)" > "${SOLUTIONS_DIR}/step2-strategy.txt"
echo "  -> step2-strategy.txt"

echo "[Step 3/6] Running Blind Tester Agent (parallel)..."
claude --print "$(cat ${AGENTS_DIR}/tester-blind.txt)

$(cat ${SOLUTIONS_DIR}/step1-interpretation.txt)" > "${SOLUTIONS_DIR}/step3-test-blind.txt" &
BLIND_PID=$!

echo "[Step 4/6] Running Implementation Agent..."
claude --print "$(cat ${AGENTS_DIR}/implementation.txt)

$(cat ${SOLUTIONS_DIR}/step2-strategy.txt)" > "${SOLUTIONS_DIR}/step4-solution.java"
echo "  -> step4-solution.java"

# Wait for blind tester
wait $BLIND_PID
echo "  -> step3-test-blind.txt"

echo "[Step 5/6] Running Code Tester Agent..."
claude --print "$(cat ${AGENTS_DIR}/tester-code.txt)

Problem:
$(cat ${SOLUTIONS_DIR}/problem.txt)

Solution:
$(cat ${SOLUTIONS_DIR}/step4-solution.java)" > "${SOLUTIONS_DIR}/step5-test-code.txt"
echo "  -> step5-test-code.txt"

echo "[Step 6/6] Running Optimizer Agent..."
claude --print "$(cat ${AGENTS_DIR}/optimizer.txt)

Problem:
$(cat ${SOLUTIONS_DIR}/problem.txt)

Solution:
$(cat ${SOLUTIONS_DIR}/step4-solution.java)" > "${SOLUTIONS_DIR}/step6-optimization.txt"
echo "  -> step6-optimization.txt"

echo ""
echo "=== Pipeline Complete ==="
echo "Output: ${SOLUTIONS_DIR}/"
ls -la "${SOLUTIONS_DIR}/"
