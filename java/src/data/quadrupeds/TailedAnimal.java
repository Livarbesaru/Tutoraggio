package data.quadrupeds;

import data.Animal;

public abstract class TailedAnimal extends Animal {
    private double tailLenght;
    abstract public static class Builder<T extends Animal.Builder<T>> extends Animal.Builder<T>{
        private double tailLenght;

        public T setTailLenght(double lenght){
            this.tailLenght=lenght;
            return self();
        }
        public abstract T self();

        public abstract TailedAnimal build();
    }
    public double getTailLenght(){
        return tailLenght;
    }
    protected TailedAnimal(Builder builder) {
        super(builder);
        this.tailLenght= builder.tailLenght;
    }
}
