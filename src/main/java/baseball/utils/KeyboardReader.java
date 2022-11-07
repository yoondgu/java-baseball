package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

public class KeyboardReader {
    private static final String INTEGER_REGEX = "-?\\d+";

    private KeyboardReader() { }
    private static final KeyboardReader instance = new KeyboardReader();
    public static KeyboardReader getInstance() {
        return instance;
    }

    public String readLineOnlyInteger() {
        String inputLine = readLineForAll();
        if (!inputLine.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("[오류] 입력값은 정수만 허용됩니다.");
        }
        return inputLine;
    }

    private String readLineForAll() {
        return Console.readLine();
    }
}