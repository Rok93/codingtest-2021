package kakao2022;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem6Test {

    @DisplayName("카카오 2022 6번문제 풀이")
    @Test
    void test() {
        //given
        int[][] board1 = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] board2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] skill1 = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        int[][] skill2 = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};

        //when
        KakaoProblem6 sol = new KakaoProblem6();
        int solution1 = sol.solution(board1, skill1);
        int solution2 = sol.solution(board2, skill2);

        //then
        assertThat(solution1).isEqualTo(10);
        assertThat(solution2).isEqualTo(6);
    }
}
