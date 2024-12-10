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
        List<Player> players = generatePlayers();
    }

    private List<Player> generatePlayers() {
        List<String> playerNames = getPlayerNames();
        List<Player> players1 = new ArrayList<>();
        for (String name : playerNames) {
            int money = inputView.readBettingMoney(name);
            players1.add(new Player(name, money));
        }

        return players1;
    }

    private List<String> getPlayerNames() {
        String input = inputView.readGamePlayers();
        return PlayerParser.parserInputPlayers(input);
    }
}
