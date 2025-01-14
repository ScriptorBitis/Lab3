package other;

import entity.animals.Animal;
import entity.animals.Fish;
import entity.animals.Turtle;

import java.util.ArrayList;

public class Sea {
    static public ArrayList<Animal> sea;

    private static int generateEnergy() {
        return (int) (Math.round(Math.random() * 100));

    }

    private static int generateSize() {
        return (int) (Math.round(Math.random() * 100));

    }

    private static int generateSwimmingSkill() {
        return (int) (Math.round(Math.random() * 100));

    }


    public static void createALotOfFish(int quantuty) {

        ArrayList<Animal> aLotOfFish = new ArrayList<>(100);
        //почитать про <Fish> и <>

        for (int i = 0; i < quantuty; i++) {

            String objectName = "Fish #" + i;
            int energy = generateEnergy();//(int) (Math.round(Math.random() * 100))
            int size = generateSize();//(int) (Math.round(Math.random() * 100))
            int swimmingSkill = generateSwimmingSkill();//(int) (Math.round(Math.random() * 100))

            aLotOfFish.add(new Fish(objectName, energy, size, swimmingSkill));
        }

        String objectName = "A very interesting turtle";
        int energy = generateEnergy();//(int) (Math.round(Math.random() * 100))
        int size = generateSize();//(int) (Math.round(Math.random() * 100))
        int swimmingSkill = generateSwimmingSkill();//(int) (Math.round(Math.random() * 100))
        aLotOfFish.add(new Turtle(objectName, energy, size, swimmingSkill));


        //System.out.println(aLotOfFish.get(99).getSize());
        //System.out.println(aLotOfFish.get(99).getName());
        //System.out.println(aLotOfFish);
        // System.out.println(aLotOfFish.size());

        sea = aLotOfFish;
    }
}
