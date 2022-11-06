package baseball.vo;

import java.util.List;

public class Numbers {
    static final int NUMBER_COUNT = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    void addValidNumber(List<Integer> numberList, int number) {
        if (isAddable(numberList, number)) {
            numberList.add(number);
        }
    }

    boolean isAddable(List<Integer> numberList, int number) {
        // TODO 범위 검증은 User Numbers에서만 구현하고 예외발생시킬지 검토할 것.
        if (END_INCLUSIVE < number) {
            throw new IllegalArgumentException("[오류] 숫자는 " + END_INCLUSIVE + "보다 클 수 없습니다.");
        }
        if (START_INCLUSIVE > number) {
            throw new IllegalArgumentException("[오류] 숫자는 " + START_INCLUSIVE + "보다 작을 수 없습니다.");
        }
        if (numberList.contains(number)) {
            throw new IllegalArgumentException("[오류] 모든 숫자는 서로 같을 수 없습니다.");
        }
        return true;
    }
}
