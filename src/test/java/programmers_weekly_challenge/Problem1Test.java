package programmers_weekly_challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Problem1Test {

    @Test
    void test() {
        //given
        int price = 3;
        int money = 20;
        int count = 4;
        int expected = 10;

        //when
        Problem1 sol = new Problem1();
        long actual = sol.solution(price, money, count);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
