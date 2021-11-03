package kakao2022;

import java.util.Arrays;

// 정확성은 다 맞춤! (효율성 다 틀림)
public class KakaoProblem6 {

    public int solution(int[][] board, int[][] skill) {
        for (int[] skillInfo : skill) {
            int type = skillInfo[0]; // 1: 적의 공격, 2: 아군의 회복스킬
            int r1 = skillInfo[1]; // 행 (위, 아래)
            int c1 = skillInfo[2]; // 열 (좌, 우)
            int r2 = skillInfo[3];
            int c2 = skillInfo[4];
            int degree = skillInfo[5];

            if (type == 1) {
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        board[i][j] -= degree;
                    }
                }
                continue;
            }

            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    board[i][j] += degree;
                }
            }
        }

        return (int) Arrays.stream(board)
                .flatMapToInt(its -> Arrays.stream(its)
                        .filter(it -> it > 0))
                .count();
    }
}
