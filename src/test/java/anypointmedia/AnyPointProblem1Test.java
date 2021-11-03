package anypointmedia;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnyPointProblem1Test {

    @Test
    void test() {
        //given
        int N = 8;
        int A = 4;
        int B = 7;

        //when
        AnyPointProblem1 sol = new AnyPointProblem1();
        int actual = sol.solution(N, A, B);

        //then
        assertThat(actual).isEqualTo(3);
    }
}
