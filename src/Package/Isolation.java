package Package;
import Map.Map;

public class Isolation extends Package{
    public Isolation(int coordinateX,int coordinateY, Map mapPartOf){

        super(coordinateX, coordinateY, mapPartOf);
    }
    @Override
    public String toString(){
        return "I";
    }
}
