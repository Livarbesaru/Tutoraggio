package data;

import data.tailed.TailedAnimal;
import data.winged.WingedAnimal;
import data.winged.species.Eagle;
import utility.Concat;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {
    private HashMap<Class,List<? extends Animal>> animals=new HashMap();

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
    private TailedAnimal longestTail(List<? extends TailedAnimal> tailedAnimals){
        return tailedAnimals.stream().reduce((a,b)->a.getTailLenght()>b.getTailLenght()?a:b).get();
    }

    private WingedAnimal widestWingSpan(List<? extends WingedAnimal> wingedAnimals){
        return wingedAnimals.stream().reduce((a,b)->a.getWingSpan()>b.getWingSpan()?a:b).get();
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

    /*private List<List<? extends Animal>> sortSpecies(List<Animal> animals){
        List<Class> species=new ArrayList<>();
        List<List<? extends Animal>> animalsPerSpecies=new ArrayList<>();
        animals.forEach((x)->{
            if(!(species.stream().anyMatch(el->el == x.getClass()))){
                species.add(x.getClass());
            }
        });
        for(Class c:species){
            animalsPerSpecies.add((List<? extends Animal>) animals.stream().filter((x)->x.getClass() == c).collect(Collectors.toList()));
        }
        return animalsPerSpecies;
    }*/

    public Set<Field> distinctiveCharacteristics(List<? extends Animal> specie){
        Set<Field> fields=null;
        if(specie.size()>0){
            fields=Set.of(specie.get(0).getCharacteristics());
        }
        return fields;
    }

    public void animalStats(){
        Map<String,List<Animal>> specialInFields=new HashMap<String,List<Animal>>();
        for(List<? extends Animal> a:animals.values()){
            if(a.size()>0){
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
                
                for(Field f:distinctiveCharacteristics(a)){
                    if(!(f.getType() == String.class) && !(f.getType() != boolean.class)){
                       Animal bestInField=a.stream().reduce((a1,a2)->
                          Double.parseDouble( a1.getFieldValue(f,f.getType()).toString()) >
                           Double.parseDouble(a2.getFieldValue(f,f.getType()).toString())
                               ?a1:a2
                       ).get();
                        if(specialInFields.containsKey(f.getName())){
                            specialInFields.get(f.getName()).add(bestInField);
                        }else{
                            List<Animal> listToAdd=new ArrayList<>();
                            listToAdd.add(bestInField);
                            specialInFields.put(f.getName(),listToAdd);
                        }
                    }
                }
            }
        }
    }
}
