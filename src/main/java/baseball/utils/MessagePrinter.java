package baseball.utils;

import baseball.messages.OutputMessage;

public class MessagePrinter {
    public static void print(OutputMessage content) {
        System.out.print(content.text());
    }

    public static void printLine(OutputMessage content) {
        System.out.println(content.text());
    }

    public static void printLine(String text) {
        System.out.println(text);
    }
}
