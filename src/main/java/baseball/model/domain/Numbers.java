package baseball.model.domain;

import static baseball.model.domain.NumberRule.*;

import baseball.model.constant.ErrorMessage;

import java.util.List;

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

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
