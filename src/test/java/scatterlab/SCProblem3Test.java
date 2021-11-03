package scatterlab;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SCProblem3Test {

    @Test
    void test() {
        //given
        int N1 = 20;
        int N2 = 100;
        int N3 = 12;

        int M1 = 36;
        int M2 = 83;
        int M3 = 10;

        //when
        SCProblem3 sol = new SCProblem3();
        int actual1 = sol.solution(N1, M1);
        int actual2 = sol.solution(N2, M2);
        int actual3 = sol.solution(N3, M3);

        //then
        assertThat(actual1).isEqualTo(2);
        assertThat(actual2).isEqualTo(3);
        assertThat(actual3).isEqualTo(1);
    }
}
