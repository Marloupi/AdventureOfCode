package Day2;

public enum Result {
    LOOSE(0),
    DRAW(1),
    WIN(3),
    ;

    final int value;

    Result(int i) {
        this.value = i;
    }
}
