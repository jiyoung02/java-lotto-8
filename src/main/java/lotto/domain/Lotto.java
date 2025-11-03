package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean invalid = numbers.stream().anyMatch(n -> n < 1 || n > 45);
        if (invalid) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public long matchCountWith(Lotto other) {
        return numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }
}
