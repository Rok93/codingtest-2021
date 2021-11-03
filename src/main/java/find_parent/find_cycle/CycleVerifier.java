package find_parent.find_cycle;

import java.util.Scanner;

public class CycleVerifier {

    // 특정 원소가 속한 집합을 찾기
    private static int findParent(int[] parent, int x) {
        // 루트 노드를 찾을 때까지 재귀 호출
        if (parent[x] != x) {
            parent[x] = findParent(parent, x);
        }

        return parent[x];
    }

    // 두 원소가 속한 집합을 합치기
    private static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a < b) {
            parent[b] = a;
            return;
        }

        parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 노드의 개수와 간선의 개수 입력 받기
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        boolean cycle = false; // 사이클 발생 여부!

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 사이클이 발생한 경우 종료
            if (findParent(parent, a) == findParent(parent, b)) {
                cycle = true;
                break;
            }

            unionParent(parent, a, b);
        }

        if (cycle) {
            System.out.println("사이클이 발생했습니다.");
            return;
        }

        System.out.println("사이클이 발생하지 않았습니다.");
    }
}
