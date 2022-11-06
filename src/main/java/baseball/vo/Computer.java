package baseball.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Numbers {
    private Computer() { }
    private static final Computer instance = new Computer();
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

    @Override
    boolean isAddable(List<Integer> numberList, int number) {
        if (numberList.contains(number)) {
            return false;
        }
        return true;
    }
}
