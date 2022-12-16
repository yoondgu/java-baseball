package baseball.model;

import baseball.model.domain.Match;
import baseball.model.domain.NumberRule;
import baseball.model.domain.Numbers;
import baseball.model.domain.ResultDTO;

import java.util.List;

public class BaseballGame {
    private final Numbers computer;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.computer = new Numbers(numberGenerator.generate());
    }

    public ResultDTO matchNumbers(List<Integer> playerNumbers) {
        Numbers player = new Numbers(playerNumbers);
        int strikeCount = Match.STRIKE.count(computer, player);
        int ballCount = Match.BALL.count(computer, player);
        return new ResultDTO(strikeCount, ballCount, hasPlayerWin(strikeCount));
    }

    private boolean hasPlayerWin(int strikeCount) {
        return strikeCount == NumberRule.COUNT;
    }
}
