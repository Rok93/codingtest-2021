package scatterlab;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SCProblem2Test {

    @Test
    void test() {
        //given
        double C1 = 30.0;
        double C2 = 30.0;
        double C3 = 30.5;
        double C4 = 500.0;

        double F1 = 1.0;
        double F2 = 2.0;
        double F3 = 3.14159;
        double F4 = 4.0;

        double X1 = 2.0;
        double X2 = 100.0;
        double X3 = 1999.1999;
        double X4 = 2000.0;

        //when
        SCProblem2 sol = new SCProblem2();
//        double actual1 = sol.solution(C1, F1, X1);
        double actual2 = sol.solution(C2, F2, X2);
//        double actual3 = sol.solution(C3, F3, X3);
//        double actual4 = sol.solution(C4, F4, X4);

        //then
//        assertThat(actual1).isEqualTo(1.0);
        assertThat(actual2).isEqualTo(39.166667);
//        assertThat(actual3).isEqualTo(63.968001);
//        assertThat(actual4).isEqualTo(526.190476);
    }
}
