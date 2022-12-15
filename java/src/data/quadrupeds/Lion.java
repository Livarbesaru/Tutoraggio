package data.quadrupeds;

public class Lion extends QuadrupedsAnimal{

    public static class Builder extends QuadrupedsAnimal.Builder<Builder>{

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public QuadrupedsAnimal build() {
            return new Lion(this);
        }
    }
    protected Lion(Builder builder) {
        super(builder);
    }
}
