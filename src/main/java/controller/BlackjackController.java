package controller;

import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;
import util.PlayerParser;
import util.RandomNumber;
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

        Dealer dealer = initDealerCards();
        initPlayerCards(players);
    }

    private void initPlayerCards(List<Player> players) {
        for (Player player : players) {
            addPlayerCard(player);
        }
    }

    private void addPlayerCard(Player player) {
        for (int loop = 0; loop < 2; loop++) {
            Card card = generateRandomCard();
            player.addCard(card);
        }
    }

    private Dealer initDealerCards() {
        Dealer dealer = new Dealer();
        addDealerCard(dealer);

        return dealer;
    }

    private void addDealerCard(Dealer dealer) {
        for (int loop = 0; loop < 2; loop++) {
            Card card = generateRandomCard();
            dealer.addCard(card);
        }
    }

    private Card generateRandomCard() {
        List<Card> cards = CardFactory.create();
        int index = RandomNumber.generateRandomNumber(0, cards.size());
        return cards.get(index);
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
