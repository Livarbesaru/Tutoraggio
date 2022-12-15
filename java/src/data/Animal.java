package data;

import java.util.Calendar;

public abstract class Animal {
    private String name;
    private String preferedFood;
    private int age;
    private Calendar firstContact;
    private double weight;
    private double height;

        protected abstract static class Builder<T extends Builder<T>>{
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

            public T serHeight(double height){
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

}
