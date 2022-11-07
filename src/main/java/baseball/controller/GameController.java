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
        repeatUntilPlayerWin();
        selectRestartOrQuit();
    }

    public static void informExitByError(Exception exception) {
        if (exception.getMessage() != null) {
            MessagePrinter.printLine("\n" + exception.getMessage());
        }
        MessagePrinter.printLine(OutputMessage.EXIT_BY_ERROR);
    }

    private static void repeatUntilPlayerWin() throws IllegalArgumentException {
        boolean strikeAll = false;
        while (!strikeAll) {
            MessagePrinter.print(OutputMessage.GUESS_COMPUTER_NUMBERS);
            String guessingInput = keyboardReader.readLineOnlyInteger();
            Result guessResult = gameService.guessNumbers(guessingInput);
            MessagePrinter.printLine(guessResult.generateHintMessage());
            strikeAll = guessResult.strikeAll();
        }
    }

    private static void selectRestartOrQuit() throws IllegalArgumentException {
        MessagePrinter.printLine(OutputMessage.PLAYER_WIN);
        MessagePrinter.printLine(OutputMessage.RESTART_OR_QUIT);
        if (keyboardReader.readWillRestart()) {
            runGame();
        }
    }
}
