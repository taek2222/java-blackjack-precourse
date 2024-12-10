package domain.dto;

import java.util.Collections;
import java.util.List;

public class PlayerInfoResponse {

    private final String name;
    private final List<CardResponse> cardResponses;

    public PlayerInfoResponse(String name, List<CardResponse> cardResponses) {
        this.name = name;
        this.cardResponses = cardResponses;
    }

    public String getName() {
        return name;
    }

    public List<CardResponse> getCardResponses() {
        return Collections.unmodifiableList(cardResponses);
    }
}
