package exeptions;

public class NoFishingrodExeption extends RuntimeException{
    public NoFishingrodExeption(String message){
        super(message);
    }

    public String getMessage(String message) {
        return message;
    }
}
