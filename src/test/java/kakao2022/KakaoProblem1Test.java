package kakao2022;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem1Test {

    @DisplayName("카카오 2022 1번문제 풀이")
    @Test
    void test() {
        //given
        String[] idLists1 = {"muzi", "frodo", "apeach", "neo"};
        String[] idLists2 = {"con", "ryan"};

        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};

        int k1 = 2;
        int k2 = 3;

        //when
        KakaoProblem1 sol = new KakaoProblem1();
        int[] solution1 = sol.solution(idLists1, report1, k1);
        int[] solution2 = sol.solution(idLists2, report2, k2);

        //then
        assertThat(solution1).isEqualTo(new int[]{2, 1, 1, 0});
        assertThat(solution2).isEqualTo(new int[]{0, 0});
    }
}
