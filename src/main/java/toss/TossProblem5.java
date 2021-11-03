//package toss;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TossProblem5 {
//
//    private List<Integer> weights = new ArrayList<>();
//    private int[] fruitWeights;
//    private boolean[] picked;
//    private int k;
//
//    // N개의 과일이 있을 때, 연속된 K개의 과일을 골라 K개 중 가장 무거운 과일의 무게를 점수로 해서 가장 높은 점수가 나온사람이 계곡에 입수
//    /*
//    N개의 과일의 무게가 주어질 때, 나올 수 있는 모든 점수를 구하고 싶다.
//
//
//    N개의 과일의 무게 W[i]를 담고있는 배열 : fruitWeights ( 1 <= N <= 500,000),  1 <= W[i] <= 2,147,483,647)
//    상수 K : k (1 <= K <= N)
//     */
//    public int[] solution(int[] fruitWeights, int k) {
//        // k개
//
//        List<Integer> answer = new ArrayList<>();
//        for (int i = k; i < fruitWeights.length - k; i++) {
//            int sum = 0;
//            for (int j = 0; j < i; j++) {
//                sum += fruitWeights[j];
//            }
//            answer.add(sum);
//        }
//
//        return answer.stream()
//                .distinct()
//                .toArray();
//    }
//
//}
