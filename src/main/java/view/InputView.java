package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String readGamePlayer() {
        System.out.println("게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)");
        return SCANNER.nextLine();
    }
}
