import data.Animal;
import data.Zoo;
import data.tailed.TailedAnimal;
import data.tailed.species.Lion;
import data.tailed.species.Tiger;
import data.winged.WingedAnimal;
import data.winged.species.Eagle;
import utility.EntityFactory;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo zoo=new Zoo();
        zoo.addAnimal(new Eagle.Builder().setName("gg").setWeight(12).setHeight(12.0).setWingedSpan(12.9).build());
        zoo.addAnimal(new Eagle.Builder().setName("vv").setWeight(6).setHeight(36.0).setWingedSpan(24.3).build());
        zoo.addAnimal(new Lion.Builder().setName("hh").setWeight(48).setHeight(58).setTailLenght(25.6).build());
        zoo.addAnimal(new Lion.Builder().setName("yy").setWeight(49).setHeight(57).setTailLenght(33.6).build());
        zoo.addAnimal(new Tiger.Builder().setName("hh").setWeight(48).setHeight(58).setTailLenght(25.6).build());
        zoo.addAnimal(new Tiger.Builder().setName("DD").setWeight(52).setHeight(36).setTailLenght(29.6).build());
        aggiungiAnimale(zoo);
      /*System.out.println(zoo.shortest().getHeight());
        System.out.println(zoo.Highest().getHeight());
        System.out.println(zoo.longestTail().getTailLenght());
        System.out.println(zoo.widestWingSpan().getWingSpan());
        */
    }

    public static void aggiungiAnimale(Zoo zoo){
        Scanner sc=new Scanner(System.in);
        /*while(true){
            System.out.println("-------------------------------------------");
            System.out.println("Choose between eagle, tiger and lion");
            String animal=sc.nextLine();
            Animal.Builder builder= EntityFactory.getInstanceAnimalBuilder(animal.toLowerCase().replaceAll(" ",""));
            builder.setFirstContact(Calendar.getInstance());
            System.out.println("Type the name");
            builder.setName(sc.nextLine());

            System.out.println("Type prefered food");
            builder.setPreferedFood(sc.nextLine());

            System.out.println("Type the age as integer");
            builder.setAge(Integer.parseInt(sc.nextLine()));

            System.out.println("Type the height as a decimal");
            builder.setHeight(Double.parseDouble(sc.nextLine()));

            System.out.println("Type the weight as decimal");
            builder.setWeight(Double.parseDouble(sc.nextLine()));

            if(builder instanceof WingedAnimal.Builder<?>){
                System.out.println("Type the wingspan as decimal");
                ((WingedAnimal.Builder)builder).setWingedSpan(Double.parseDouble(sc.nextLine()));
            }else if(builder instanceof TailedAnimal.Builder<?>){
                System.out.println("Type the tailLenght as decimal");
                ((TailedAnimal.Builder)builder).setTailLenght(Double.parseDouble(sc.nextLine()));
            }
            zoo.addAnimal(builder.build());
            System.out.println("Do yo want to add other animals? 2:no, if you want to continue press SEND");
            if(sc.nextLine().equals("2")){
                break;
            }
        }*/
        zoo.animalStats();
    }

}