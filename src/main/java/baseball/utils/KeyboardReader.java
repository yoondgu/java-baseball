package baseball.utils;

import baseball.utils.resources.InputKey;
import camp.nextstep.edu.missionutils.Console;

public class KeyboardReader {
    private static final String INPUT_RESTART = InputKey.RESTART.text();
    private static final String INPUT_QUIT = InputKey.QUIT.text();

    private static final String REGEX_INTEGER = "-?\\d+";

    private KeyboardReader() { }

    public static boolean readWillRestart() {
        String inputLine = readLineForAll();
        if (INPUT_RESTART.equals(inputLine)) {
            return true;
        }
        if (INPUT_QUIT.equals(inputLine)) {
            return false;
        }
        throw new IllegalArgumentException("[오류] 1, 2 외의 키워드를 입력하였습니다.");
    }

    public static String readLineOnlyInteger() {
        String inputLine = readLineForAll();
        if (!inputLine.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException("[오류] 입력값은 정수만 허용됩니다.");
        }
        return inputLine;
    }

    private static String readLineForAll() {
        return Console.readLine();
    }
}