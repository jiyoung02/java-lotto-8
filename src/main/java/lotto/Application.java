package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private final static LottoService lottoService = new LottoService();
    public static void main(String[] args) {
        // 로또 구매
        int amount = InputView.readPurchaseAmount();
        lottoService.purchase(amount);

        lottoService.prepareWinningLotto(
                InputView.readWinningNumbers(),
                InputView.readBonusNumber()
        );


    }
}
