package baseball.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KeyboardReaderTest extends NsTest {
    private static final KeyboardReader keyboardReader = KeyboardReader.getInstance();
    private String inputLine = "";

    @Test
    @DisplayName("키보드 숫자 입력받기 : 정수값을 입력받은 경우 해당 문자열을 그대로 반환")
    void 키보드_숫자_입력받기_정수값을_입력받은_경우() {
        run("1");
        assertThat(inputLine)
                .isInstanceOf(String.class)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("1");
    }

    @Test
    @DisplayName("키보드 숫자 입력받기 :0으로 시작하는 정수값을 입력받은 경우 해당 문자열을 그대로 반환")
    void 키보드_숫자_입력받기_0으로_시작하는_정수값을_입력받은_경우() {
        run("023");
        assertThat(inputLine)
                .isInstanceOf(String.class)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("023");
    }

    @Test
    @DisplayName("키보드 숫자 입력받기 : 정수가 아닌 값을 입력받은 경우 예외발생")
    void 키보드_숫자_입력받기_정수가_아닌_값을_입력받은_경우_예외발생() {
        assertThatThrownBy(() -> run("ABC"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 입력값은 정수만 허용됩니다.");
    }

    @Test
    @DisplayName("키보드 숫자 입력받기 : 수식 형식을 입력받은 경우 예외발생")
    void 키보드_숫자_입력받기_수식_형식을_입력받은_경우_예외발생() {
        assertThatThrownBy(() -> run("200-13"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 입력값은 정수만 허용됩니다.");
    }

    @Override
    public void runMain() {
        inputLine = keyboardReader.readIntegerLine();
    }
}