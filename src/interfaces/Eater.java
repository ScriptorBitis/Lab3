package interfaces;

public interface Eater {
    public void eat  ();
    public void starve();
    default void a(){
        System.out.println("ПРИКОЛЫ");
    }
}
