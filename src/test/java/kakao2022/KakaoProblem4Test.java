package kakao2022;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem4Test {

    @DisplayName("카카오 2022 4번문제 풀이")
    @Test
    void test() {
        //given
        int n1 = 5;
        int n2 = 1;
        int n3 = 9;
        int n4 = 10;

        int[] info1 = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] info2 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] info3 = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] info4 = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};

        //when
        KakaoProblem4 sol = new KakaoProblem4();
        int[] solution1 = sol.solution(n1, info1);
        int[] solution2 = sol.solution(n2, info2);
        int[] solution3 = sol.solution(n3, info3);
        int[] solution4 = sol.solution(n4, info4);

        //then
        assertThat(solution1).isEqualTo(new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0});
        assertThat(solution2).isEqualTo(new int[]{-1});
        assertThat(solution3).isEqualTo(new int[]{1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0});
        assertThat(solution4).isEqualTo(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2});
    }
}
