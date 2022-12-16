package baseball.model.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

class NumbersTest {
    @Test
    void 숫자생성_범위_예외발생() {
        assertThatThrownBy(() -> new Numbers(List.of(0,1,2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자생성_크기_예외발생() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,3,9)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}