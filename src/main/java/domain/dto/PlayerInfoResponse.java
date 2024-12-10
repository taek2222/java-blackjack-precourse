package domain.dto;

import java.util.Collections;
import java.util.List;

public class PlayerInfoResponse {

    private final String name;
    private final List<CardResponse> cardResponses;
    private final int totalScore;

    public PlayerInfoResponse(String name, List<CardResponse> cardResponses, int totalScore) {
        this.name = name;
        this.cardResponses = cardResponses;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public List<CardResponse> getCardResponses() {
        return Collections.unmodifiableList(cardResponses);
    }

    public int getTotalScore() {
        return totalScore;
    }
}
