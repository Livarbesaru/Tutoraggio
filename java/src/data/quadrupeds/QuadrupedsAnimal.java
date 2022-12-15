package data.quadrupeds;

import data.Animal;

public abstract class QuadrupedsAnimal extends Animal {
    private double tailLenght;
    abstract public static class Builder<T extends Animal.Builder<T>> extends Animal.Builder<T>{
        private double tailLenght;

        public T setTailLenght(double lenght){
            this.tailLenght=lenght;
            return self();
        }
        public abstract T self();

        public abstract QuadrupedsAnimal build();
    }

    protected QuadrupedsAnimal(Builder builder) {
        super(builder);
        this.tailLenght= builder.tailLenght;
    }
}
