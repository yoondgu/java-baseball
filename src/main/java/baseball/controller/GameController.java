package baseball.controller;

import baseball.service.GameService;
import baseball.utils.KeyboardReader;

public class GameController {
    private static final int NUMBER_RESTART = 1;
    private static final int NUMBER_QUIT = 2;

    private static final String MESSAGE_GUESS_COMPUTER_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_STRIKE_ALL = "3스트라이크";
    private static final String MESSAGE_PLAYER_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MESSAGE_RESTART_OR_QUIT = "게임을 새로 시작하려면 " + NUMBER_RESTART
                                                        + ", 종료하려면 " + NUMBER_QUIT + "를 입력하세요.";

    private static final KeyboardReader keyboardReader = KeyboardReader.getInstance();
    private static final GameService gameService = GameService.getInstance();

    public static void runGame() throws IllegalArgumentException {
        gameService.refreshComputerNumbers();
        String hintMessage = "힌트 초기화";
        while (!strikeAll(hintMessage)) {
            System.out.print(MESSAGE_GUESS_COMPUTER_NUMBERS);
            String guessingNumber = keyboardReader.readIntegerLine();
            hintMessage = gameService.guessNumbers(guessingNumber);
            System.out.println(hintMessage);
        }
    }

    private static boolean strikeAll(String hintMessage) {
        if (MESSAGE_STRIKE_ALL.equals(hintMessage)) {
            return true;
        }
        return false;
    }
}
