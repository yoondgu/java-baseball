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
        play();
    }

    private void play() {
        baseballGame = new BaseballGame(new BaseballNumberGenerator());
        repeatRound();
        outputView.printInformEnd();
        restartOrQuit();
    }

    private void restartOrQuit() {
        if (inputView.inputWillRestart()) {
            play();
        }
    }

    private void repeatRound() {
        List<Integer> playerNumbers = inputView.inputPlayerNumbers();
        ResultDTO result = baseballGame.matchNumbers(playerNumbers);
        outputView.printResult(result);
        if (!result.hasPlayerWin()) {
            repeatRound();
        }
    }
}
