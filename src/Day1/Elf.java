package Day1;

import java.util.List;

public class Elf {
    private int number;
    private List<Integer> calorien;

    public Elf(int number, List<Integer> calorien) {
        System.out.println("Elf Nr <" +number+ "> Anzahl calorien <" +calorien.size()+ ">");
        this.number = number;
        this.calorien = calorien;
    }


    public int getAllCalories() {
        // Stream Collect Stuff
        return calorien.stream().reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return "Elf{" +
                "number=" + number +
                ", calorien=" + getAllCalories() +
                '}';
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }


    public List<Integer> getCalorien() {
        return calorien;
    }
    public void setCalorien(List<Integer> calorien) {
        this.calorien = calorien;
    }

}
