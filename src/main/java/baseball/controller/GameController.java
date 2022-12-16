package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumberGenerator;
import baseball.model.domain.ResultDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final BaseballGame baseballGame = new BaseballGame(new BaseballNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInformStart();
        List<Integer> playerNumbers = inputView.inputPlayerNumbers();
        ResultDTO result = baseballGame.matchNumbers(playerNumbers);
        // TODO 결과 출력
//        outputView.printResult(result);
        // TODO hasPlayerWin = true가 아니면 다시 반복
        // TODO 재시작 여부 입력
    }
}
