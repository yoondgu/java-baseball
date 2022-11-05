package baseball.controller;

import baseball.vo.Computer;

import java.util.List;

public class GameController {
    private static final Computer computer = Computer.getInstance();

    public void runGame() {
        // TODO 컴퓨터 숫자를 생성한다.
        List<Integer> computerNumber = computer.generateNumberList();
        // TODO 숫자를 맞힐 때까지 숫자 맞히기를 반복 실행한다
        // TODO 숫자를 맞히면 안내메시지를 출력하고 게임 재시작/종료 여부를 결정한다.
//        runGame();
    }
}
