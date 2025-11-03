package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.test.NsTest;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest extends NsTest  {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 이하 또는 45 초과인 경우 예외가 발생한다.")
    @Test
    void 로또_번호_범위_예외() {
        // 0과 46은 허용 범위(1~45) 밖
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @DisplayName("당첨번호 및 보너스 번호 입력 요청이 정상적으로 출력된다.")
    @Test
    void 당첨번호_입력_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "당첨 번호를 입력해 주세요.",
                            "보너스 번호를 입력해 주세요."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("발행된 로또와 당첨번호를 비교하여 등수별 결과가 출력된다.")
    @Test
    void 당첨_확인_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원)",
                            "4개 일치 (50,000원)",
                            "5개 일치 (1,500,000원)",
                            "5개 일치, 보너스 볼 일치 (30,000,000원)",
                            "6개 일치 (2,000,000,000원)"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("당첨 통계와 총 수익률이 형식에 맞게 출력된다.")
    @Test
    void 결과_출력_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 1개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
