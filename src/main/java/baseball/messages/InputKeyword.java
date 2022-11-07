package baseball.messages;

public enum InputKeyword {
    RESTART("1"),
    QUIT("2")
    ;

    private final String keyword;

    InputKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String keyword() {
        return keyword;
    }
}
