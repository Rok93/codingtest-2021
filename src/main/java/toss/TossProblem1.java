package toss;

public class TossProblem1 {
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료


        // 부가가치세: 과세의 대상이 되는 과세금액에 10%만큼 산정 (소수점 이하 첫째자리에서 올림 처리)
        // 과세 금액:  공급가액 - 비과세 금액
        // 비과세 금액: 부가가치세가 부과되지 않는 금액
        // 공급대가 = 공급가액 + 부가가치세 (봉사료가 없다면 공급대가는 주문금액과 같다)  = (숙박업 같은 분야) 주문금액 - 봉사료
        // '공급대가 - 비과세금액(과세 금액)'이 1인 경우 부가가치세는? ---> 0원으로 처리

        long 공급대가 = orderAmount - serviceFee;
        long 과세금액 = 공급대가 - taxFreeAmount;

        if (과세금액 == 1) {
            return 0;
        }

        double answer = 과세금액 * 0.1;

        return (long) Math.ceil(answer);
    }
}
