package domain;

import domain.dto.FinalPlayerResponse;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinalResult {

    private final int dealer;
    private final Map<Player, Double> players;

    public FinalResult(Dealer dealer, List<Player> players) {
        this.dealer = 0;
        this.players = players.stream()
                .collect(Collectors.toMap(
                        player -> player,  // Key: 각 Player 객체
                        player -> 0.0      // Value: 초기값 0.0
                ));
        checkInitBlackjack(dealer, players);
    }

    public List<FinalPlayerResponse> createResponse() {
        List<FinalPlayerResponse> responses = new ArrayList<>();

        responses.add(new FinalPlayerResponse("딜러", dealer));

        for (Map.Entry<Player, Double> playerDoubleEntry : players.entrySet()) {
            FinalPlayerResponse response = new FinalPlayerResponse(
                    playerDoubleEntry.getKey().getName(),
                    playerDoubleEntry.getValue().intValue()
            );

            responses.add(response);
        }
        return responses;
    }

    public void increaseAmountByWinnerPlayer(Player player) {
        double money = player.calculateMultipleMoney(1.0);
        this.players.put(player, money);
    }

    public void decreaseAmountByDefeatPlayer(Player player) {
        double money = -player.calculateMultipleMoney(1.0);
        this.players.put(player, money);
    }

    public void addPlayer(Player player) {
        this.players.put(player, 0.0);
    }

    private void checkInitBlackjack(Dealer dealer, List<Player> players) {
        for (Player player : players) {
            if (player.isBlackjack()) {
                if (dealer.isBlackjack()) { // 무승부
                    players.remove(player);
                }

                // 승리
                this.players.put(player, player.calculateMultipleMoney(0.5));
                players.remove(player);
            }
        }
    }
}
