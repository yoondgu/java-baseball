package baseball.controller;

import baseball.service.GameService;
import baseball.utils.KeyboardReader;
import baseball.vo.Result;

public class GameController {
    private static final String INPUT_RESTART = "1";
    private static final String INPUT_QUIT = "2";

    private static final String MESSAGE_GUESS_COMPUTER_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_PLAYER_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MESSAGE_RESTART_OR_QUIT = "게임을 새로 시작하려면 " + INPUT_RESTART
                                                        + ", 종료하려면 " + INPUT_QUIT + "를 입력하세요.";

    private static final KeyboardReader keyboardReader = KeyboardReader.getInstance();
    private static final GameService gameService = GameService.getInstance();

    public static void runGame() throws IllegalArgumentException {
        gameService.refreshComputerNumbers();

        boolean strikeAll = false;
        while (!strikeAll) {
            System.out.print(MESSAGE_GUESS_COMPUTER_NUMBERS);
            String guessingInput = keyboardReader.readLineOnlyInteger();
            Result guessResult = gameService.guessNumbers(guessingInput);
            System.out.println(guessResult.generateHintMessage());
            strikeAll = guessResult.strikeAll();

        }

        System.out.println(MESSAGE_PLAYER_WIN);
        System.out.println(MESSAGE_RESTART_OR_QUIT);
        boolean willRestart = keyboardReader.readWillRestart();
        if (willRestart) {
            runGame();
        }
    }
}
