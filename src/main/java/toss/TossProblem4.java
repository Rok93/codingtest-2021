package toss;

public class TossProblem4 {
    private static final String SEPERATOR = "\\n";

    // 홈 화면에 유용한 '금융정보'를 보여주기로 했다.

    /**
     * 유용한 정보라도 너무 자주 보여주면 유저들에게 불편할함을 줄 수 있어, 빈도를 조절하여 적절히 노출하려 한다.
     * 다음과 같은 방법으로 노출을 결정하는 코드를 작성하라!
     * <p>
     * * 유용한 금융정보는 하루에 여러 번 노출 될 수 있다.
     * * M일 동안 N회 노출이 되었거나 유저가 거부하면, 더 이상 노출하지 않으며, 다음날부터 M일까지 유용한 금융 정보를 노출하지 않는다.
     */
    public String solution(String input) {
        String[] commands = input.split(SEPERATOR);

        String[] MN = commands[0].split(" ");
        int M = Integer.parseInt(MN[0]); // M일동안
        int N = Integer.parseInt(MN[1]); // N회 노출이 되었다면... 노출 X


        StringBuilder sb = new StringBuilder();
        sb.append(MN);

        int cnt = 0;
        for (int i = 1; i < commands.length; i++) { // 첫째줄은 안씀!
            String command = commands[i];

            if (command.equals("NEGATIVE")) {
                sb.append("0" + SEPERATOR);
                continue;
            }

            if (command.equals("NEXT")) {
                sb.append("-" + SEPERATOR);
                continue;
            }

            if (command.equals("SHOW")) {
                if (cnt < N) {
                    cnt++;
                    sb.append("1" + SEPERATOR);
                    continue;
                } else {
                    sb.append("0" + SEPERATOR);
                }
            }

            if (command.equals("EXIT")) {
                sb.append("BYE");
                break;
            }

            sb.append("ERROR" + SEPERATOR);
        }

        return sb.toString();
    }
}
