package data.tailed.species;

import data.Animal;
import data.tailed.TailedAnimal;
import utility.Concat;

import java.lang.reflect.Field;
import java.util.Set;

public class Tiger extends TailedAnimal {

    public static class Builder extends TailedAnimal.Builder<Builder>{

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public TailedAnimal build() {
            return new Tiger(this);
        }
    }
    protected Tiger(Builder builder) {
        super(builder);
    }
}
