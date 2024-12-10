package view;

import java.util.Scanner;
import validation.CommonValidator;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

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
}
