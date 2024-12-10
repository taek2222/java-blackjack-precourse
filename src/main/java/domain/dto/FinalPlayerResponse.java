package domain.dto;

public class FinalPlayerResponse {
    private final String name;
    private final int amount;

    public FinalPlayerResponse(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
