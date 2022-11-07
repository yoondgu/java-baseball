package baseball;

import baseball.controller.GameController;
import baseball.messages.OutputMessage;

public class Application {
    public static void main(String[] args) {
        System.out.println(OutputMessage.RUN_APPLICATION.message());
        try {
            GameController.runGame();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println(OutputMessage.EXIT_BY_ERROR.message());
            throw new IllegalArgumentException();
        }
    }
}
