package data.tailed;

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
