import data.Animal;
import data.Zoo;
import data.tailed.TailedAnimal;
import data.winged.WingedAnimal;
import utility.EnityFactory;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo zoo=new Zoo();
        aggiungiAnimale(zoo);
        /*zoo.addAnimal(new Eagle.Builder().setHeight(12.0).setWingedSpan(12.9).build());
        zoo.addAnimal(new Eagle.Builder().setHeight(36.0).setWingedSpan(24.3).build());
        zoo.addAnimal(new Lion.Builder().setHeight(58).setTailLenght(25.6).build());*/

      /*System.out.println(zoo.shortest().getHeight());
        System.out.println(zoo.Highest().getHeight());
        System.out.println(zoo.longestTail().getTailLenght());
        System.out.println(zoo.widestWingSpan().getWingSpan());*/
    }

    public static void aggiungiAnimale(Zoo zoo){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Choose between eagle, tiger and lion");
            Animal.Builder builder= EnityFactory.getInstanceAnimalBuilder(sc.nextLine().toLowerCase().replaceAll(" ",""));
            builder.setFirstContact(Calendar.getInstance());
            System.out.println("Type the name");
            builder.setName(sc.nextLine());

            System.out.println("Type prefered food");
            builder.setPreferedFood(sc.nextLine());

            System.out.println("Type the age as integer");
            builder.setAge(sc.nextInt());

            System.out.println("Type the height as a decimal");
            builder.setHeight(sc.nextDouble());

            System.out.println("Type the weight as decimal");
            builder.setWeight(sc.nextDouble());

            if(builder instanceof WingedAnimal.Builder<?>){
                System.out.println("Type the wingspan as decimal");
                ((WingedAnimal.Builder)builder).setWingedSpan(sc.nextDouble());
            }else if(builder instanceof TailedAnimal.Builder<?>){
                System.out.println("Type the tailLenght as decimal");
                ((TailedAnimal.Builder)builder).setTailLenght(sc.nextDouble());
            }
            zoo.addAnimal(builder.build());
            System.out.println("Do yo want to add other animals? 2:no");
            if(sc.nextInt()==2){
                break;
            }
        }
        tabellaAnimali(zoo);
    }

    public static void tabellaAnimali(Zoo zoo){
        System.out.println("animale piu basso "+ zoo.shortest().getName()+" "+zoo.shortest().getHeight()+" cm");
        System.out.println("animale piu alto "+ zoo.highest().getName()+" "+zoo.highest().getHeight()+" cm");
        System.out.println("animale piu pesante "+ zoo.heaviest().getName()+" "+zoo.heaviest().getWeight()+" kg");
        System.out.println("animale piu leggero "+ zoo.lightest().getName()+" "+zoo.lightest().getWeight()+" kg");
        if(zoo.getAnimals().stream().anyMatch(a->a instanceof TailedAnimal)){
            System.out.println("animale con la coda piu lunga "+ zoo.longestTail().getName()+" "+zoo.longestTail().getTailLenght()+" cm");
        }
        if(zoo.getAnimals().stream().anyMatch(a->a instanceof WingedAnimal)){
            System.out.println("animale con le ali piu ampie "+ zoo.widestWingSpan().getName()+" "+zoo.widestWingSpan().getWingSpan()+" cm");
        }
     }

}