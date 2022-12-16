package baseball.controller;

import baseball.model.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final BaseballGame baseballGame = new BaseballGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInformStart();
        // TODO 게임 실행 (컴퓨터 숫자 생성)
        List<Integer> playerNumbers = inputView.inputPlayerNumbers();
        System.out.println(playerNumbers);
        // TODO 결과 출력
        // TODO 재시작 여부 입력
    }
}
