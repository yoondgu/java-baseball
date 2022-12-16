package baseball.model.domain;

import java.util.function.BiFunction;

public enum Match {
    STRIKE(Numbers::countStrike),
    BALL(Numbers::countBall)
    ;

    private final BiFunction<Numbers, Numbers, Integer> computeCount;

    Match(BiFunction<Numbers, Numbers, Integer> computeCount) {
        this.computeCount = computeCount;
    }

    public int count(Numbers numbers, Numbers otherNumbers) {
        return computeCount.apply(numbers, otherNumbers);
    }
}
