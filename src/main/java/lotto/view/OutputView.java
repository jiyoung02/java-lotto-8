package lotto.view;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {

    public static  void printLottoNum(int num){
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<LottoRank, Integer> summary = result.summary();
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue;
            int count = summary.getOrDefault(rank, 0);
            System.out.println(rank.text() + " - " + count + "개");
        }
    }

    public static void printProfitRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }
}
