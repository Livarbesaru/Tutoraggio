package data.winged.species;

import data.Animal;
import data.winged.WingedAnimal;
import utility.Concat;

import java.lang.reflect.Field;
import java.util.Set;

public class Eagle extends WingedAnimal {

    public static class Builder extends WingedAnimal.Builder<Builder>{

        public Builder(){}

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public WingedAnimal build() {
            return new Eagle(this);
        }
    }
    protected Eagle(Builder builder) {
        super(builder);
    }

}
