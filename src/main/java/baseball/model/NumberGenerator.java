package baseball.model;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Integer> generate();
}
