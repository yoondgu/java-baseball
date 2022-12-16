package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final BaseballGame baseballGame = new BaseballGame(new BaseballNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInformStart();
        baseballGame.start();
        List<Integer> playerNumbers = inputView.inputPlayerNumbers();
        // TODO 결과 출력
        // TODO 재시작 여부 입력
    }
}
