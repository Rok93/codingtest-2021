package kakao2022;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem5Test {

    @DisplayName("카카오 2022 5번문제 풀이")
    @Test
    void test() {
        //given
        int[] info1 = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[] info2 = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};

        int[][] edges1 = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};

        //when
        KakaoProblem5 sol = new KakaoProblem5();
        int solution1 = sol.solution(info1, edges1);
        int solution2 = sol.solution(info2, edges2);

        //then
        assertThat(solution1).isEqualTo(5);
        assertThat(solution2).isEqualTo(5);
    }
}
