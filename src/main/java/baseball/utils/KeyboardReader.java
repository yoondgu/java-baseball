package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

public class KeyboardReader {
    private static final String INPUT_RESTART = "1";
    private static final String INPUT_QUIT = "2";
    private static final String REGEX_INTEGER = "-?\\d+";

    private KeyboardReader() { }
    private static final KeyboardReader instance = new KeyboardReader();
    public static KeyboardReader getInstance() {
        return instance;
    }

    public boolean readWillRestart() {
        String inputLine = readLineForAll();
        if (INPUT_RESTART.equals(inputLine)) {
            return true;
        }
        if (INPUT_QUIT.equals(inputLine)) {
            return false;
        }
        throw new IllegalArgumentException("[오류] 1, 2 외의 키워드를 입력하였습니다.");
    }

    public String readLineOnlyInteger() {
        String inputLine = readLineForAll();
        if (!inputLine.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException("[오류] 입력값은 정수만 허용됩니다.");
        }
        return inputLine;
    }

    private String readLineForAll() {
        return Console.readLine();
    }
}