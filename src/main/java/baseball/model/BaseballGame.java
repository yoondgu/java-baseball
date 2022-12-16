package baseball.model;

import baseball.model.domain.Numbers;

import java.util.List;

public class BaseballGame {
    private final Numbers computer;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.computer = new Numbers(numberGenerator.generate());
    }

    // TODO 결과 반환하도록 수정
    public void matchNumbers(List<Integer> playerNumbers) {
        Numbers player = new Numbers(playerNumbers);
        // TODO 숫자 비교해서 매치 종류 별 계산
    }
}
