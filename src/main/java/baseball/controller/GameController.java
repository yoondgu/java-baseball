package baseball.controller;

import baseball.utils.KeyboardReader;
import baseball.vo.Computer;
import baseball.vo.Player;

import java.util.List;

public class GameController {
    private static final int NUMBER_RESTART = 1;
    private static final int NUMBER_QUIT = 2;
    private static final String MESSAGE_GUESS_COMPUTER_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_PLAYER_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MESSAGE_RESTART_OR_QUIT = "게임을 새로 시작하려면 " + NUMBER_RESTART
                                                        + ", 종료하려면 " + NUMBER_QUIT + "를 입력하세요.";

    // TODO Service 클래스로 리팩토링하며 옮길것
    private static final Computer computer = Computer.getInstance();
    private static final Player player = Player.getInstance();
    private static final KeyboardReader keyboardReader = KeyboardReader.getInstance();

    // TODO 예외던지기
    public static void runGame() throws IllegalArgumentException {
        // TODO service.refreshComputerNumbers()로 리팩토링
        List<Integer> computerNumbers = computer.generateNumberList();
        boolean isAnswer = false;
        while (!isAnswer) {
            System.out.print(MESSAGE_GUESS_COMPUTER_NUMBERS);
            String guessingNumbers = keyboardReader.readIntegerLine();
            // TODO service.guessNumbers(int guessingNumbers)로 리팩토링
            List<Integer> playerNumbers = player.generateNumberList(guessingNumbers);
            // TODO 두 숫자를 비교한다. service.checkAnswer()로 리팩토링
//            isAnswer = checkAnswer(playerNumbers);
        }
        // TODO 숫자를 맞히면 안내메시지를 출력하고 게임 재시작/종료 여부를 결정한다.
//        System.out.println(MESSAGE_PLAYER_WIN);
//        System.out.println(MESSAGE_RESTART_OR_QUIT);
        // TODO keyboardReader로 정수값인지 검증해서 정수로 받기, 1이나 2가 아니면 예외발생
//        String inputNumbers = Console.readLine();
        // TODO 값에 따라 다시 runGame()을 실행하거나 어플리케이션 자체를 종료한다.
    }

    // TODO Service 클래스로 리팩토링하며 옮길것
    private static boolean checkAnswer(List<Integer> playerNumbers) {
        // TODO 두 숫자 비교하기
        return true;
    }
}
