package scatterlab;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScProblem1Test {

    @Test
    void test() {
        //given
        int[][] data1 = {{1, 0, 11}, {3, 1, 15}, {2, 0, 16}, {4, 0, 17}, {2, 0, 15}, {2, 1, 14}, {2, 0, 12}};
        int[][] data2 = {{4, 0, 12}, {1, 0, 16}, {3, 0, 18}, {3, 0, 17}, {2, 0, 15}, {3, 2, 22}, {2, 1, 17}};
        int[][] data3 = {{3, 0, 20}, {2, 1, 17}, {3, 0, 17}, {2, 0, 31}, {1, 0, 19}, {1, 0, 19}, {4, 1, 14}};
        int[][] data4 = {{3, 0, 20}, {2, 1, 17}, {3, 0, 17}, {2, 0, 31}, {1, 0, 19}, {1, 0, 10}, {4, 1, 14}};

        //when
        ScProblem1 sol = new ScProblem1();
        int[] actual1 = sol.solution(data1);
        int[] actual2 = sol.solution(data2);
        int[] actual3 = sol.solution(data3);
        int[] actual4 = sol.solution(data4);

        //then
        assertThat(actual1).isEqualTo(new int[]{2, 5});
        assertThat(actual2).isEqualTo(new int[]{5, 0});
        assertThat(actual3).isEqualTo(new int[]{5, 6});
        assertThat(actual4).isEqualTo(new int[]{4, 6});
    }
}
