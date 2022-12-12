package Day2;

public enum Symbol {
    ROCK(1),
    PAPER(2),
    SCISSORS(3),
    ;

    final int value;

    Symbol(int i) {
        this.value = i;
    }
}
