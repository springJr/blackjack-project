package practice.blackjack.domain;

public enum Sexs {
    MALE("남성"), FEMALE("여성");

    private final String description;

    Sexs(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
