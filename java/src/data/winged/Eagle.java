package data.winged;

import data.Animal;

public class Eagle extends WingedAnimal{

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
