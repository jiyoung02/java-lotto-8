package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class LottoService {
    private  final List<Lotto> purchased = new ArrayList<>();
    private WinningLotto winning;

    public  void purchase(int amount) {
        int count = amount / 1000;
        OutputView.printLottoNum(count);
        for (int i = 0; i < count; i++) {
            Lotto lotto = createRandomLotto();
            purchased.add(lotto);
            lotto.printLotto();
        }
    }

    private  Lotto createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void prepareWinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winning = new WinningLotto(numbers, bonusNumber);
    }
}
