import java.util.*;

enum Direction {
    UP, DOWN, LEFT, RIGHT
}

class The2048Bonacci {
    private int[][] gameArea;
    private int width;
    private int height;
    private Set<Integer> fibs = new HashSet<>();

    public The2048Bonacci(int[][] gameArea) {
        this.gameArea = gameArea;
        this.width = gameArea[0].length;
        this.height = gameArea.length;

        // Build Fibonacci set
        int a = 1, b = 1;
        fibs.add(a);
        while (b < 65536) {
            fibs.add(b);
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public int getTile(int x, int y) {
        return gameArea[y][x];
    }

    public void setTile(int x, int y, int fibValue) {
        gameArea[y][x] = fibValue;
    }

    public String getDescription() {
        StringBuilder strBuilder = new StringBuilder();
        for (int[] line : gameArea) {
            String strLine = Arrays.stream(line)
                                   .mapToObj(fibVal -> String.format("%2d", fibVal))
                                   .reduce((a, b) -> a + " " + b)
                                   .orElse("");
            strBuilder.append(strLine).append("\n");
        }
        return strBuilder.toString();
    }

    public void push(Direction direction) {
        switch (direction) {
            case RIGHT:
                for (int r = 0; r < height; r++) {
                    int[] line = gameArea[r].clone();
                    gameArea[r] = mergeLine(line, true);
                }
                break;
            case LEFT:
                for (int r = 0; r < height; r++) {
                    int[] line = gameArea[r].clone();
                    gameArea[r] = mergeLine(line, false);
                }
                break;
            case DOWN:
                for (int c = 0; c < width; c++) {
                    int[] line = new int[height];
                    for (int r = 0; r < height; r++) line[r] = gameArea[r][c];
                    int[] merged = mergeLine(line, true);
                    for (int r = 0; r < height; r++) gameArea[r][c] = merged[r];
                }
                break;
            case UP:
                for (int c = 0; c < width; c++) {
                    int[] line = new int[height];
                    for (int r = 0; r < height; r++) line[r] = gameArea[r][c];
                    int[] merged = mergeLine(line, false);
                    for (int r = 0; r < height; r++) gameArea[r][c] = merged[r];
                }
                break;
        }
    }

    private int[] mergeLine(int[] line, boolean toEnd) {
        int len = line.length;

        // 1. Compact (remove zeros)
        List<Integer> nums = new ArrayList<>();
        for (int v : line) if (v != 0) nums.add(v);

        if (nums.isEmpty()) return new int[len];

        // 2. Merge consecutive Fibonacci numbers
        List<Integer> merged = new ArrayList<>();
        boolean[] wasMerged = new boolean[nums.size()];

        if (toEnd) {
            // Push to end (right/down): process front to back
            for (int i = 0; i < nums.size(); i++) {
                if (wasMerged[i]) continue;
                if (i + 1 < nums.size() && !wasMerged[i + 1] && isConsecutiveFib(nums.get(i), nums.get(i + 1))) {
                    merged.add(nums.get(i) + nums.get(i + 1));
                    wasMerged[i] = true;
                    wasMerged[i + 1] = true;
                    i++;
                } else {
                    merged.add(nums.get(i));
                }
            }
            // Pad zeros at front
            int[] result = new int[len];
            int offset = len - merged.size();
            for (int i = 0; i < merged.size(); i++) {
                result[offset + i] = merged.get(i);
            }
            return result;
        } else {
            // Push to start (left/up): process back to front
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (wasMerged[i]) continue;
                if (i - 1 >= 0 && !wasMerged[i - 1] && isConsecutiveFib(nums.get(i - 1), nums.get(i))) {
                    merged.add(0, nums.get(i - 1) + nums.get(i));
                    wasMerged[i] = true;
                    wasMerged[i - 1] = true;
                    i--;
                } else {
                    merged.add(0, nums.get(i));
                }
            }
            // Pad zeros at end
            int[] result = new int[len];
            for (int i = 0; i < merged.size(); i++) {
                result[i] = merged.get(i);
            }
            return result;
        }
    }

    private boolean isConsecutiveFib(int a, int b) {
        if (a == 0 || b == 0) return false;
        return fibs.contains(a) && fibs.contains(b) && fibs.contains(a + b);
    }
}

// Test
class Solution {
    public static void main(String[] args) {
        int[][] board = {
            {1, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        The2048Bonacci game = new The2048Bonacci(board);
        System.out.println("Before:");
        System.out.println(game.getDescription());

        game.push(Direction.RIGHT);
        System.out.println("After push RIGHT:");
        System.out.println(game.getDescription());
    }
}
