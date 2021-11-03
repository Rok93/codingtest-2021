package kakao2022;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KakaoProblem3Test {

    @DisplayName("카카오 2022 3번문제 풀이")
    @Test
    void test() {
        //given
        int[] fees1 = {180, 5000, 10, 600};
        int[] fees2 = {120, 0, 60, 591};
        int[] fees3 = {1, 461, 1, 10};

        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records2 = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        String[] records3 = {"00:00 1234 IN"};

        //when
        KakaoProblem3 sol = new KakaoProblem3();
        int[] solution1 = sol.solution(fees1, records1);
        int[] solution2 = sol.solution(fees2, records2);
        int[] solution3 = sol.solution(fees3, records3);

        //then
        assertThat(solution1).isEqualTo(new int[]{14600, 34400, 5000});
        assertThat(solution2).isEqualTo(new int[]{0, 591});
        assertThat(solution3).isEqualTo(new int[]{14841});
    }
}
