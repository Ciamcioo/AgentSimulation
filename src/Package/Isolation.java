package Package;
import Map.Map;

public class Isolation extends Package{
    public Isolation(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn){
        super(coordinateX, coordinateY, mapPartOf, chanceOfSpawn);
    }
    @Override
    public String toString(){
        return "I";
    }
}
