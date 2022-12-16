package data;

import data.tailed.TailedAnimal;
import data.winged.WingedAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo {
    private List<Animal> animals=new ArrayList<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
    private TailedAnimal longestTail(List<TailedAnimal> tailedAnimals){
        return tailedAnimals.stream().reduce((a,b)->a.getTailLenght()>b.getTailLenght()?a:b).get();
    }

    private WingedAnimal widestWingSpan(List<WingedAnimal> wingedAnimals){
        return wingedAnimals.stream().reduce((a,b)->a.getWingSpan()>b.getWingSpan()?a:b).get();
    }

    private Animal heaviestAnimal(List<Animal> animals){
        return animals.stream().reduce((a,b)->a.getWeight()<b.getWeight()?a:b).get();
    }

    private Animal lightiestAnimal(List<Animal> animals){
        return animals.stream().reduce((a,b)->a.getWeight()>b.getWeight()?a:b).get();
    }

    private Animal highestAnimal(List<Animal> animals){
        return animals.stream().reduce((a,b)->a.getHeight()<b.getHeight()?a:b).get();
    }

    private Animal shortestAnimal(List<Animal> animals){
        return animals.stream().reduce((a,b)->a.getHeight()>b.getHeight()?a:b).get();
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    private List<List<? extends Animal>> sortSpecies(List<Animal> animals){
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
    }

    public void animalStats(){
        List<List<? extends Animal>> species= sortSpecies(this.animals);
        List<WingedAnimal> winged=new ArrayList<>();
        List<TailedAnimal> tailed=new ArrayList<>();
        for(List<? extends Animal> a:species){
            if(a.size()>0){
                Animal highest=highestAnimal((List<Animal>) a);
                Animal shortest=shortestAnimal((List<Animal>) a);
                Animal lightest=lightiestAnimal((List<Animal>) a);
                Animal heaviest=heaviestAnimal((List<Animal>) a);

                String typeClass=heaviest.getClass().getSimpleName();
                System.out.println(typeClass);
                System.out.println("-----------------"+typeClass+"----------------");
                System.out.println("shortest "+ typeClass+" "+highest.getName()+" "+highest.getHeight()+" cm");
                System.out.println("highest "+ typeClass+" "+shortest.getName()+" "+shortest.getHeight()+" cm");
                System.out.println("lightest "+ typeClass+" "+ heaviest.getName()+" "+heaviest.getWeight()+" kg");
                System.out.println("heaviest "+ typeClass+" "+ lightest.getName()+" "+lightest.getWeight()+" kg");
                if(a.get(0) instanceof TailedAnimal){
                    TailedAnimal longTail=longestTail((List<TailedAnimal>) a);
                    System.out.println(typeClass+" with longest tail "+ longTail.getName()+" "+longTail.getTailLenght()+" cm");
                    tailed.add(longTail);
                }
                if(a.get(0) instanceof WingedAnimal){
                    WingedAnimal widestWing=widestWingSpan((List<WingedAnimal>) a);
                    System.out.println(typeClass+" with widest wingspan "+ widestWing.getName()+" "+widestWing.getWingSpan()+" cm");
                    winged.add(widestWing);
                }
            }
        }
        if(winged.size()>0){
            WingedAnimal wingWinner=winged.stream().reduce((w1,w2)->w1.getWingSpan() > w2.getWingSpan()?w1:w2).get();
            System.out.println("The winged animal with widest wing is a "+wingWinner.getClass().getSimpleName()+" "+wingWinner.getName()+" with "+ wingWinner.getWingSpan()+" cm");
        }
        if(tailed.size()>0){
            TailedAnimal tailWinner=tailed.stream().reduce((t1,t2)->t1.getTailLenght() > t2.getTailLenght()?t1:t2).get();
            System.out.println("The winged animal with widest wing is a "+tailWinner.getClass().getSimpleName()+" "+tailWinner.getName()+" with "+ tailWinner.getTailLenght()+" cm");
        }
    }
}
