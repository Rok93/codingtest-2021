package toss;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TossProblem4Test {

    @Test
    void test() {
        //given
        String input1 = "1 2\nSHOW\nSHOW\nNEXT\nSHOW\nNEXT\nSHOW\nNEXT\nSHOW\nEXIT";

        //when
        TossProblem4 sol = new TossProblem4();
        String answer1 = sol.solution(input1);

        //then
        assertThat(answer1).isEqualTo("1 2\\n1\\n1\\n-\\n0\\n-\\n1\\n-\\n1BYE");
    }
}
