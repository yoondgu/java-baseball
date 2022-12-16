package baseball.model.domain;

import java.util.function.BiFunction;

public enum Match {
    STRIKE(BaseballNumbers::countStrike),
    BALL(BaseballNumbers::countBall)
    ;

    private final BiFunction<BaseballNumbers, BaseballNumbers, Integer> computeCount;

    Match(BiFunction<BaseballNumbers, BaseballNumbers, Integer> computeCount) {
        this.computeCount = computeCount;
    }

    public int count(BaseballNumbers baseballNumbers, BaseballNumbers otherBaseballNumbers) {
        return computeCount.apply(baseballNumbers, otherBaseballNumbers);
    }
}
