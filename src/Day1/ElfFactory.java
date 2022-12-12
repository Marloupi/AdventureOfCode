package Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ElfFactory {

    public List<Elf> produce(String data) {
        return this.produce( Arrays.stream( data.split("\\n\\n") ).toList() );
    }


    public List<Elf> produce(List<String> data) {
        List<Elf> elfen = new ArrayList<>();
        int nr = 1;
        for( String elfData : data) {
            List<String> sCalorien = Arrays.stream( elfData.split("\\n") ).toList();
            List<Integer> calorien = sCalorien.stream().map(Integer::parseInt).collect(Collectors.toList());
            elfen.add( new Elf(nr, calorien) );
            nr++;
        }

        System.out.println("Anzahl Elfen <" +elfen.size()+ ">");
        return elfen;
    }
}
