package domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.Symbol;
import domain.card.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    @ParameterizedTest
    @CsvSource({
            "10, -1",
            "5, 1",
            "8, 0"
    })
    void 카드_총합의_비교값을_반환한다(int cardScore, int expected) {
        // given
        Player player = new Player("test", 10000);
        player.addCard(new Card(Symbol.EIGHT, Type.SPADE));

        // when
        int result = player.compareScore(cardScore);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

}