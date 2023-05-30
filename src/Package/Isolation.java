package Package;
import Map.Map;

public class Isolation extends Package{
    public Isolation(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn){ // Konstrukotr klasy Isolation, który wywołuje konstruktor klasy Package
        super(coordinateX, coordinateY, mapPartOf, chanceOfSpawn);
    }
    @Override
    public String toString(){ // Reprezentacje Isolation w konsoli
        return "I";
    }

}
