package view;

import domain.dto.CardResponse;
import domain.dto.FinalPlayerResponse;
import domain.dto.PlayerInfoResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void printFinalResult(List<FinalPlayerResponse> responses) {
        System.out.println();
        System.out.println();
        System.out.println("## 최종 수익");

        for (FinalPlayerResponse response : responses) {
            System.out.printf("%s: %d", response.getName(), response.getAmount());
            System.out.println();
        }
    }

    public void printFinalDealerCard(PlayerInfoResponse playerInfoResponse) {
        String formatCards = formatCards(playerInfoResponse.getCardResponses());

        System.out.println();
        System.out.printf("%s 카드: %s - 결과: %d",
                playerInfoResponse.getName(),
                formatCards,
                playerInfoResponse.getTotalScore()
        );
    }

    public void printFinalPlayerCard(PlayerInfoResponse playerInfoResponse) {
        System.out.println();
        String formatCards = formatCards(playerInfoResponse.getCardResponses());
        System.out.printf("%s카드: %s - 결과 %d",
                playerInfoResponse.getName(),
                formatCards,
                playerInfoResponse.getTotalScore()
        );
    }

    public void printInitCard(List<String> playerNames) {
        System.out.println();
        System.out.printf("딜러와 %s에게 2장을 나누었습니다.", String.join(", ", playerNames));
    }

    public void printStartDealerCard(PlayerInfoResponse response) {
        CardResponse cardResponse = response.getCardResponses().get(0); // 딜러 카드는 한 장 공개
        String formatCards = formatCards(Collections.singletonList(cardResponse));

        System.out.println();
        System.out.printf("%s: %s", response.getName(), formatCards);
    }

    public void printStartPlayerCard(PlayerInfoResponse response) {
        System.out.println();
        System.out.printf("%s카드: %s", response.getName(), formatCards(response.getCardResponses()));
    }

    public void printDealerAddCard() {
        System.out.println();
        System.out.println();
        System.out.println("딜러는 16이하라 한 장의 카드를 더 받았습니다.");
    }

    private String formatCards(List<CardResponse> responses) {
        List<String> cardInfos = new ArrayList<>();

        for (CardResponse response : responses) {
            String cardInfo = response.getScore() + response.getType();
            cardInfos.add(cardInfo);
        }

        return String.join(", ", cardInfos);
    }
}
