package day02.part1;

public enum Result {
    LOOSE(0),
    DRAW(3),
    WIN(6),
    ;

    final int value;

    Result(int i) {
        this.value = i;
    }
}
