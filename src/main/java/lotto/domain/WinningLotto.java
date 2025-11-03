package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }
    public LottoResult evaluate(Lotto lotto) {
        int matched = (int) lotto.matchCountWith(winningNumbers);
        boolean bonusMatched = lotto.hasNumber(bonusNumber);
        return LottoResult.of(matched, bonusMatched);
    }
}