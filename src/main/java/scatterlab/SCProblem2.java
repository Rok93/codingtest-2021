package scatterlab;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SCProblem2 {
    private static final double CEO_FRY_PER_MINUTE_NUMBER = 2.0;

    // 1분에 2마리 치킨을 튀긴다.
    // X: 주문한 치킨 수
    // F: 알바 한명이 1분당 튀길 수 있는 치킨 수   (종윤이는 2마리)
    // C: 알바 1명당 수당으로 가져가는 치킨 수

    public double solution(double C, double F, double X) {

        double duration = Double.MAX_VALUE;
        for (double employNumber = 0; employNumber < 1_00.0; employNumber += 0.1) {
            double totalDuration = calculateTime(C, F, X, employNumber);
            System.out.println(totalDuration);
            if (totalDuration < duration) {
                duration = totalDuration;
            }
        }

        return duration;

//        return IntStream.rangeClosed(0, 1_000)
//                .mapToDouble(employNumber -> calculateTime(C, F, X, employNumber))
//                .min()
//                .getAsDouble();
    }

    private double calculateTime(double c, double f, double x, double employNumber) {
        BigDecimal totalChickenNumber = BigDecimal.valueOf(x + (employNumber * c));
        BigDecimal fryPerMinuteNumber = BigDecimal.valueOf(CEO_FRY_PER_MINUTE_NUMBER + (employNumber * f));
        double durationTime = totalChickenNumber.divide(fryPerMinuteNumber, 6, RoundingMode.HALF_UP).doubleValue();
        System.out.println("알바생 수: " + employNumber + " 총 치킨 수: " + totalChickenNumber + " 분당 튀길 수 있는 치킨 수 :" + fryPerMinuteNumber
                + " 총 걸리는 시간: " + durationTime);
        return durationTime;
    }
}

// 정확성 4.9점,  효율성 0점
