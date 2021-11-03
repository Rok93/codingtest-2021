package kakao2022;

import java.util.*;

public class KakaoProblem5 {

    private static final int SHEEP = 0;
    private static final int WOLF = 1;

    public int solution(int[] info, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();
//        boolean[] visited = new boolean[info.length];

        for (int i = SHEEP; i <= info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[SHEEP];
            int to = edge[1];
            graph.get(from).add(new Node(to, info[to]));
        }

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, SHEEP));

        int totalSheepNumber = 0;
        int totalWolfNumber = 0;
        while (!queue.isEmpty()) {
            System.out.println("양 숫자 : " + totalSheepNumber);
            System.out.println("늑대 숫자 : " + totalWolfNumber);
            Node currentNode = queue.poll();
            System.out.println("현재 노드 index: " + currentNode.getIndex());

            if (currentNode.isSheep()) { // 양이면 그냥 바로 더하고 다음단계 넘어가자!
                totalSheepNumber++;
                for (Node node : graph.get(currentNode.getIndex())) {
                    queue.offer(node);
                }
                continue;
            }

            // 늑대라면... (생각해보면 다음 녀석도 늑대겠네.. 양이면 우선순위로 처리 다 했으니까!)
            if (graph.get(currentNode.getIndex()).isEmpty() || !hasSheep(graph, currentNode.getIndex())) { // 다음 노드가 없고 늑대라면, 전략적으로 안 더하는게 이득!
                continue;
            }

            if (totalSheepNumber <= totalWolfNumber + 1) {
                break;
            }
            // 누가 더 많이 가지고 있냐를 비교해야함!
            if (queue.isEmpty()) {
                totalWolfNumber++;

                for (Node node : graph.get(currentNode.getIndex())) {
                    queue.offer(node);
                }
                continue;
            } else {
                //비교해야함!
                Node rightNode = queue.poll();

                int leftSideSheepNumber = getSheepNumber(graph, currentNode.getIndex());
                int rightSideSheepNumber = getSheepNumber(graph, rightNode.getIndex());

                totalWolfNumber++;
                if (leftSideSheepNumber > rightSideSheepNumber) {
                    for (Node node : graph.get(currentNode.getIndex())) {
                        queue.offer(node);
                    }

                    for (Node node : graph.get(rightNode.getIndex())) {
                        queue.offer(node);
                    }

                } else {
                    for (Node node : graph.get(rightNode.getIndex())) {
                        queue.offer(node);
                    }

                    for (Node node : graph.get(currentNode.getIndex())) {
                        queue.offer(node);
                    }
                }
            }

            if (currentNode.finishTry()) {
                continue;
            }

            currentNode.addTryNumber();
            queue.offer(currentNode);
        }
        System.out.println("---------------");

        return totalSheepNumber;
    }

    private int getSheepNumber(List<List<Node>> graph, int index) {
        int totalSheepNumber = 0;
        Queue<Node> queue = new LinkedList<>();
        for (Node node : graph.get(index)) {
            queue.offer(node);
        }

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.isSheep()) {
                totalSheepNumber++;
                continue;
            }

            for (Node node : graph.get(currentNode.getIndex())) {
                queue.offer(node);
            }
        }

        return totalSheepNumber;
    }

    private boolean hasSheep(List<List<Node>> graph, int index) {
        Queue<Node> queue = new LinkedList<>();
        for (Node node : graph.get(index)) {
            queue.offer(node);
        }

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.isSheep()) {
                return true;
            }

            for (Node node : graph.get(currentNode.getIndex())) {
                queue.offer(node);
            }
        }

        return false;
    }

    public static class Node implements Comparable<Node> {
        private int tryCount = 0;
        private final int index;
        private final int animal;

        public Node(int index, int animal) {
            this.index = index;
            this.animal = animal;
        }

        public int getIndex() {
            return index;
        }

        public boolean isSheep() {
            return animal == SHEEP;
        }

        public boolean isWolf() {
            return animal == WOLF;
        }

        @Override
        public int compareTo(Node o) {
            if (this.animal - o.animal < 0) {
                return -1;
            } else {
                if (index - o.index < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }

        public void addTryNumber() {
            this.tryCount++;
        }

        public boolean finishTry() {
            return this.tryCount == 2;
        }
    }
}
