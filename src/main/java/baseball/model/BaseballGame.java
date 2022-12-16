package baseball.model;

import baseball.model.domain.Numbers;

public class BaseballGame {
    private final Numbers computer;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.computer = new Numbers(numberGenerator.generate());
    }

    public void start() {
        // TODO
    }
}
