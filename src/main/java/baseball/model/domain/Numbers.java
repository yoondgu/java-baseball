package baseball.model.domain;

import baseball.model.constant.ErrorMessage;

import java.util.List;

public class Numbers {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int COUNT = 3;

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
                .anyMatch(number -> (number < MIN_VALUE || number > MAX_VALUE));
    }
}
