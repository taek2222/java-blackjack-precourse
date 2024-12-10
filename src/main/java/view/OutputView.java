package view;

import domain.dto.CardResponse;
import domain.dto.PlayerInfoResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void printStartDealerCard(PlayerInfoResponse response) {
        System.out.println();
        System.out.printf("%s: ", response.getName());

        CardResponse cardResponse = response.getCardResponses().get(0); // 딜러 카드는 한 장 공개
        printCards(Collections.singletonList(cardResponse));
    }

    public void printStartPlayerCard(PlayerInfoResponse response) {
        System.out.printf("%s카드: ", response.getName());
        printCards(response.getCardResponses());
    }

    private void printCards(List<CardResponse> responses) {
        List<String> cardInfos = new ArrayList<>();

        for (CardResponse response : responses) {
            String cardInfo = response.getScore() + response.getType();
            cardInfos.add(cardInfo);
        }

        System.out.println(String.join(", ", cardInfos));
    }
}
