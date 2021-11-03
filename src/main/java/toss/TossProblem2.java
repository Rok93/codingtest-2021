//package toss;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TossProblem2 {
//
//    // 라운드로빈 방식 어쩌고...
//    public int[][] solution(int servers, boolean sticky, int[] requests) {
//        List<List<Integer>> answer = new ArrayList<>();
//
//        List<Integer> distinctRequests = Arrays.stream(requests)
//                .distinct()
//                .mapToObj(Integer::valueOf)
//                .collect(Collectors.toList());
//
//        for (List<Integer> loadBanlancer : answer) {
//            if (loadBanlancer.contains(request)) {
//                loadBanlancer.add(request);
//                break;
//            }
//        }
//
//        for (int request : requests) {
//            if ()
//
//            for (List<Integer> loadBanlancer : answer) {
//                if (loadBanlancer.contains(request)) {
//                    loadBanlancer.add(request);
//                    break;
//                }
//            }
//
//            System.out.println("이거 시작하는거지?");
//        }
//
//
//
//        return new int[][] {};
//    }
//}
