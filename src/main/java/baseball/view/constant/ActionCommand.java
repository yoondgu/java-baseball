package baseball.view.constant;

import java.util.Arrays;
import java.util.Objects;

public enum ActionCommand {
    YES("1", true),
    NO("2", false);

    private final String key;
    private final boolean isYes;

    ActionCommand(String key, boolean isYes) {
        this.key = key;
        this.isYes = isYes;
    }

    public static ActionCommand find(String key) {
        return Arrays.stream(values())
                .filter(value -> Objects.equals(value.key, key))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ErrorMessage.INPUT_INVALID_COMMAND);
                });
    }

    public boolean isYes() {
        return isYes;
    }
}
