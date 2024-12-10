package controller;

import domain.user.Player;
import java.util.ArrayList;
import java.util.List;
import util.PlayerParser;
import view.InputView;
import view.OutputView;

public class BlackjackController {

    private final InputView inputView;
    private final OutputView outputView;

    public BlackjackController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.readGamePlayers();
        List<String> players = PlayerParser.parserInputPlayers(input);

        List<Player> players1 = new ArrayList<>();
        for (String player : players) {
            int money = inputView.readBettingMoney(player);
            players1.add(new Player(player, money));
        }
    }
}
