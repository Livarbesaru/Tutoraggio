package data;

import java.lang.reflect.Field;
import java.util.*;

public class Zoo {
    private HashMap<Class,List<? extends Animal>> animals=new HashMap<Class,List<? extends Animal>>();

    public <T extends Animal> void addAnimal(T animal){
        List<T> listSpecie=null;
        if(animals.containsKey(animal.getClass())){
            listSpecie= (List<T>) animals.get(animal.getClass());
            listSpecie.add(animal);
        }else{
            listSpecie=new ArrayList<T>();
            listSpecie.add(animal);
            animals.put(animal.getClass(),listSpecie);
        }
    }
    private Animal heaviestAnimal(List<? extends Animal> animals){
        return animals.stream().reduce((a,b)->a.getWeight()<b.getWeight()?a:b).get();
    }

    private Animal lightiestAnimal(List<? extends Animal> animals){
        return animals.stream().reduce((a,b)->a.getWeight()>b.getWeight()?a:b).get();
    }

    private Animal highestAnimal(List<? extends Animal> animals){
        return animals.stream().reduce((a,b)->a.getHeight()<b.getHeight()?a:b).get();
    }

    private Animal shortestAnimal(List<? extends Animal> animals){
        return animals.stream().reduce((a,b)->a.getHeight()>b.getHeight()?a:b).get();
    }

    public HashMap<Class,List<? extends Animal>> getAnimals(){
        return animals;
    }

    public Set<Field> distinctiveCharacteristics(List<? extends Animal> specie){
        Set<Field> fields=null;
        if(!specie.isEmpty()){
            fields=Set.of(specie.get(0).getCharacteristics());
        }
        return fields;
    }

    public void animalStats(){
        Map<Field,List<Animal>> specialInFields=new HashMap<Field,List<Animal>>();
        for(List<? extends Animal> a:animals.values()){
            if(!a.isEmpty()){
                Animal highest=highestAnimal(a);
                Animal shortest=shortestAnimal(a);
                Animal lightest=lightiestAnimal(a);
                Animal heaviest=heaviestAnimal(a);

                String typeClass=highest.getClass().getSimpleName();
                System.out.println("-----------------"+typeClass+"----------------");
                System.out.println("shortest "+ typeClass+" "+highest.getName()+" "+highest.getHeight()+" cm");
                System.out.println("highest "+ typeClass+" "+shortest.getName()+" "+shortest.getHeight()+" cm");
                System.out.println("lightest "+ typeClass+" "+ heaviest.getName()+" "+heaviest.getWeight()+" kg");
                System.out.println("heaviest "+ typeClass+" "+ lightest.getName()+" "+lightest.getWeight()+" kg");

                Set<Field> fields1=distinctiveCharacteristics(a);
                
                for(Field f:fields1){
                    if(f.getType() != String.class && f.getType() != boolean.class && f.getType() != Calendar.class && f.getType() != Date.class){
                       Animal bestInField=a.stream().reduce((a1,a2)->
                          Double.parseDouble( a1.getFieldValue(f).toString()) >
                           Double.parseDouble(a2.getFieldValue(f).toString())
                               ?a1:a2
                       ).get();
                        if(specialInFields.containsKey(f)){
                            specialInFields.get(f).add(bestInField);
                        }else{
                            List<Animal> listToAdd=new ArrayList<>();
                            listToAdd.add(bestInField);
                            specialInFields.put(f,listToAdd);
                        }
                    }
                }

            }
        }
        specialInFields.forEach((key,value)->
            System.out.println("\nthe winner in "+key.getName()+" is \n"+
                    value.stream().reduce((a,b)->
                        Double.parseDouble(a.getFieldValue(key).toString())
                            > Double.parseDouble(b.getFieldValue(key).toString())?a:b
                    ).get().toString()
            )
        );
    }
}
