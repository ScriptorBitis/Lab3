package interfaces;

public interface Fishing {
    void catchFish();
    void makeDecision();
    default void a(){
        System.out.println("ПРИКОЛЫ");
    }
}
