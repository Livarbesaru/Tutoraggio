package data.categories;

import data.Animal;

public abstract class Fish extends Animal {

    private double pinLenght;
    abstract public static class Builder<T extends Animal.Builder<T>> extends Animal.Builder<T>{
        private double pinLenght;

        public T setPinLenght(double lenght){
            this.pinLenght=lenght;
            return self();
        }

        public abstract T self();

        public abstract Fish build();
    }
    protected Fish(Builder builder) {
        super(builder);
        this.pinLenght= builder.pinLenght;
    }
}
