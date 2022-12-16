package baseball.view;

import baseball.view.constant.InputMessage;
import baseball.view.util.NumberParser;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> inputPlayerNumbers() {
        System.out.print(InputMessage.INPUT_BALL_NUMBERS);
        String line = Console.readLine();
        return Arrays.stream(line.split(""))
                .map(NumberParser::parseDigit)
                .collect(Collectors.toList());
    }
}
