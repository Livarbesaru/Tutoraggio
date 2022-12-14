package utility;

import data.Animal;
import data.species.Lion;
import data.species.Tiger;
import data.species.Eagle;

public class EntityFactory {

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
