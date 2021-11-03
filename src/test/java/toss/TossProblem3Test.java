package toss;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TossProblem3Test {

    @Test
    void test() {
        //given
        String amountText = "25,000";
        boolean expect = true;

        //when
        TossProblem3 sol = new TossProblem3();
        boolean actual = sol.solution(amountText);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
