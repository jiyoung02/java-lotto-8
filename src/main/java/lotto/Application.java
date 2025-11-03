package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private final static LottoService lottoService = new LottoService();
    public static void main(String[] args) {
        int amount = InputView.readPurchaseAmount();
        lottoService.purchase(amount);
    }
}
