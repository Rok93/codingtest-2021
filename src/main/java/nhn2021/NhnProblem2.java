package nhn2021;

import java.util.*;
import java.util.stream.Collectors;

public class NhnProblem2 {
    public static void main(String[] args) {

        // 총 N개의 이웃나라
        // 최대 K개 폭파 가능!!

        //주파수는 20이하의 자연수

        int[] frequencies = new int[21]; // 1 ~ 20

        List<Frequency> chart = new ArrayList<>();

//        핵심로직!
//        chart.stream()
//                .sorted(Comparator.reverseOrder())
//                .limit(K)
//                .mapToInt(Frequency::getCount)
//                .sum();
    }

    public static class Frequency implements Comparable<Frequency> {
        private final int value;
        private int count = 0;

        public Frequency(int value) {
            this.value = value;
        }

        public void add() {
            this.count++;
        }

        public int getValue() {
            return value;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(Frequency o) {
            if (this.count > o.count) {
                return 1;
            }

            return -1;
        }
    }

    @Override
    public String toString() {
        return "NhnProblem2{}";
    }

    public static enum A {
        BB, CC
    }
}
