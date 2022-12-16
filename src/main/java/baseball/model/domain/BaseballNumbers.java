package baseball.model.domain;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private final List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        BaseballNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public int findNumberByIndex(int index){
        // TODO index bound 예외처리
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countStrike(BaseballNumbers other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(index -> isStrike(index, other))
                .count();
    }

    public int countBall(BaseballNumbers other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(index -> isBall(index, other))
                .count();
    }

    private boolean isStrike(int index, BaseballNumbers other) {
        return numbers.get(index) == other.findNumberByIndex(index);
    }

    private boolean isBall(int index, BaseballNumbers other) {
        return !isStrike(index, other) && other.contains(numbers.get(index));
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
