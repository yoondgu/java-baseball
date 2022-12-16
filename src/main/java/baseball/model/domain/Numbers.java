package baseball.model.domain;

import static baseball.model.domain.NumberRule.*;

import baseball.model.constant.ErrorMessage;

import java.util.List;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_INVALID_COUNT);
        }
        if (hasInvalidRangeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_INVALID_RANGE_NUMBER);
        }
    }

    private boolean hasInvalidRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> (number < MINIMUM_VALUE || number > MAXIMUM_VALUE));
    }

    public int findNumberByIndex(int index){
        // TODO index bound 예외처리
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countStrike(Numbers other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(index -> isStrike(index, other))
                .count();
    }

    public int countBall(Numbers other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(index -> isBall(index, other))
                .count();
    }

    private boolean isStrike(int index, Numbers other) {
        return numbers.get(index) == other.findNumberByIndex(index);
    }

    private boolean isBall(int index, Numbers other) {
        return !isStrike(index, other) && other.contains(numbers.get(index));
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
