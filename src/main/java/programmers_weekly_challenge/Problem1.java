package programmers_weekly_challenge;

import java.util.stream.IntStream;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/82612 (위클리 챌린지 1주차)
 */
public class Problem1 {

    public long solution(int price, int money, int count) {

        long totalPrice = IntStream.rangeClosed(1, count)
            .mapToLong(tryNumber -> tryNumber * price)
            .sum();

        return totalPrice > money ? totalPrice - money : 0;
    }

}
