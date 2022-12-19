package data.tailed.species;

import data.Animal;
import data.tailed.TailedAnimal;
import utility.Concat;

import java.lang.reflect.Field;
import java.util.*;

public class Lion extends TailedAnimal {


    public static class Builder extends TailedAnimal.Builder<Builder>{

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public TailedAnimal build() {
            return new Lion(this);
        }
    }
    protected Lion(Builder builder) {
        super(builder);
    }
}
