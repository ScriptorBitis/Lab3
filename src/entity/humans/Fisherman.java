package entity.humans;

import entity.animals.Animal;
import entity.animals.Turtle;
import interfaces.Eater;
import interfaces.Fishing;
import entity.items.*;
import exeptions.*;
import other.*;

import java.util.ArrayList;

public class Fisherman extends Human implements Fishing, Eater {
    private int skill;// TODO: добавить голод, влияющий на историю-ГОТОВО
    private int kindness;//TODO: раздробить на любовь и доброту -ГОТОВО
    private int love;//TODO: Переделать в массив добычи-ГОТОВО
    private int hunger;
    private final int hungerLimit;
    private FishingRod fishingRod;
    private Animal prey;  // добыча в руке.В данный момент.Буквально
    private ArrayList<Animal> bag; //Чет опять проблемы с гетами...P.S. Получилось!


    @Override
    public void a() {
        Fishing.super.a();
    }

    public Fisherman(String name, int skill, int kindness, int love, int hunger, int hungerLimit) {
        super(name);
        this.skill = skill;
        this.kindness = kindness;
        this.love = love;
        this.hunger = hunger;
        this.hungerLimit= hungerLimit;
    }

    //КАК КРУТО. ЭТО ПРЯМ ПОБЕДА
    public void setFishingrod(String name, Quality quality, FishingLine fishingLine) {
        this.fishingRod = new FishingRod(name, quality, fishingLine);
        this.bag = new ArrayList<>();
    }

    public FishingRod getFishingrod() {
        return this.fishingRod;
    }

    public void setKindness(int kindness) {
        this.kindness = kindness;
    }

    public int getKindness() {
        return kindness;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getSkill() {
        return skill;
    }

    public Animal getPrey() {
        return this.prey;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }


    @Override
    public String toString() {
        return "Рыбак по имени " + this.getName() + " с навыком рыбалки, равным " + this.getSkill() + " и любовью к природе, равной " + getKindness();
    }

    @Override
    public int hashCode() {
        return ((int) Math.pow(this.getName().length(), 15) ^ 135 & 246);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fisherman) {
            return ((this.hashCode() == obj.hashCode()) && (this.kindness == ((Fisherman) obj).getKindness()));
        }// приведение в Fisherman
        else {
            return false;
        }
    }

    public void catchFish() throws NoFishingrodExeption {
        System.out.println(this.getName() + " начал ловить рыбу");

        if (this.getFishingrod() == null) {
            throw new NoFishingrodExeption("Ошибка вызвана из-за отсутствия удочки");
        }
        int rand = (int) (Math.random() * Sea.sea.size()); // выбираем случайную рыбу

        this.getFishingrod().fishingLine().calcStress(Sea.sea.get(rand));// вычисляем, натягивается ли leska

        if (Sea.sea.get(rand).getEnergy() + Sea.sea.get(rand).getSize() < this.skill + this.fishingRod.quality().getCoefficient()) {
            System.out.println(this.getName() + " поймал " + Sea.sea.get(rand).getName());
            this.prey = Sea.sea.get(rand);
            //Поймаl рыбу-> рыбы больше нет в море
            Sea.sea.remove(this.prey);
            makeDecision();
        } else {
            System.out.println(this.getName() + " не смог поймать " + Sea.sea.get(rand).getName());
            System.out.println(this.getName() + " делает выводы и улучшает свой навык рыбака");
            setSkill(getSkill() + 1);
        }
    }

    public void makeDecision() throws NoPreyExeption {
        if (this.getPrey() == null) {
            throw new NoPreyExeption("Ошибка вызвана из-за отсутствия добычи");
        }
        if (this.prey instanceof Turtle) {
            Narrator.endOfTheStory = false;
        }
        if (this.love + this.kindness - prey.getSize() - (100 - getHunger()) > 0) {
            System.out.println(this.getName() + " думает:" + " \"Лучше я буду голодать сегодня,чем убью молодую " + this.prey.getName() + "\"-, и отпускает обратно в море");
            Sea.sea.add(this.prey);
            this.prey = null;

        } else {
            System.out.println(this.getName() + " думает:" + " \"Я сегодня что-то голодный и злой, да и " + this.prey.getName() + "  больно большое\"-, кладет ее в собственный рюкзак");
            this.bag.add(this.prey);
            this.prey = null;
        }
        System.out.println("Внутренности рюкзака- "+bag);
    }

    public void eat() throws IndexOutOfBoundsException {
        System.out.println("Состояние голода:"+getHunger());
        setHunger(getHunger() - 25);
        if (this.bag.get(0)==null){
            throw new IndexOutOfBoundsException ();
        }
        if (hunger <= (int) this.hungerLimit / 2) {
            System.out.println(this.getName()+" съедает "+this.bag.get(0)+",чтобы не умереть от голода");
            this.bag.remove(0);
            setHunger(getHunger() + 100);
        }
        System.out.println("Состояние голода под конец дня:"+getHunger());
    }
    // TODO: раздробить голодание и поедание - СДЕАЛАНО
    public void starve(){
        if (this.hunger <= 0) {
            System.out.println(this.getName() + " умирает от голода");
            Narrator.endOfTheStory = false;
        }

    }
}

