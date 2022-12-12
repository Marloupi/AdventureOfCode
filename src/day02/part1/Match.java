package day02.part1;

public record Match (Symbol opponent, Symbol player) {

    public int getScore() {
        return this.getResult().value + player.value;
    }

    public Result getResult(){
        return player.getResult(opponent);
    }
}