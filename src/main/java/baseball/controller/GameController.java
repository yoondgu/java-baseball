package baseball.controller;

import baseball.controller.util.ExceptionHandler;
import baseball.model.BaseballGame;
import baseball.model.BaseballNumberGenerator;
import baseball.model.domain.ResultDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        ResultDTO result = ExceptionHandler.retryForIllegalArgument(baseballGame::matchNumbers, inputView::inputPlayerNumbers, outputView::printError);
        outputView.printResult(result);
        if (!result.hasPlayerWin()) {
            repeatRound();
        }
    }
}
