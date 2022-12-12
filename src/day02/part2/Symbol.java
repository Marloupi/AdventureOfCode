package day02.part2;

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


    Symbol getSymbolToResult(Result r){
        if(Result.DRAW == r) return this;
        if(Result.WIN == r && this == ROCK) return PAPER;
        if(Result.WIN == r && this == PAPER) return SCISSORS;
        if(Result.WIN == r && this == SCISSORS) return ROCK;
        if(Result.LOOSE == r && this == ROCK) return SCISSORS;
        if(Result.LOOSE == r && this == PAPER) return ROCK;
        if(Result.LOOSE == r && this == SCISSORS) return PAPER;
        throw new IllegalStateException("Not possible");
    }
}
