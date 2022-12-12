package day01;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) {
        System.out.println("START");
        try {
            // Hole Data
            log(1);
            String data = holeData();
            System.out.println(data);


            // Formatiere Data zu Elf
            log(2);
                //formatiereElf(data);
            List<Elf> elfen = new ElfFactory().produce(data);

            /*
                // Hole Gröeßte Calorien Zahl
                log(3);
                Elf max = elfen.stream().max(Comparator.comparing(Elf::getAllCalories)).orElse(null);
                System.out.println(max.toString());
           */

            // Sortieren
            log(3);
            List<Elf> sortedElfen = elfen.stream().sorted(Comparator.comparing(Elf::getAllCalories).reversed()).toList();
            sortedElfen.forEach(e -> System.out.println(e.getAllCalories()));

            int top3 = sortedElfen.get(0).getAllCalories() + sortedElfen.get(1).getAllCalories() + sortedElfen.get(2).getAllCalories();
            System.out.println("TOP3: " +top3);

        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("ENDE");
    }


    private static String holeData() throws Exception{
        String file ="src/Day1/data.txt";
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


    private static void formatiereElf(String data) {
        List<String> split = Arrays.stream( data.split("\\n\\n") ).toList();
        split.forEach(x -> {
                System.out.println(x);
                System.out.println("  "); });



        System.out.println("INTEGER");
        for( String elfData : split) {
            System.out.println("  ");
            List<String> sCalorien = Arrays.stream( elfData.split("\\n") ).toList();
            List<Integer> calorien = sCalorien.stream().map(Integer::parseInt).collect(Collectors.toList());
            calorien.forEach(x -> {
                System.out.println(x); });
        }
    }


    private static void log(int nr) {
        System.out.println("PART " +nr+ "\n"
                + "--------------------------------------------------");
    }


    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
