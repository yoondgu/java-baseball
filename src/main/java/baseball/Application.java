package baseball;

import baseball.controller.GameController;

public class Application {
    private static final String MESSAGE_RUN_APP = "숫자 야구 게임을 시작합니다.";
    private static final String MESSAGE_ERROR_RETURN = "오류로 인해 게임을 종료합니다.";
    public static void main(String[] args) {
        System.out.println(MESSAGE_RUN_APP);
        try {
            GameController.runGame();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println(MESSAGE_ERROR_RETURN);
            throw new IllegalArgumentException();
        }
    }
}
