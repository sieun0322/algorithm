import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    private int[][] board(int[] row0) {
        return new int[][]{row0, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
    }

    @Test @DisplayName("[Blind] TC1: 단순 이동")
    void test1() {
        assertArrayEquals(board(new int[]{0,0,0,1}), solution.push(board(new int[]{1,0,0,0}), "right"));
    }

    @Test @DisplayName("[Blind] TC2: 1+1=2")
    void test2() {
        assertArrayEquals(board(new int[]{0,0,0,2}), solution.push(board(new int[]{1,1,0,0}), "right"));
    }

    @Test @DisplayName("[Blind] TC3: 1+2=3")
    void test3() {
        assertArrayEquals(board(new int[]{0,0,0,3}), solution.push(board(new int[]{1,2,0,0}), "right"));
    }

    @Test @DisplayName("[Blind] TC4: 2+3=5")
    void test4() {
        assertArrayEquals(board(new int[]{0,0,0,5}), solution.push(board(new int[]{2,3,0,0}), "right"));
    }

    @Test @DisplayName("[Blind] TC5: 비연속 1,3")
    void test5() {
        assertArrayEquals(board(new int[]{0,0,1,3}), solution.push(board(new int[]{1,3,0,0}), "right"));
    }

    @Test @DisplayName("[Blind] TC6: 2+2=4 안됨")
    void test6() {
        assertArrayEquals(board(new int[]{0,0,2,2}), solution.push(board(new int[]{1,1,2,0}), "right"));
    }

    @Test @DisplayName("[Blind] TC7: left")
    void test7() {
        assertArrayEquals(board(new int[]{3,0,0,0}), solution.push(board(new int[]{0,0,1,2}), "left"));
    }

    @Test @DisplayName("[Blind] TC8: up")
    void test8() {
        int[][] input = {{1,0,0,0},{2,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] expected = {{3,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        assertArrayEquals(expected, solution.push(input, "up"));
    }

    @Test @DisplayName("[Blind] TC9: down")
    void test9() {
        int[][] input = {{1,0,0,0},{2,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] expected = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{3,0,0,0}};
        assertArrayEquals(expected, solution.push(input, "down"));
    }

    @Test @DisplayName("[Blind] TC10: 빈 보드")
    void test10() {
        int[][] empty = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        assertArrayEquals(empty, solution.push(empty, "right"));
    }

    @Test @DisplayName("[Code] TC11: 연쇄 합침")
    void test11() {
        assertArrayEquals(board(new int[]{0,0,3,8}), solution.push(board(new int[]{1,2,3,5}), "right"));
    }

    @Test @DisplayName("[Code] TC13: 1111")
    void test13() {
        assertArrayEquals(board(new int[]{0,0,2,2}), solution.push(board(new int[]{1,1,1,1}), "right"));
    }

    @Test @DisplayName("[Code] TC14: 큰 피보나치")
    void test14() {
        assertArrayEquals(board(new int[]{0,0,0,1597}), solution.push(board(new int[]{610,987,0,0}), "right"));
    }
}
