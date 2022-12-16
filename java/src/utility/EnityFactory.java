package utility;

import data.Animal;
import data.tailed.species.Lion;
import data.tailed.species.Tiger;
import data.winged.species.Eagle;

public class EnityFactory {

    public static Animal.Builder getInstanceAnimalBuilder(String animal){
        switch (animal){
            case "lion":
                return new Lion.Builder();
            case "tiger":
                return new Tiger.Builder();
            case "eagle":
                return new Eagle.Builder();
            default:
                throw new RuntimeException("errore");
        }
    }
}
