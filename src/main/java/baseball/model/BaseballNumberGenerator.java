package baseball.model;

import static baseball.model.domain.NumberRule.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < COUNT) {
            int randomNumber = pick(MINIMUM_VALUE, MAXIMUM_VALUE);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private int pick(int minimum, int maximum) {
        return Randoms.pickNumberInRange(minimum, maximum);
    }
}
