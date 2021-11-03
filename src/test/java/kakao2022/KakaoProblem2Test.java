package kakao2022;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem2Test {

    @DisplayName("카카오 2022 2번문제 풀이")
    @Test
    void test() {
        //given
        int n1 = 437674;
        int n2 = 110011;
        int n3 = 1_000_000;
        int n4 = 999_999;
        int n5 = 4;
        int n6 = 738;

        int k1 = 3;
        int k2 = 10;
        int k3 = 7;
        int k4 = 4;
        int k5 = 4;
        int k6 = 9;

        //when
        KakaoProblem2 sol = new KakaoProblem2();
        int solution1 = sol.solution(n1, k1);
        int solution2 = sol.solution(n2, k2);
        int solution3 = sol.solution(n3, k3); // 11333311
        int solution4 = sol.solution(n4, k4);
        int solution5 = sol.solution(n5, k5);
        int solution6 = sol.solution(n6, k6);

        //then
        assertThat(solution1).isEqualTo(3);
        assertThat(solution2).isEqualTo(2);
        assertThat(solution3).isEqualTo(0);
        assertThat(solution4).isEqualTo(2);
        assertThat(solution5).isEqualTo(0);
        assertThat(solution6).isEqualTo(0);
    }
}
