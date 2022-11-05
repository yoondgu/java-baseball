package baseball.vo;

import java.util.List;

abstract class Numbers {
    static final int NUMBER_COUNT = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;
//    List<Integer> numberList;

    abstract List<Integer> generateNumberList();
}
