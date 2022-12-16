package data;

import data.tailed.TailedAnimal;
import data.tailed.species.Lion;
import data.tailed.species.Tiger;
import data.winged.WingedAnimal;
import data.winged.species.Eagle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo {
    private List<Animal> animals=new ArrayList<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

  /*  public Animal shortest(){
        return this.animals.stream().reduce((a,b)->a.getHeight()<b.getHeight()?a:b).get();
    }
    public Animal highest(){
        return this.animals.stream().reduce((a,b)->a.getHeight()>b.getHeight()?a:b).get();
    }
    public Animal lightest(){return this.animals.stream().reduce((a,b)->a.getWeight()<b.getWeight()?a:b).get();}
    public Animal heaviest(){return this.animals.stream().reduce((a,b)->a.getWeight()>b.getWeight()?a:b).get();}
    */
    private TailedAnimal longestTail(List<TailedAnimal> tailedAnimals){
        return tailedAnimals.stream().reduce((a,b)->a.getTailLenght()>b.getTailLenght()?a:b).get();
    }

    private WingedAnimal widestWingSpan(List<WingedAnimal> wingedAnimals){
        return wingedAnimals.stream().reduce((a,b)->a.getWingSpan()>b.getWingSpan()?a:b).get();
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public void animalStats(){
        List<Eagle> eagles=new ArrayList<>();
        List<Tiger> tigers=new ArrayList<>();
        List<Lion> lions=new ArrayList<>();
        this.animals.forEach((a)->{
            if(a instanceof Eagle){
                eagles.add((Eagle) a);
            }else if(a instanceof Tiger){
                tigers.add((Tiger) a);
            }else if(a instanceof Lion){
                lions.add((Lion) a);
            }
        });
        /*List<Animal> eagles=this.animals.stream().filter(a->a instanceof Eagle).collect(Collectors.toList());
        List<Animal> lions=this.animals.stream().filter(a->a instanceof Lion).collect(Collectors.toList());
        List<Animal> tigers=this.animals.stream().filter(a->a instanceof Tiger).collect(Collectors.toList());*/
        List<List<? extends Animal>> species= Arrays.asList(eagles,lions,tigers);
        for(List<? extends Animal> a:species){
            if(a.size()>0){
                Animal highest=a.stream()
                        .reduce((animal1,animal2)->
                                animal1.getHeight()<animal2.getHeight()?animal1:animal2).get();
                Animal shortest=a.stream()
                        .reduce((animal1,animal2)->
                                animal1.getHeight()>animal2.getHeight()?animal1:animal2).get();
                Animal lightest=a.stream()
                        .reduce((animal1,animal2)->
                                animal1.getWeight()>animal2.getWeight()?animal1:animal2).get();
                Animal heaviest=a.stream()
                        .reduce((animal1,animal2)->
                                animal1.getWeight()<animal2.getWeight()?animal1:animal2).get();

                System.out.println("-----------------"+heaviest.getClass().getName().toUpperCase()+"----------------");
                System.out.println("shortest "+ shortest.getClass().getName()+" "+highest.getName()+" "+highest.getHeight()+" cm");
                System.out.println("highest "+ highest.getClass().getName()+" "+shortest.getName()+" "+shortest.getHeight()+" cm");
                System.out.println("lightest "+ lightest.getClass().getName()+" "+ heaviest.getName()+" "+heaviest.getWeight()+" kg");
                System.out.println("heaviest "+ heaviest.getClass().getName()+" "+ lightest.getName()+" "+lightest.getWeight()+" kg");
                if(a.get(0) instanceof TailedAnimal){
                    TailedAnimal longTail=longestTail((List<TailedAnimal>) a);
                    System.out.println(longTail.getClass().getName()+" with longest tail "+ longTail.getName()+" "+longTail.getTailLenght()+" cm");
                }
                if(a.get(0) instanceof WingedAnimal){
                    WingedAnimal widestWing=widestWingSpan((List<WingedAnimal>) a);
                    System.out.println(widestWing.getClass().getName()+" with widest wingspan "+ widestWing.getName()+" "+widestWing.getWingSpan()+" cm");
                }
            }
        }
    }
}
