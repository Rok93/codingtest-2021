package anypointmedia;

public class AnyPointProblem1 {

    // 게임대회 총 N명 창가
    // 토너먼트 형식으로 진행
    // 참가자는 1 ... N번 배정     1<->2,  3<->4, 5<->6 ... 토너먼트 시작,
    // 토너먼트 방식으로 게임 진행 단, 다음 라운드에서 다시 1번부터 2/N번 까지 배정 받음.
    // 최종 1명이 남을 때까지 진행
    public int solution(int n, int a, int b) {
        int round = 1;
        while (!isClash(a, b)) {
            System.out.println("round = " + round);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            round++;
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);
        }

        return round;

    }

    private boolean isClash(int a, int b) {
        return Math.ceil((double) a / 2) == Math.ceil((double) b / 2);
    }
}
