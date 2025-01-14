package interfaces;

public interface MakingSound {
    default void makeSound(){
        System.out.println("*Животные звуки*");
    }
}
