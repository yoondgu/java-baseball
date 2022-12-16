package baseball.view.constant;

import baseball.model.domain.ResultDTO;

import java.util.function.Function;

public enum ResultFormat {
    HAS_ALL(result -> String.format("%d볼 %d스트라이크", result.getBallCount(), result.getStrikeCount())),
    ONLY_STRIKE(result -> String.format("%d스트라이크", result.getStrikeCount())),
    ONLY_BALL(result -> String.format("%d볼", result.getBallCount())),
    NOTHING(result -> "낫싱")
    ;

    private final Function<ResultDTO, String > outputFormatter;

    ResultFormat(Function<ResultDTO, String> outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public static String generateOutput(ResultDTO resultDTO) {
        if (resultDTO.getStrikeCount() == 0 && resultDTO.getBallCount() == 0) {
            return NOTHING.outputFormatter.apply(resultDTO);
        }
        if (resultDTO.getBallCount() == 0) {
            return ONLY_STRIKE.outputFormatter.apply(resultDTO);
        }
        if (resultDTO.getStrikeCount() == 0) {
            return ONLY_BALL.outputFormatter.apply(resultDTO);
        }
        return HAS_ALL.outputFormatter.apply(resultDTO);
    }
}
