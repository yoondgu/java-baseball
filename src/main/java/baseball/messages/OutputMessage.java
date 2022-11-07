package baseball.messages;

public enum OutputMessage {
    RUN_APPLICATION("숫자 야구 게임을 시작합니다."),
    EXIT_BY_ERROR("오류로 인해 어플리케이션이 종료됩니다."),
    GUESS_COMPUTER_NUMBERS("숫자를 입력해주세요 : "),
    PLAYER_WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_QUIT("게임을 새로 시작하려면 " + InputKeyword.RESTART.keyword()
            + ", 종료하려면 " + InputKeyword.QUIT.keyword() + "를 입력하세요.")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
