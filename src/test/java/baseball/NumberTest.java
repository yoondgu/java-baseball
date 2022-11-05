package baseball;

import baseball.vo.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest extends NsTest {
    @Test
    @DisplayName("컴퓨터숫자 생성 테스트")
    void 컴퓨터숫자_생성() {
        Computer computer = Computer.getInstance();
        List<Integer> computerNumbers = computer.generateNumberList();
        assertThat(computerNumbers)
                .isNotNull()
                .isInstanceOf(List.class);
        assertEquals(computerNumbers.size(), 3);
    }

    @Override
    public void runMain() { Application.main(new String[]{}); }
}
