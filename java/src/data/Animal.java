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
        this.firstContact=Calendar.getInstance();
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

    private Field[] getCharacteristicsTillAnimal(Class animalClass) {
        if(animalClass == Animal.class.getSuperclass()){
            return new Field[]{};
        }else{
            return (Concat.concat(animalClass.getDeclaredFields(),getCharacteristicsTillAnimal(animalClass.getSuperclass())));
        }
    }

    public Field[] getCharacteristicsTillAnimal() {
        if(this.getClass() == Animal.class.getSuperclass()){
            return new Field[]{};
        }else{
            return (Concat.concat(this.getClass().getDeclaredFields(),getCharacteristicsTillAnimal(this.getClass().getSuperclass())));
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

    public Object getFieldValue(Field f){
        try {
            f.setAccessible(true);
            return f.get(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
            String s="";
            s+="Class: " +this.getClass().getSimpleName()+" \n";
            for(Field f:this.getCharacteristicsTillAnimal()){
                if(getFieldValue(f)==null){
                    s+=f.getName()+": Unknown"+"\n";
                }else{
                    if(f.getName().equals("firstContact")){
                        s+=f.getName()+": "+((Calendar)getFieldValue(f)).getTime()+"\n";
                    }else{
                        s+=f.getName()+": "+getFieldValue(f).toString()+"\n";
                    }
                }
            }
            return s;
    }
}
