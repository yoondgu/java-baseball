package baseball.vo;

import java.util.ArrayList;
import java.util.List;

public class Player extends Numbers {
    private Player() { }
    private static final Player instance = new Player();
    public static Player getInstance() {
        return instance;
    }

    public List<Integer> generateNumberList(String guessingNumbers) {
        if (!checkNumberCount(guessingNumbers)) {
            throw new IllegalArgumentException("[오류] 숫자의 개수는 3개입니다.");
        }
        List<Integer> numberList = new ArrayList<>();
        insertGuessingNumbers(numberList, guessingNumbers);
        return numberList;
    }

    private boolean checkNumberCount(String guessingNumbers) {
        if (guessingNumbers.length() != NUMBER_COUNT) {
            return false;
        }
        return true;
    }

    private void insertGuessingNumbers(List<Integer> numberList, String guessingNumbers) {
        int index = 0;
        while (numberList.size() < NUMBER_COUNT) {
            String guessingNumber = guessingNumbers.substring(index, index+1);
            int value = Integer.parseInt(guessingNumber);
            addValidNumber(numberList, value);
            index++;
        }
    }
}
