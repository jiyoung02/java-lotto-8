package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private final static LottoService lottoService = new LottoService();
    public static void main(String[] args) {
        // 로또 구매
        int amount = InputView.readPurchaseAmount();
        lottoService.purchase(amount);

        // 당첨 로또 설정
        lottoService.prepareWinningLotto(
                InputView.readWinningNumbers(),
                InputView.readBonusNumber()
        );

        // 당첨 여부 확인
        LottoResult result= lottoService.evaluateResults();

        // 결과 출력
        OutputView.printResult(result);
        double rate = result.profitRate(amount);
        OutputView.printProfitRate(rate);


    }
}
