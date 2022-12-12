package day02.part2;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        // Hole Daten
        List<Match> matches = holeDaten();

        // Match Bewerten
        int playerScore = matches.stream().mapToInt(Match::getScore).sum();
        System.out.println("Part 2 Score: " + playerScore);
    }

    private static List<Match> holeDaten() {
        return readFile().stream().map(Day2::holeMatches).toList();
    }

    private static Match holeMatches(String lines) {
        String[] turns = lines.split(" ");
        Symbol opponent = getSymbol(turns[0]);
        return new Match(opponent, getSymbolForResult(opponent, Result.fromString(turns[1])) );
    }


    public static List<String> readFile(){
        try {
            Path fileName = Paths.get("src/Day2/data.txt");
            return Files.readAllLines(fileName);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public static Symbol getSymbol(String input){
        return switch (input)
                {
                    case "A" -> Symbol.ROCK;
                    case "B" -> Symbol.PAPER;
                    case "C" -> Symbol.SCISSORS;
                    default -> throw new IllegalStateException("Wrong input");
                };
    }


    public static Symbol getSymbolForResult(Symbol opponent, Result result){
        return opponent.getSymbolToResult(result);
    }


}
