package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumberGenerator;
import baseball.model.domain.ResultDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BaseballGame baseballGame;

    public void run() {
        outputView.printInformStart();
        List<Integer> playerNumbers = inputView.inputPlayerNumbers();
        play();
    }

    private void play() {
        baseballGame = new BaseballGame(new BaseballNumberGenerator());
        boolean willRepeat = true;
        while (willRepeat) {
            willRepeat = !playOneRound();
        }
        outputView.printInformEnd();
        // TODO 재시작 여부 입력
    }

    private boolean playOneRound() {
        List<Integer> playerNumbers = inputView.inputPlayerNumbers();
        ResultDTO result = baseballGame.matchNumbers(playerNumbers);
        outputView.printResult(result);
        return result.hasPlayerWin();
    }
}
