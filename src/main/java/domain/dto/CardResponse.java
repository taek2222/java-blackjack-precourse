package domain.dto;

public class CardResponse {
    private final int score;
    private final String type;

    public CardResponse(int score, String type) {
        this.score = score;
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public String getType() {
        return type;
    }
}
