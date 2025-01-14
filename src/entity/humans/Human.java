package entity.humans;

public abstract class Human {
    private final String name;
    //final, т.к. на основе него генерируется hashCode
    public Human(String name) {
        this.name = name;
    }

    /**
    public void setName(String name) {
        this.name = name;
    }
     **/
    public String getName() {
        return name;
    }
}
