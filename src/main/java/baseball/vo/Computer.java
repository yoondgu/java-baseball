package baseball.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Numbers {
    private static final Computer instance = new Computer();
    private Computer() { }
    public static Computer getInstance() {
        return instance;
    }

    public List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        insertRandomUniqueNumbers(numberList);
        return numberList;
    }

    private void insertRandomUniqueNumbers(List<Integer> numberList) {
        while (numberList.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addValidNumber(numberList, randomNumber);
        }
    }

    // TODO 추후 User의 Number 기능 구현 시 Numbers 클래스로 묶을지 검토할 것.
    private void addValidNumber(List<Integer> numberList, int number) {
        if (isAddable(numberList, number)) {
            numberList.add(number);
        }
    }

    // TODO 추후 User의 Number 기능 구현 시 Numbers 클래스로 묶을지 검토할 것.
    private boolean isAddable(List<Integer> numberList, int number) {
        // TODO 범위 검증은 User Numbers에서만 구현하고 예외발생시킬지 검토할 것.
        if (END_INCLUSIVE < number) {
            return false;
        }
        if (START_INCLUSIVE > number) {
            return false;
        }
        if (numberList.contains(number)) {
            return false;
        }
        return true;
    }
}
