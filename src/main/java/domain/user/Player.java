package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        validatorName(name);
        validatorMoney(bettingMoney);
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    private void validatorName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validatorMoney(double bettingMoney) {
        if (bettingMoney < 5_000 || 10_000_000 < bettingMoney) {
            throw new IllegalArgumentException();
        }
    }
}
