package baseball.controller;

import baseball.messages.OutputMessage;
import baseball.service.GameService;
import baseball.utils.KeyboardReader;
import baseball.vo.Result;

public class GameController {
    private static final KeyboardReader keyboardReader = KeyboardReader.getInstance();
    private static final GameService gameService = GameService.getInstance();

    public static void runGame() throws IllegalArgumentException {
        gameService.refreshComputerNumbers();

        boolean strikeAll = false;
        while (!strikeAll) {
            System.out.print(OutputMessage.GUESS_COMPUTER_NUMBERS.message());
            String guessingInput = keyboardReader.readLineOnlyInteger();
            Result guessResult = gameService.guessNumbers(guessingInput);
            System.out.println(guessResult.generateHintMessage());
            strikeAll = guessResult.strikeAll();

        }

        System.out.println(OutputMessage.PLAYER_WIN.message());
        System.out.println(OutputMessage.RESTART_OR_QUIT.message());
        boolean willRestart = keyboardReader.readWillRestart();
        if (willRestart) {
            runGame();
        }
    }
}
