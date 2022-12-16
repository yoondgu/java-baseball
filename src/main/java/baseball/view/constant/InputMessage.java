package baseball.view.constant;

import static baseball.view.constant.ActionCommand.NO;
import static baseball.view.constant.ActionCommand.YES;

public class InputMessage {
    public static final String INPUT_BALL_NUMBERS = "숫자를 입력해주세요 : ";
    public static final String INPUT_WILL_RESTART = "게임을 새로 시작하려면 " + YES.getKey()
            + ", 종료하려면 " + NO.getKey() + "를 입력하세요.";
}
