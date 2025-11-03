package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> summary;
    public LottoResult(Map<LottoRank, Integer> stats) {
        // EnumMap으로 복사 (LottoRank 키 전용)
        this.summary = new EnumMap<>(LottoRank.class);
        this.summary.putAll(stats);
    }


    void record(LottoRank rank) {
        summary.put(rank, summary.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> summary() {
        return Map.copyOf(summary);
    }

    public double profitRate(int totalCount) {
        double prize = summary.entrySet().stream()
                .mapToDouble(e -> e.getKey().prizeMoney() * e.getValue())
                .sum();
        return prize / (totalCount * 1000.0) * 100;
    }

}
