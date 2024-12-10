package view;

import java.util.Scanner;
import validation.CommonValidator;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public boolean readAddCardChoice(String name) {
        System.out.println();
        System.out.println();
        System.out.printf("%s는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", name);
        System.out.println();

        String input = SCANNER.nextLine().toUpperCase();

        validateBoolean(input);
        return input.equals("Y");
    }

    public String readGamePlayers() {
        System.out.println("게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)");
        return SCANNER.nextLine();
    }

    public int readBettingMoney(String name) {
        System.out.println();
        System.out.printf("%s의 배팅 금액은?", name);
        System.out.println();

        String input = SCANNER.nextLine();
        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateBoolean(String input) {
        if (!input.equals("Y") && !input.equals("N")) {
            throw new IllegalArgumentException();
        }
    }
}
