package data.winged;

import data.Animal;

public abstract class WingedAnimal extends Animal {
    private double wingSpan;

    abstract public static class Builder<T extends Animal.Builder<T>> extends Animal.Builder<T>{
        private double wingSpan;
        public T setWingedSpan(double wingSpan){
            this.wingSpan=wingSpan;
            return self();
        }
        public abstract T self();

        public abstract WingedAnimal build();
    }
    protected WingedAnimal(Builder<?> builder) {
        super(builder);
        this.wingSpan= builder.wingSpan;
    }
}
