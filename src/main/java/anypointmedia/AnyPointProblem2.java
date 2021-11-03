package anypointmedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnyPointProblem2 {

    public String[] solution(String[] card, String[] word) {
        List<String> answer = new ArrayList<>();

        int length = card.length;
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<String> temp = new ArrayList<>();
            Arrays.stream(card[i].split(""))
                    .forEach(eachCard -> temp.add(eachCard));
            list.add(temp);
        }

        // deep copy가 필요할 듯!

        List<String> cards = Arrays.stream(card)
                .flatMap(c -> Arrays.stream(c.split("")))
                .collect(Collectors.toList());

        List<List<String>> copyList;
        for (String eachWord : word) {
            copyList = new ArrayList<>(list);

            boolean[] visited = new boolean[card.length];
            List<String> wordEachCards = Arrays.stream(eachWord.split(""))
                    .collect(Collectors.toList());

            for (String wordEachCard : wordEachCards) {
                for (int i = 0; i < copyList.size(); i++) {
                    List<String> lineCards = copyList.get(i);
                    if (lineCards.contains(wordEachCard)) {
                        lineCards.remove(wordEachCard);
                        visited[i] = true;
                        break;
                    }
                }
            }

            if (isAllVisited(visited) && isAlright(cards, eachWord)) {
                answer.add(eachWord);
            }
        }

        String[] actual = answer.stream()
                .toArray(String[]::new);
        return answer.isEmpty() ? new String[]{"-1"} : actual;
    }

    private boolean isAllVisited(boolean[] visited) {
        for (boolean visit : visited) {
            if (visit == false) {
                return false;
            }
        }

        return true;
    }

    private boolean isAlright(List<String> cards, String word) {
        boolean ac = Arrays.stream(word.split(""))
                .allMatch(eachWord -> cards.contains(eachWord));
        return ac;
    }
}
