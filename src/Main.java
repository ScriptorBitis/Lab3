import entity.humans.Fisherman;
import interfaces.Eater;
import other.Narrator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Narrator.startStory();

        // локальный класс

        Eater calc = new Eater(){
            @Override
            public void eat() {
                System.out.println("m1");
            }

            @Override
            public void starve() {
                System.out.println("m2");
            }

        };
        

        //Animal fish = new Fish("РЫБА", 15, 15, 16);
        //System.out.println(fish.getName());
        //fish.swim(); а потому что в Animal нет swim
        //добавить для добычи метод get
    }
}
