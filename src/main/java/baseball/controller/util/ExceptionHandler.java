package baseball.controller.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {
    public static <T, R> R retryForIllegalArgument(Function<T, R> domain, Supplier<T> input, Consumer<String> exceptionMessageHandling) {
        while (true) {
            try {
                return domain.apply(input.get());
            } catch (IllegalArgumentException exception) {
                exceptionMessageHandling.accept(exception.getMessage());
            }
        }
    }
}
