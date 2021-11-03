package kakao2022;

import java.util.*;

public class KakaoProblem3 {

    private int defaultPrice; // 기본 시간(분)
    private int defaultTime; // 기본 요금(원)
    private int unitTime; // 단위 시간(분)
    private int unitPrice; //단위 요금(원)

    public int[] solution(int[] fees, String[] records) {
        this.defaultPrice = fees[1];
        this.defaultTime = fees[0];
        this.unitTime = fees[2];
        this.unitPrice = fees[3];

        // 올림 요금법 조심할 것! Math.ceil() 쓰기!
        Map<String, Queue<Record>> map = new HashMap<>();
        for (String record : records) {
            String[] info = record.split(" ");

            String carNumber = info[1].trim();
            String timeStamp = info[0].trim();
            String status = info[2].trim();

            Record record1 = new Record(timeStamp, carNumber, status);

            if (!map.containsKey(carNumber)) {
                map.put(carNumber, new LinkedList<>());
            }
            map.get(carNumber).offer(record1);
        }

        for (String carNumber : map.keySet()) {
            if (map.get(carNumber).size() % 2 != 0) {
                map.get(carNumber).add(Record.createDefaultOutRecord(carNumber));
            }
        }

        // 남은걸로 시간 계산하면 됌!
        List<Receipt> receipts = new ArrayList<>();

        for (String carNumber : map.keySet()) {
            Queue<Record> recordsByCar = map.get(carNumber);
            int totalStayTime = 0;
            while (!recordsByCar.isEmpty()) {
                Record inRecord = recordsByCar.poll();
                Record outRecord = recordsByCar.poll();

                totalStayTime += inRecord.calculateTime(outRecord); // 총 머무른 시간!
            }

            int addPrice = (int) Math.ceil(((double) totalStayTime - defaultTime) / unitTime);
            if (addPrice < 0) {
                addPrice = 0;
            }

            int totalPrice = (defaultPrice + addPrice * unitPrice);
            receipts.add(new Receipt(carNumber, totalPrice));
        }

        return receipts.stream()
                .sorted()
                .mapToInt(Receipt::getPrice)
                .toArray();
    }

    public static class Record {
        private final String timeStamp;
        private final String carNumber;
        private STATUS status;

        public Record(String timeStamp, String carNumber, String status) {
            this(timeStamp, carNumber, STATUS.valueOf(status));
        }

        public Record(String timeStamp, String carNumber, STATUS status) {
            this.timeStamp = timeStamp;
            this.carNumber = carNumber;
            this.status = status;
        }

        public static Record createDefaultOutRecord(String carNumber) {
            return new Record("23:59", carNumber, STATUS.OUT);
        }

        public int calculateTime(Record outRecord) {
            String[] inTimeInfos = this.timeStamp.split(":");
            String[] outTimeInfos = outRecord.timeStamp.split(":");

            return (Integer.parseInt(outTimeInfos[0]) - Integer.parseInt(inTimeInfos[0])) * 60 +
                    (Integer.parseInt(outTimeInfos[1]) - Integer.parseInt(inTimeInfos[1]));
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public String getCarNumber() {
            return carNumber;
        }
    }

    public enum STATUS {
        IN, OUT;
    }


    public static class Receipt implements Comparable<Receipt> {
        private String carNumber;
        private int price;

        public Receipt(String carNumber, int price) {
            this.carNumber = carNumber;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(Receipt other) {
            return this.carNumber.compareTo(other.carNumber);
        }
    }
}
