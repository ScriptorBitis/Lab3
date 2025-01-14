package entity.items;
import entity.animals.Animal;

public record FishingLine(Quality quality) {

    public void calcStress(Animal animal){
        if (animal.getSize()>this.quality.getCoefficient()){
            System.out.println("Леска сильно натянулась");
        }
        else {
            System.out.println("Леска слабо натягивается");
        }
    }
}
