package anypointmedia;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnyPointProblem2Test {

    @Test
    void test() {
        //given
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] word = {"GPQM", "GPMZ", "EFU", "MMNA"};

        //when
        AnyPointProblem2 sol = new AnyPointProblem2();
        String[] actual = sol.solution(card, word);

        //then
        assertThat(actual).isEqualTo(new String[]{"GPQM", "MMNA"});
    }

    @Test
    void test2() {
        //given
        String[] card = {"AABBCCDD", "KKKKJJJJ", "MOMOMOMO"};
        String[] word = {"AAAKKKKKMMMMM", "ABCDKJ"};

        //when
        AnyPointProblem2 sol = new AnyPointProblem2();
        String[] actual = sol.solution(card, word);

        //then
        assertThat(actual).isEqualTo(new String[]{"-1"});
    }
}
