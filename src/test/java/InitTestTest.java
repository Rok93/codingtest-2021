import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InitTestTest {

    @Test
    void test() {
        //given
        String expected = "test";
        InitTest initTest = new InitTest();

        //when
        String actual = initTest.test();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
