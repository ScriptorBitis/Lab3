package exeptions;


public class NoPreyExeption extends RuntimeException {
    public NoPreyExeption(String message){
        super(message);
    }


    @Override
    public String getMessage() {
        return super.getMessage()+"Наглядный пример переопределения гемесседге";
    }
}
