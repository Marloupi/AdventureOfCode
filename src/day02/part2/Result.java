package day02.part2;
public enum Result {
    LOOSE(0),
    DRAW(3),
    WIN(6),
    ;

    final int value;

    Result(int i) {
        this.value = i;
    }

    static Result fromString(String input){
        return switch (input) {
            case "X" -> LOOSE;
            case "Y" -> DRAW;
            case "Z" -> WIN;
            default -> throw new IllegalStateException("Wrong input");
        };
    }
}
