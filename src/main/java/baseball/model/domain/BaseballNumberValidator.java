package baseball.model.domain;

import static baseball.model.domain.BaseballNumberRule.*;

import baseball.model.constant.ErrorMessage;

import java.util.List;

public class BaseballNumberValidator {
    public static void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_INVALID_COUNT);
        }
        if (hasInvalidRangeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_INVALID_RANGE_NUMBER);
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_INVALID_DUPLICATED);
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> numbers) {
        int removeDuplicatedSize = (int) numbers.stream()
                .distinct().count();
        return removeDuplicatedSize != numbers.size();
    }

    private static boolean hasInvalidRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> (number < MINIMUM_VALUE || number > MAXIMUM_VALUE));
    }
}
