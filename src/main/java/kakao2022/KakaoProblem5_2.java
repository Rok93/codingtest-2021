package kakao2022;

import java.util.ArrayList;
import java.util.List;

public class KakaoProblem5_2 { //todo: 시간나면 이 문제 풀기!
    private static final int SHEEP = 0;
    private static final int WOLF = 1;

    private List<Integer> results = new ArrayList<>();
    //    private int totalWolfNumber = 0;
//    private int totalSheepNumber = 0;
    private int[] info;
    private List<List<Integer>> graph;

    public int solution(int[] info, int[][] edges) {
        this.info = info;

        graph = new ArrayList<>();
        boolean[] visited = new boolean[info.length];

        for (int i = SHEEP; i <= info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[SHEEP];
            int to = edge[1];
            graph.get(from).add(to);
        }

        dfs(0, 0, 0);

        System.out.println(results);

        return 0;
    }

    private void dfs(int startIndex, int totalSheepNumber, int totalWolfNumber) {
        this.results.add(totalSheepNumber);

        for (Integer nextIndex : graph.get(startIndex)) {
            System.out.println("현재위치: " + startIndex + " 다음위치: " + nextIndex);
            if (this.info[startIndex] == SHEEP) {
                dfs(nextIndex, totalSheepNumber + 1, totalWolfNumber);
                continue;
            }

            if (totalSheepNumber > totalWolfNumber + 1) {
                dfs(nextIndex, totalSheepNumber, totalWolfNumber + 1);
            }
        }
    }
}
