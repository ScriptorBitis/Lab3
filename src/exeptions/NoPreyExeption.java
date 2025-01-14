package exeptions;


public class NoPreyExeption extends RuntimeException {
    public NoPreyExeption(String message){
        super(message);
    }



    public String getMessage(String message) {
        return message;
    }
}
