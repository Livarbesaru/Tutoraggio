import data.Zoo;
import data.quadrupeds.Lion;
import data.winged.Eagle;
import data.winged.WingedAnimal;

public class Main {
    public static void main(String[] args) {
        Zoo zoo=new Zoo();
        zoo.addAnimal(new Eagle.Builder().setHeight(12.0).setWingedSpan(12.9).build());
        zoo.addAnimal(new Eagle.Builder().setHeight(36.0).setWingedSpan(24.3).build());
        zoo.addAnimal(new Lion.Builder().setHeight(58).setTailLenght(25.6).build());

        System.out.println(zoo.shortest().getHeight());
        System.out.println(zoo.Highest().getHeight());
        System.out.println(zoo.longestTail().getTailLenght());
        System.out.println(zoo.widestWingSpan().getWingSpan());
    }
}