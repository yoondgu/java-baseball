package baseball;

import baseball.vo.Computer;
import baseball.vo.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {
    @Test
    @DisplayName("컴퓨터숫자 생성 : 랜덤 숫자를 생성하여 리스트에 저장해 반환한다.")
    void 컴퓨터숫자_생성() {
        Computer computer = Computer.getInstance();
        List<Integer> computerNumbers = computer.generateNumberList();
        assertThat(computerNumbers)
                .isNotNull()
                .isInstanceOf(List.class);
        assertEquals(computerNumbers.size(), 3);
    }

    @Test
    @DisplayName("사용자숫자 생성 : 올바른 값을 입력받은 경우 리스트에 저장해 반환한다.")
    void 사용자숫자_생성_올바른_값을_입력받은_경우() {
        Player player = Player.getInstance();
        List<Integer> guessingNumbers = player.generateNumberList("123");
        assertThat(guessingNumbers)
                .isNotNull()
                .isInstanceOf(List.class);
        assertEquals(guessingNumbers.size(), 3);
    }

    @Test
    @DisplayName("사용자숫자 생성 : 범위 밖의 숫자를 입력받은 경우 예외발생")
    void 사용자숫자_생성_범위_밖의_숫자를_입력받은_경우_예외발생() {
        Player player = Player.getInstance();
        assertThatThrownBy(() -> player.generateNumberList("108"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 숫자는 1보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("사용자숫자 생성 : 첫번째 숫자로 0을 입력받은 경우 예외발생")
    void 사용자숫자_생성_첫번째_숫자로_0을_입력받은_경우_예외발생() {
        Player player = Player.getInstance();
        assertThatThrownBy(() -> player.generateNumberList("023"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 숫자는 1보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("사용자숫자 생성 : 정해진 개수보다 많은 숫자를 입력받은 경우 예외발생")
    void 사용자숫자_생성_정해진_개수보다_많은_숫자를_입력받은_경우_예외발생() {
        Player player = Player.getInstance();
        assertThatThrownBy(() -> player.generateNumberList("4567"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 숫자의 개수는 3개입니다.");
    }

    @Test
    @DisplayName("사용자숫자 생성 : 중복된 숫자를 입력받은 경우 예외발생")
    void 사용자숫자_생성_중복된_숫자를_입력받은_경우_예외발생() {
        Player player = Player.getInstance();
        assertThatThrownBy(() -> player.generateNumberList("992"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 모든 숫자는 서로 같을 수 없습니다.");
    }
}
