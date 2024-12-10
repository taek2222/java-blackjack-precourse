package domain.user;

import domain.card.Card;

import domain.dto.CardResponse;
import domain.dto.PlayerInfoResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean isOverBlackjack() {
        return calculateTotalCardScore() > 21;
    }

    public boolean isBlackjack() {
        return calculateTotalCardScore() == 21;
    }

    public boolean isSevenTeenLessThanValue() {
        return calculateTotalCardScore() < 17;
    }

    public PlayerInfoResponse createResponse() {
        List<CardResponse> cardResponses = cards.stream()
                .map(Card::createResponse)
                .collect(Collectors.toList());

        return new PlayerInfoResponse(
                "딜러",
                cardResponses,
                calculateTotalCardScore()
        );
    }

    public int calculateTotalCardScore() {
        return cards.stream()
                .mapToInt(Card::getCardsScore)
                .sum();
    }
}
