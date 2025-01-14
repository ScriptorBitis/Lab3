package entity.animals;

import interfaces.Swimmible;

public class Turtle extends Animal implements Swimmible {
    private final int swimmingSkill;

    public Turtle(String name, int energy, int size, int swimmingSkill) {
        super(name, energy, size + 101);
        this.swimmingSkill = swimmingSkill;

    }

    public void makeSound() {
        System.out.println("*Черепашьи звуки*");
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
        if (obj instanceof Animal) {
            return ((this.hashCode() == obj.hashCode()) && (this.getSize() == ((Animal) obj).getSize()));
        }// приведение в Animal
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return ((int) Math.pow(this.getName().length(), 5) ^ 135 + this.getSwimmingSkill());
    }
}
