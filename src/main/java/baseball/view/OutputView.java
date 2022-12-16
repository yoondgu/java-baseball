package baseball.view;

import baseball.model.domain.ResultDTO;
import baseball.view.constant.OutputMessage;
import baseball.view.constant.ResultFormat;

public class OutputView {
    public void printInformStart() {
        System.out.println(OutputMessage.GAME_START);
    }

    public void printResult(ResultDTO result) {
        System.out.println(ResultFormat.generateOutput(result));
    }

    public void printInformEnd() {
        System.out.println(OutputMessage.GAME_END);
    }
}
