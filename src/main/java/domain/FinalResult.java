package domain;

import domain.user.Dealer;
import domain.user.Player;
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

    private void checkInitBlackjack(Dealer dealer, List<Player> players) {
        for (Player player : players) {
            if (player.isBlackjack()) {
                if (dealer.isBlackjack()) { // 무승부
                    players.remove(player);
                }

                // 승리
                this.players.put(player, player.calculateFinalMoney(1.5));
                players.remove(player);
            }
        }
    }
}
