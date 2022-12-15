package data.quadrupeds;

public class Tiger extends QuadrupedsAnimal{

    public static class Builder extends QuadrupedsAnimal.Builder<Builder>{

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public QuadrupedsAnimal build() {
            return new Tiger(this);
        }
    }
    protected Tiger(Builder builder) {
        super(builder);
    }
}
