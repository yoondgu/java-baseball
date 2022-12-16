package baseball.model.domain;

public class ResultDTO {
    private final int strikeCount;
    private final int ballCount;
    private final boolean hasPlayerWin;

    public ResultDTO(int strikeCount, int ballCount, boolean hasPlayerWin) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.hasPlayerWin = hasPlayerWin;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean hasPlayerWin() {
        return hasPlayerWin;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "strikeCount=" + strikeCount +
                ", ballCount=" + ballCount +
                ", hasPlayerWin=" + hasPlayerWin +
                '}';
    }
}
