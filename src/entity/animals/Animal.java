package entity.animals;

import interfaces.MakingSound;


public abstract class Animal implements MakingSound {
    private String name;
    private int energy;
    private int size;

    public Animal(String name, int energy,int size) {
        this.name = name;
        this.energy = energy;
        this.size = size;
    }
    //??????????
    public abstract void makeSound();

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
