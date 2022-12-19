package data;

import data.interfaces.Specie;
import utility.Concat;

import java.lang.reflect.Field;
import java.util.Calendar;

public abstract class Animal implements Specie {
    private String name;
    private String preferedFood;
    private int age;
    private Calendar firstContact;
    private double weight;
    private double height;

        public abstract static class Builder<T extends Builder<T>>{
            private String name;
            private String preferedFood;
            private int age;
            private Calendar firstContact;
            private double weight;
            private double height;

            public T setName(String name){
                this.name=name;
                return self();
            }

            public T setPreferedFood(String food){
                this.preferedFood=food;
                return self();
            }

            public T setAge(int age){
                this.age=age;
                return self();
            }

            public T setFirstContact(Calendar firstContact){
                this.firstContact=firstContact;
                return self();
            }

            public T setHeight(double height){
                this.height=height;
                return self();
            }

            public T setWeight(double weight){
                this.weight=weight;
                return self();
            }
            protected abstract  T self();
            public abstract Animal build();
        }
    protected Animal(Builder<?> builder){
        this.name=builder.name;
        this.preferedFood= builder.preferedFood;
        this.age=builder.age;
        this.firstContact=builder.firstContact;
        this.weight=builder.weight;
        this.height=builder.height;
    }

    private Field[] getCharacteristics(Class animalClass) {
        if(animalClass == Animal.class){
            return new Field[]{};
        }else{
            return (Concat.concat(animalClass.getDeclaredFields(),getCharacteristics(animalClass.getSuperclass())));
        }
    }

    public Field[] getCharacteristics() {
        if(this.getClass() == Animal.class){
            return new Field[]{};
        }else{
            return (Concat.concat(this.getClass().getDeclaredFields(),getCharacteristics(this.getClass().getSuperclass())));
        }
    }

    public String getName() {
        return name;
    }

    public String getPreferedFood() {
        return preferedFood;
    }

    public int getAge() {
        return age;
    }

    public Calendar getFirstContact() {
        return firstContact;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public <T> T getFieldValue(Field f,Class<T> t){
        try {
            f.setAccessible(true);
            return (T)f.get(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
