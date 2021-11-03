package scatterlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ScProblem1 {


    // 온도 (20점 만점)
    /*
    20점에서 현재 온도와 22도의 차이의 절대값을 뺀다. (온도 점수: 20 - Math.abs(현재온도 - 22))
    */

    // 날씨 (20점 만점)
    /*
     * 맑음 / 구름조금: 20점
     * 구름 많음: 17점
     * 흐림: 10점
     * 비: 5점
     * 눈: 14점
     */

    // 온도, 날씨 점수 합산해서 점수가 가장 높은 날을 선정
    // **동점인 경우** 토, 금, 일, 수, 목, 화, 월  요일 순으로 우선권

    public int[] solution(int[][] data) {
        List<Date> dates = parsingToDates(data);

        int[] answer = new int[2];
        Collections.sort(dates);

        answer[0] = dates.remove(0).getWeekDayIndex();

        List<Date> worstDates = dates.stream()
                .filter(Date::isWorstWeather)
                .sorted()
                .collect(Collectors.toList());
        answer[1] = worstDates.isEmpty() ? -1 : worstDates.get(worstDates.size() - 1).getWeekDayIndex();

        return answer;
    }

    private List<Date> parsingToDates(int[][] data) {
        int length = data.length;
        List<Date> dates = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            int[] dayInfos = data[index];
            int skyStatus = dayInfos[0];
            int precipitationStatus = dayInfos[1];
            int temperature = dayInfos[2];
            Date date = new Date(WeekOfDay.of(index), skyStatus, precipitationStatus, temperature);
            dates.add(date);
        }
        return dates;
    }

    class Date implements Comparable<Date> {

        private final WeekOfDay weekOfDay;
        private final int weatherPoint;
        private final boolean isWorstWeather;

        public Date(WeekOfDay weekOfDay, int skyStatus, int precipitationStatus, int temperature) {
            this.weekOfDay = weekOfDay;
            this.weatherPoint = initializeWeatherPoint(skyStatus, precipitationStatus, temperature);
            this.isWorstWeather = initializeWeather(skyStatus, precipitationStatus, temperature);
        }

        private int initializeWeatherPoint(int skyStatus, int precipitationStatus, int temperature) {
            int temperaturePoint = 20 - Math.abs(temperature - 22);
            int skyStatusPoint = SkyStatus.of(skyStatus).point;
            int precipitationStatusPoint = PrecipitationStatus.of(precipitationStatus).point;

//            int weatherPoint = Math.min(skyStatusPoint, precipitationStatusPoint);
            return temperaturePoint + Math.min(skyStatusPoint, precipitationStatusPoint);
        }

        private boolean initializeWeather(int skyStatus, int precipitationStatus, int temperature) {
            if (SkyStatus.of(skyStatus).isWorstSkyStatus() || PrecipitationStatus.of(precipitationStatus).isWorstSkyStatus()) {
                return true;
            }

            if (temperature >= 30 || temperature <= 0) {
                return true;
            }

            return false;
        }

        public int getWeatherPoint() {
            return weatherPoint;
        }

        public int getWeekDayIndex() {
            return this.weekOfDay.getIndex();
        }

        public boolean isWorstWeather() {
            return isWorstWeather;
        }

        @Override
        public int compareTo(Date o) {
            if (this.isWorstWeather && !o.isWorstWeather) {
                return 1;
            }

            if (!this.isWorstWeather && o.isWorstWeather) {
                return -1;
            }

            if (this.weatherPoint < o.weatherPoint) { // 둘다 '가장 소개팅을 하면 안되는 날'인 경우, 날씨 포인트
                return 1;
            }

            if (this.weatherPoint > o.weatherPoint) {
                return -1;
            }

            if (this.weekOfDay.priority > o.weekOfDay.priority) { // 날씨 포인트 같은 경우, 요일 선호도
                return 1;
            }

            return -1;
        }
    }

    enum WeekOfDay {
        MONDAY(0, 7), TUESDAY(1, 6), WEDNESDAY(2, 4), THURSDAY(3, 5), FRIDAY(4, 2), SATURDAY(5, 1), SUNDAY(6, 3);

        private final int index;
        private final int priority;

        WeekOfDay(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public boolean isEqualIndex(int index) {
            return this.index == index;
        }

        public static WeekOfDay of(int index) {
            return Arrays.stream(values())
                    .filter(weekOfDay -> weekOfDay.isEqualIndex(index))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public int getIndex() {
            return index;
        }
    }

    enum SkyStatus {
        SUNNY(1, 20), SMALL_CLOUD(2, 20), LARGE_CLOUD(3, 17), FADE(4, 10);

        private final int index;
        private final int point;

        SkyStatus(int index, int point) {
            this.index = index;
            this.point = point;
        }

        public boolean isEqualIndex(int index) {
            return this.index == index;
        }

        public boolean isWorstSkyStatus() {
            return this == FADE;
        }

        public static SkyStatus of(int index) {
            return Arrays.stream(values())
                    .filter(status -> status.isEqualIndex(index))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum PrecipitationStatus {
        NONE(0, 20), RAIN(1, 5), SNOW(2, 14);

        private final int index;
        private final int point;

        PrecipitationStatus(int index, int point) {
            this.index = index;
            this.point = point;
        }

        public boolean isEqualIndex(int index) {
            return this.index == index;
        }

        public boolean isWorstSkyStatus() {
            return this == RAIN;
        }

        public static PrecipitationStatus of(int index) { // todo: 수정
            return Arrays.stream(values())
                    .filter(status -> status.isEqualIndex(index))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}

// 100점  (유지 보수성을 높이는 방향으로 짜라는데....  코드 퀄리티를 보는 듯함)
