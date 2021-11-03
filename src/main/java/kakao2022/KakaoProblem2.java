package kakao2022;

import java.util.Arrays;
import java.util.stream.IntStream;

// todo: 1, 11번이 런타임 오류가 뜬다! 나중에 잡기!
public class KakaoProblem2 {
    public int solution(int n, int k) {
        String ternarySystemNumber = toNSystemNumber(n, k); // 3진법
        String[] split = ternarySystemNumber.replaceAll("0", " 0 ").split(" ");
        return (int) Arrays.stream(split)
                .filter(it -> !it.isBlank())
                .map(String::trim)
                .map(this::parseInt)
                .filter(this::isPrimeNumber)
                .count();
    }

    private Integer parseInt(String it) {
        if (it == null || it.isBlank()) {
            return 0;
        }

        return Integer.parseInt(it.trim());
    }

    private boolean isPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        return IntStream.range(2, number)
                .allMatch(it -> number % it != 0);
    }

    private String toNSystemNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n / k != 0) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n % k);
        StringBuilder reverseNumber = sb.reverse();
        System.out.println(k + "진법 변환한 숫자: " + reverseNumber);
        return reverseNumber.toString();
    }
}
