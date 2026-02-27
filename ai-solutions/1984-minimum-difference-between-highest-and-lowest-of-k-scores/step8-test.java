import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    // ==================== Blind Test Cases ====================

    @Test
    @DisplayName("[Blind] TC1: 기본 예제 1 - 단일 원소")
    void testExample1() {
        assertEquals(0, solution.minimumDifference(new int[]{90}, 1));
    }

    @Test
    @DisplayName("[Blind] TC2: 기본 예제 2")
    void testExample2() {
        assertEquals(2, solution.minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    @Test
    @DisplayName("[Blind] TC3: k = 1")
    void testKEqualsOne() {
        assertEquals(0, solution.minimumDifference(new int[]{5, 3, 8, 1, 9}, 1));
    }

    @Test
    @DisplayName("[Blind] TC4: k = n (전체 선택)")
    void testKEqualsN() {
        assertEquals(20, solution.minimumDifference(new int[]{10, 20, 30}, 3));
    }

    @Test
    @DisplayName("[Blind] TC5: 모든 원소 동일")
    void testAllSameElements() {
        assertEquals(0, solution.minimumDifference(new int[]{5, 5, 5, 5}, 2));
    }

    @Test
    @DisplayName("[Blind] TC6: 연속된 숫자")
    void testConsecutiveNumbers() {
        assertEquals(2, solution.minimumDifference(new int[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    @DisplayName("[Blind] TC7: 역순 배열")
    void testReverseArray() {
        assertEquals(20, solution.minimumDifference(new int[]{100, 80, 60, 40, 20}, 2));
    }

    @Test
    @DisplayName("[Blind] TC8: 중복 포함")
    void testWithDuplicates() {
        assertEquals(2, solution.minimumDifference(new int[]{1, 1, 3, 3, 5, 5}, 4));
    }

    @Test
    @DisplayName("[Blind] TC9: 큰 범위의 숫자")
    void testLargeRange() {
        assertEquals(100000, solution.minimumDifference(new int[]{0, 100000}, 2));
    }

    @Test
    @DisplayName("[Blind] TC10: k가 n-1인 경우")
    void testKEqualsNMinusOne() {
        assertEquals(8, solution.minimumDifference(new int[]{1, 5, 9, 13}, 3));
    }

    // ==================== Code Analysis Test Cases ====================

    @Test
    @DisplayName("[Code] TC11: 최소 배열 (k = 2, n = 2)")
    void testMinArraySize() {
        assertEquals(9, solution.minimumDifference(new int[]{1, 10}, 2));
    }

    @Test
    @DisplayName("[Code] TC12: k = n인 큰 배열")
    void testKEqualsNLargeArray() {
        assertEquals(9, solution.minimumDifference(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
    }

    @Test
    @DisplayName("[Code] TC13: 인덱스 경계 (마지막 윈도우)")
    void testLastWindow() {
        assertEquals(2, solution.minimumDifference(new int[]{1, 3, 5, 7, 9}, 2));
    }

    @Test
    @DisplayName("[Code] TC14: 두 원소 배열 동일 값")
    void testTwoSameElements() {
        assertEquals(0, solution.minimumDifference(new int[]{5, 5}, 2));
    }

    @Test
    @DisplayName("[Code] TC15: 정렬 필요 케이스")
    void testNeedsSorting() {
        assertEquals(4, solution.minimumDifference(new int[]{9, 1, 5, 3, 7}, 3));
    }

    @Test
    @DisplayName("[Code] TC16: 0 포함")
    void testWithZero() {
        assertEquals(1, solution.minimumDifference(new int[]{0, 1, 2}, 2));
    }

    @Test
    @DisplayName("[Code] TC17: 최대값 근처")
    void testNearMaxValue() {
        assertEquals(1, solution.minimumDifference(new int[]{100000, 99999, 99998}, 2));
    }
}
