package baseball.controller;

import baseball.messages.OutputMessage;
import baseball.service.GameService;
import baseball.utils.KeyboardReader;
import baseball.utils.MessagePrinter;
import baseball.vo.Result;

public class GameController {
    private static final KeyboardReader keyboardReader = KeyboardReader.getInstance();
    private static final GameService gameService = GameService.getInstance();

    public static void runGame() throws IllegalArgumentException {
        gameService.refreshComputerNumbers();

        boolean strikeAll = false;
        while (!strikeAll) {
            MessagePrinter.print(OutputMessage.GUESS_COMPUTER_NUMBERS);
            String guessingInput = keyboardReader.readLineOnlyInteger();
            Result guessResult = gameService.guessNumbers(guessingInput);
            MessagePrinter.printLine(guessResult.generateHintMessage());
            strikeAll = guessResult.strikeAll();
        }

        MessagePrinter.printLine(OutputMessage.PLAYER_WIN);
        MessagePrinter.printLine(OutputMessage.RESTART_OR_QUIT);
        boolean willRestart = keyboardReader.readWillRestart();
        if (willRestart) {
            runGame();
        }
    }
}
