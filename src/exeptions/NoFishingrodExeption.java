package exeptions;

public class NoFishingrodExeption extends RuntimeException{

    public NoFishingrodExeption(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"Наглядный пример переопределения гемесседге";
    }
}
