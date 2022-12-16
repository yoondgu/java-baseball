package baseball.model;

import baseball.model.domain.Match;
import baseball.model.domain.BaseballNumberRule;
import baseball.model.domain.BaseballNumbers;
import baseball.model.domain.ResultDTO;

import java.util.List;

public class BaseballGame {
    private final BaseballNumbers computer;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.computer = new BaseballNumbers(numberGenerator.generate());
    }

    public ResultDTO matchNumbers(List<Integer> playerNumbers) {
        BaseballNumbers player = new BaseballNumbers(playerNumbers);
        int strikeCount = Match.STRIKE.count(computer, player);
        int ballCount = Match.BALL.count(computer, player);
        return new ResultDTO(strikeCount, ballCount, hasPlayerWin(strikeCount));
    }

    private boolean hasPlayerWin(int strikeCount) {
        return strikeCount == BaseballNumberRule.COUNT;
    }
}
