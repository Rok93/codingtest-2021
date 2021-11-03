package toss;

public class TossProblem3 {

    // 가짜 영수증은 금액이 옳지 않게 적혀있다.
    // 옳은 금액은 다음의 조건을 만족

    /**
     * 옳은 금액은 0 ~ 9 사이의 숫자 또는 구분자(,)로만 구성
     * ex (10,000원, +300)은 0 ~ 9 사이의 숫자 또는 구분자(,)가 아닌 문자가 포함되어 있으므로 옳지 않은 금액이다. (o)
     * 금액이 0원인 경우를 제외하고는 가장 왼쪽 숫자가 0일 수 없다. 0100 <-- 은 옳지 않다. (o)
     * 금액은 세자리 구분자(,)를 포함하고 있거나, 또는 전혀 포함하고 있지 않다.  ex 24,999,99 는 옳지 않다. (o)
     * 가장 왼쪽 끝이나 오른쪽 끝에는 구분자를 두지 않는다. 예를 들면, 10,000과 ,999,000은 모두 옳지 않다. (o)
     */
    public boolean solution(String amountText) {
        if (amountText.startsWith(",") || amountText.endsWith(",")) { // 앞 뒤로 구분자 있는 경우 X
            return false;
        }

        if (amountText.contains(",")) { // , 구분자를 사용한다면 전부 다 사용해야한다!
            try {
                validateAmountText(amountText);
            } catch (IllegalStateException e) {
                return false;
            }
        }

        char[] chars = amountText.toCharArray();
        for (char amountChar : chars) {
            if (!Character.isDigit(amountChar) && amountChar != ',') {
                return false;
            }
        }

        if (!amountText.equals("0") && amountText.startsWith("0")) { // 0이 아닌데 0으로 시작하는 경우
            return false;
        }

        return true;
    }

    private void validateAmountText(String amountText) {
        int length = amountText.length();
        for (int i = length - 4; i >= 0; i -= 3) {
            if (amountText.charAt(i) != ',') {
                throw new IllegalStateException();
            }
        }
    }

}
