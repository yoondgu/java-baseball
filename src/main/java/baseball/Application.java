package baseball;

import baseball.controller.GameController;
import baseball.messages.OutputMessage;
import baseball.utils.MessagePrinter;

public class Application {
    public static void main(String[] args) {
        MessagePrinter.printLine(OutputMessage.RUN_APPLICATION);
        try {
            GameController.runGame();
        } catch (IllegalArgumentException e) {
            MessagePrinter.printLine("\n" + e.getMessage());
            MessagePrinter.printLine(OutputMessage.EXIT_BY_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
