package util;

import domain.card.Card;
import domain.card.CardFactory;
import java.util.List;

public class RandomNumber {

    public static Card generateRandomCard() {
        List<Card> cards = CardFactory.create();
        return cards.get(generateRandomNumber(cards.size()));
    }

    private static int generateRandomNumber(int maximum) {
       return  (int) (Math.random() * maximum);
    }
}
