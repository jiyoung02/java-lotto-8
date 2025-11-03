package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

}