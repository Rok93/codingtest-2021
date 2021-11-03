package kakao2022;

import java.util.*;
import java.util.stream.Collectors;

public class KakaoProblem1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportNumbers = new HashMap<>();
        Arrays.stream(id_list)
                .forEach(id -> reportNumbers.put(id, 0));

        List<Report> reports = Arrays.stream(report)
                .map(reportHistory -> translateReportForm(reportHistory))
                .distinct()
                .collect(Collectors.toList());

        reports.forEach(reportForm -> reportNumbers.put(reportForm.getTo(), reportNumbers.get(reportForm.getTo()) + 1));

        List<String> blackUsers = reportNumbers.entrySet().stream()
                .filter(entrySet -> entrySet.getValue() >= k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        Map<String, Integer> results = new LinkedHashMap<>();
        Arrays.stream(id_list)
                .forEach(id -> results.put(id, 0));

        reports.stream()
                .forEach(it -> registerResult(it, results, blackUsers));

        return results.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void registerResult(Report report, Map<String, Integer> results, List<String> blackUsers) {
        String from = report.getFrom();
        String to = report.getTo();
        if (blackUsers.contains(to)) {
            results.put(from, results.get(from) + 1);
        }
    }

    private Report translateReportForm(String reportHistory) {
        String[] reportInfo = reportHistory.split(" ");
        return new Report(reportInfo[0].trim(), reportInfo[1].trim());
    }

    public static class Report {
        private final String from;
        private final String to;

        public Report(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Report report = (Report) o;
            return Objects.equals(from, report.from) && Objects.equals(to, report.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}
