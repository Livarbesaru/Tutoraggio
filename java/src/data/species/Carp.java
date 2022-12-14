package data.species;

import data.categories.Fish;

public class Carp extends Fish {

    public static class Builder extends Fish.Builder<Builder>{

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public Fish build() {
            return new Carp(this);
        }
    }
    protected Carp(Builder builder) {
        super(builder);
    }
}
