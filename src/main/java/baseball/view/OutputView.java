package baseball.view;

import baseball.model.domain.ResultDTO;
import baseball.view.constant.OutputMessage;

public class OutputView {
    public void printInformStart() {
        System.out.println(OutputMessage.GAME_START);
    }

    public void printResult(ResultDTO result) {
    }
}
