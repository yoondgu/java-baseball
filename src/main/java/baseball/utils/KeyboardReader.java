package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

public class KeyboardReader {
    private KeyboardReader() { }
    private static final KeyboardReader instance = new KeyboardReader();
    public static KeyboardReader getInstance() {
        return instance;
    }

    private static final String INTEGER_REGEX = "-?\\d+";

    public String readIntegerLine() {
        String inputLine = readStringLine();
        if (!inputLine.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("[오류] 입력값은 정수만 허용됩니다.");
        }
        return inputLine;
    }

    private String readStringLine() {
        return Console.readLine();
    }
}