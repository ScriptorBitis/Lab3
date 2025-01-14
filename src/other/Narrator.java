package other;

import entity.items.*;
import exeptions.*;
import entity.humans.*;

import java.util.NoSuchElementException;

public class Narrator {
    static private int dayCounter = 1;
    static public boolean endOfTheStory = true;


    public static void startStory() {
        Fisherman urashima = new Fisherman("Urashima", 200, 60,60,200,200);
        //urashima.setFishingrod("Удочка", Quality.GREAT, new FishingLine(Quality.GREAT));
        Sea.createALotOfFish(50);
        //System.out.println(urashima.getFishingrod().toString());


        while (endOfTheStory) {
            System.out.println("\nНачинается день номер " + dayCounter + "\n");

            try {
                urashima.catchFish();
            } catch (NoFishingrodExeption exeption) {
                System.out.println(exeption.getMessage());
                System.out.println("Рыбак тратит день на создание удочки из подручных средств");
                urashima.setFishingrod("Удочка", Quality.GREAT, new FishingLine(Quality.GREAT));
            }catch (NoPreyExeption exeption){
                System.out.println(exeption.getMessage());
            }
            try {
                urashima.eat();
            }catch (IndexOutOfBoundsException e){
                System.out.println("Рыбак сегодня голодает");
            urashima.starve();
            }


            dayCounter++;
        }




    }// будет цикл while пока не поймает черепаху
}
