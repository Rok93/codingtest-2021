package find_parent;

import java.util.Scanner;

public class FindParent {

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int[] parent, int x) {

        if (parent[x] != x) {
            return findParent(parent, parent[x]);
        }

        return x;
    }

    // 특정 원소가 속한 집합을 찾기 (경로 압축 버전)
    public static int upgradeFindParent(int[] parent, int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출하여 바로 부모 테이블의 값을 갱신
        if (parent[x] != x) {
            parent[x] =  findParent(parent, parent[x]);
        }

        return parent[x];
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int[] parent, int a, int b) {
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
        // 노드의 개수와 간선(Union 연산)의 개수 입력 받기
        int v = sc.nextInt();
        int e = sc.nextInt();

        // 부모 테이블 초기화하기
        int[] parent = new int[v + 1];

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(parent, a, b);
        }

        // 각 원소가 속한 집합 출력하기
        System.out.println("각 원소가 속한 집합 ");
        for (int i = 1; i <= v; i++) {
            System.out.print(upgradeFindParent(parent, i) + ' ');
        }
        System.out.println();

        System.out.println("부모 테이블 내용 출력하기");
        for (int i = 1; i <= v ; i++) {
            System.out.print(parent[i] + ' ');
        }
        System.out.println();
    }

}
