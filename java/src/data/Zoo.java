package data;

import data.tailed.TailedAnimal;
import data.winged.WingedAnimal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals=new ArrayList<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public Animal shortest(){
        return this.animals.stream().reduce((a,b)->a.getHeight()<b.getHeight()?a:b).get();
    }
    public Animal highest(){
        return this.animals.stream().reduce((a,b)->a.getHeight()>b.getHeight()?a:b).get();
    }
    public Animal lightest(){return this.animals.stream().reduce((a,b)->a.getWeight()<b.getWeight()?a:b).get();}
    public Animal heaviest(){return this.animals.stream().reduce((a,b)->a.getWeight()>b.getWeight()?a:b).get();}

    public TailedAnimal longestTail(){
        List<TailedAnimal> tailedAnimal= new ArrayList<>();
        this.animals.forEach((a)->{
            if(a instanceof TailedAnimal){
                tailedAnimal.add((TailedAnimal) a);
            }
        });

        if(tailedAnimal.size()>1) {
            return tailedAnimal.stream().reduce((a,b)->a.getTailLenght()>b.getTailLenght()?a:b).get();
        }else if(tailedAnimal.size()==1){
            return tailedAnimal.get(0);
        }
        return null;
    }

    public WingedAnimal widestWingSpan(){
        List<WingedAnimal> wingedAnimal= new ArrayList<>();
        this.animals.forEach((a)->{
            if(a instanceof WingedAnimal){
                wingedAnimal.add((WingedAnimal) a);
            }
        });

        if(wingedAnimal.size()>1){
            return wingedAnimal.stream().reduce((a,b)->a.getWingSpan()>b.getWingSpan()?a:b).get();
        }else if(wingedAnimal.size()==1){
            return wingedAnimal.get(0);
        }
        return null;
    }

    public List<Animal> getAnimals(){
        return animals;
    }
}
