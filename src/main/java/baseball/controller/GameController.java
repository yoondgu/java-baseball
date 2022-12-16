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
        outputView.printResult(result);
        play();
        // TODO 재시작 여부 입력
    }

    private void play() {
        boolean willRepeat = true;
        while (willRepeat) {
            willRepeat = !playOneRound();
        }
    }

    private boolean playOneRound() {
        List<Integer> playerNumbers = inputView.inputPlayerNumbers();
        ResultDTO result = baseballGame.matchNumbers(playerNumbers);
        outputView.printResult(result);
        return result.hasPlayerWin();
    }
}
