package scatterlab;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SCProblem3 {

    // N 이하의 소수
    public int solution(int N, int M) {
        int answer = 0;
        List<Integer> primeNumbers = IntStream.rangeClosed(2, N)
                .filter(this::isPrimeNumber)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        int size = primeNumbers.size();
        for (int i = 0; i < size; i++) {
            int sum = primeNumbers.get(i);

            int startIdx = i + 1;
            while (sum < M && startIdx < size) {
                sum += primeNumbers.get(startIdx++);
            }

            if (sum == M) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrimeNumber(int target) {
        return IntStream.rangeClosed(2, target - 1)
                .allMatch(number -> target % number != 0);
    }


}

// 정확성 75점, 효율성 0 점
