package entity.items;

public enum Quality {
    GREAT(100),
    GOOD(50),
    NORMAL(0),
    BAD(-25),
    AWFUL(-50);

    private int coefficient;

    private Quality(int coefficient) {
        this.coefficient = coefficient;
    }


    public int getCoefficient() {
        return coefficient;
    }
}
