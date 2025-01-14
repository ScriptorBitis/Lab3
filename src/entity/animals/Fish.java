package entity.animals;

import interfaces.Swimmible;


public class Fish extends Animal implements Swimmible  {
    private final int swimmingSkill;

    public Fish(String name,int energy,int size,int swimmingSkill){
        super(name,energy,size);
        this.swimmingSkill=swimmingSkill;

    }

    public void makeSound(){
        System.out.println("Буль-буль-буль");
    }


    public int getSwimmingSkill() {
        return swimmingSkill;
    }


    public void swim() {
        setEnergy(getEnergy()-10+(int)(this.swimmingSkill/10));
        setSize(getSize()-5);

    }

    public void rest(){
        setEnergy(getEnergy()+5+(int)(this.swimmingSkill/10));
        setSize(getSize()+5);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal){
            return ((this.hashCode() == obj.hashCode()) && (this.getSize() == ((Animal) obj).getSize()));
        }// приведение в Animal
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return ((int) Math.pow(this.getName().length(), 5) ^ 135+this.getSwimmingSkill());
    }
}
