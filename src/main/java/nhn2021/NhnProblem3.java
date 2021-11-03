package nhn2021;

import java.util.stream.LongStream;

public class NhnProblem3 {

    // 갈등 관계의 수 N
    // 괄등 관계 N개
    // 싸움이 나지 않게 아이들을 일렬로 세울 수 있는 방법의 수
    public static void main(String[] args) {
        long totalTryNumber = LongStream.rangeClosed(1, 8)
                .reduce(1, (a, b) -> a * b);

        int N = 4;
        long failTryNumber = LongStream.rangeClosed(8 - N, 8)
                .reduce(1, (a, b) -> a * b);

        System.out.println(totalTryNumber);
        System.out.println(failTryNumber);
        System.out.println(totalTryNumber - failTryNumber);
    }
}
