package data.tailed.species;

import data.tailed.TailedAnimal;

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
