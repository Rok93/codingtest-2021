package kakao2022;

import java.util.Arrays;

public class KakaoProblem4 {

    private static final int[] SCORE_BOARD = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public int[] solution(int n, int[] info) {
        int[] answer = {};

//        int[] info = new int[11];
//        Arrays.stream(info)
//                .forEach(it -> info[it]++);

        int[] ryanScoreBoard = new int[11];

        for (int i = 0; i < SCORE_BOARD.length; i++) {
            if (info[i] >= n) {
                continue;
            }

            int investHitValue = info[i] + 1;
            System.out.println("appeach가 맞춘 갯수:" + info[i] + " 라이언이 맞춰야는 갯수: " + investHitValue);

            int subScore = 0;
            int count = investHitValue;
            for (int k = i + 1; k < SCORE_BOARD.length; k++) {
                if (count <= 0) {
                    break;
                }

                if (info[k] == 0) {
                    count--;
                    System.out.print(SCORE_BOARD[k] + " ");
                    subScore += SCORE_BOARD[k];
                    continue;
                }
            }

            System.out.println(SCORE_BOARD[i] + "를 포기하고 얻을 수 있는 점수 = " + subScore);
            if (subScore > SCORE_BOARD[i]) { // 여기에 투자하지 않는다!
                System.out.println(SCORE_BOARD[i] + "점은 포기한다");
                continue;
            }

            n -= investHitValue;
            ryanScoreBoard[i] += investHitValue;
        }

        return answer;
    }
}
