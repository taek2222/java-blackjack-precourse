package controller;

import static util.RandomNumber.generateRandomCard;

import domain.FinalResult;
import domain.card.Card;
import domain.dto.PlayerInfoResponse;
import domain.user.Dealer;
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
        Dealer dealer = initDealerCards();
        List<Player> players = initPlayerCards();
        displayInitCards(dealer, players);

        FinalResult finalResult = new FinalResult(dealer, players);
        processAddPlayersCard(players);
        checkAddDealerCard(dealer);
        checkDealerBust(dealer, players, finalResult);

        processFinalResult(dealer, players, finalResult);
        displayFinalResult(dealer, players, finalResult);
    }

    private void displayFinalResult(Dealer dealer, List<Player> players, FinalResult finalResult) {
        outputView.printFinalResult(finalResult.createResponse());
        displayFinalCards(dealer, players);
    }

    private void processFinalResult(Dealer dealer, List<Player> players, FinalResult finalResult) {
        int dealerScore = dealer.calculateTotalCardScore();
        for (Player player : players) {
            if (player.compareScore(dealerScore) < 0 || player.isBust()) {
                finalResult.decreaseAmountByDefeatPlayer(player);
                continue;
            }

            if (player.compareScore(dealerScore) > 0) {
                finalResult.increaseAmountByWinnerPlayer(player);
                continue;
            }
            finalResult.addPlayer(player);
        }
    }

    private void displayFinalCards(Dealer dealer, List<Player> players) {
        outputView.printFinalDealerCard(dealer.createResponse());
        for (Player player : players) {
            outputView.printFinalPlayerCard(player.createResponse());
        }
    }

    private void checkDealerBust(Dealer dealer, List<Player> players, FinalResult finalResult) {
        if (dealer.isBust()) {
            for (Player player : players) {
                finalResult.increaseAmountByWinnerPlayer(player);
                players.remove(player);
            }
        }
    }

    private void displayInitCards(Dealer dealer, List<Player> players) {
        displayInitDealerCard(dealer);
        displayInitPlayersCard(players);
    }

    private List<Player> initPlayerCards() {
        List<String> playerNames = getPlayerNames();
        List<Player> players = generatePlayers(playerNames);
        outputView.printInitCard(playerNames);
        initPlayerCards(players);
        return players;
    }

    private void checkAddDealerCard(Dealer dealer) {
        if (dealer.isSevenTeenLessThanValue()) {
            addDealerCard(dealer);
            outputView.printDealerAddCard();
        }
    }

    private void processAddPlayersCard(List<Player> players) {
        for (Player player : players) {
            if (player.isTwentyOneLessThanValue()) {
                processAddCard(player);
            }
        }
    }

    private void processAddCard(Player player) {
        if (inputView.readAddCardChoice(player.getName())) {
            addPlayerCard(player);
            outputView.printStartPlayerCard(player.createResponse());
            return;
        }
        outputView.printStartPlayerCard(player.createResponse());
    }

    private void displayInitPlayersCard(List<Player> players) {
        for (Player player : players) {
            PlayerInfoResponse response1 = player.createResponse();
            outputView.printStartPlayerCard(response1);
        }
    }

    private void displayInitDealerCard(Dealer dealer) {
        PlayerInfoResponse response = dealer.createResponse();
        outputView.printStartDealerCard(response);
    }

    private void initPlayerCards(List<Player> players) {
        for (Player player : players) {
            addPlayerCards(player);
        }
    }

    private void addPlayerCards(Player player) {
        for (int loop = 0; loop < 2; loop++) {
            addPlayerCard(player);
        }
    }

    private void addPlayerCard(Player player) {
        Card card = generateRandomCard();
        player.addCard(card);
    }

    private Dealer initDealerCards() {
        Dealer dealer = new Dealer();
        addDealerCards(dealer);

        return dealer;
    }

    private void addDealerCards(Dealer dealer) {
        for (int loop = 0; loop < 2; loop++) {
            addDealerCard(dealer);
        }
    }

    private void addDealerCard(Dealer dealer) {
        Card card = generateRandomCard();
        dealer.addCard(card);
    }

    private List<Player> generatePlayers(List<String> playerNames) {
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
