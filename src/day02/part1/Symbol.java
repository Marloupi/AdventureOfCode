package day02.part1;

public enum Symbol {
    ROCK(1),
    PAPER(2),
    SCISSORS(3),
    ;

    final int value;

    Symbol(int i) {
        this.value = i;
    }

    /**
     * @param o opponent
     * @return
     */
    Result getResult(Symbol o){
        if(this == o) return Result.DRAW;
        if(this == ROCK && o == SCISSORS) return Result.WIN;
        if(this == ROCK && o == PAPER) return Result.LOOSE;
        if(this == PAPER && o == SCISSORS) return Result.LOOSE;
        if(this == PAPER && o == ROCK) return Result.WIN;
        if(this == SCISSORS && o == PAPER) return Result.WIN;
        if(this == SCISSORS && o == ROCK) return Result.LOOSE;
        throw new IllegalStateException("Not possible");
    }
}
